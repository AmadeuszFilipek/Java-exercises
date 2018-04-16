package exercises;

public class Exercise11 {


	public static void main(String[] args) {

		//deadlock - having a lock and waiting for other lock
		// while the other thread holds the second lock while waiting for the first lock

		Student student1 = new Student();
		Student student2 = new Student();

		Thread thread1 = new Thread(() -> {
			while(true) {
				synchronized (student1) {
					System.out.println("Thread1 acquired lock on student1");
					synchronized (student2) {
						System.out.println("Thread 1 acqured lock on student1 and student2");
					}
				}
			}
		});
	
		// the order in which the locks are acquired is shifted for purpose
		// if the order for both threads would be the same, a deadlock would not occur
		Thread thread2 = new Thread(() -> {
			while(true) {
				synchronized (student2) {
					System.out.println("Thread2 acquired lock on student2");
					synchronized (student1) {
						System.out.println("Thread2 acquired lock on student2 and student1");
					}
				}
			}
		});
		
		thread1.start();
		thread2.start();
		
	}


	public static class Student {
		Integer grade = 0;

		public void setGrade(int i) {
			grade = i;
		}

		public Integer getGrade() {
			return grade;
		}

		public String toString() {
			return grade.toString();
		}
	}
}

