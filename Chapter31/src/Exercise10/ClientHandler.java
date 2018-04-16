package Exercise10;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Map;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class ClientHandler implements Runnable {

	private TextArea taLog;
	private String name = "NotDefined";
	private int thisClientID;
	
	//hold the reference to the tables
	private Map<Integer, DataOutputStream> toClients;
	private Map<Integer, DataInputStream> fromClients;

	public ClientHandler(TextArea taLog, Map<Integer, DataOutputStream> toClients, 
			Map<Integer, DataInputStream> fromClients, int thisClientID) throws IOException {
		this.taLog = taLog;
		this.thisClientID = thisClientID;
		this.toClients = toClients;
		this.fromClients = fromClients;
	}

	public void run() {
		try {

			//acquire new client nickname
			name = fromClients.get(thisClientID).readUTF();

			//inform everyone that a new client with a given name has connected
			for(DataOutputStream out : toClients.values()) 
				out.writeUTF(name + " connected to the server.");

			while(true) { 

				// this was not finishing listening because the communication thread 
				// on the client side was still alive,
				// despite the fact, that I closed the application, every thread has to be DAEMON !!!

				// listen to the incoming messages of the clients
				String message = fromClients.get(thisClientID).readUTF();

				// and send it to all the other clients
				for(DataOutputStream out : toClients.values())
					out.writeUTF(name + ": " + message);
			}
		} catch(IOException ex) {
			Platform.runLater(() -> taLog.appendText(ex.getMessage() + '\n'));
		} finally {
			
			//client has disconnected or dropped, clear connections after him
			fromClients.remove(thisClientID);
			toClients.remove(thisClientID);
			
			//notify other clients that this client has left the server
			try {
				for(DataOutputStream out : toClients.values()) 
					out.writeUTF(name + " has left the server.");
			} catch (IOException ex) {
				Platform.runLater(() -> taLog.appendText(ex.getMessage() + '\n'));
			}
		}
	}
}