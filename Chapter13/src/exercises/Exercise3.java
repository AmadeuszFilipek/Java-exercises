package exercises;

import java.util.ArrayList;

public class Exercise3 {

	public static void main(String[] args) {
		
		ArrayList<Number> list = new ArrayList<>();

		for (int i = 0; i < 100; i++) {
			list.add(Math.random() * 100);
		}
		
		System.out.println(list);
		sort(list);
		System.out.println(list);
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void sort(ArrayList<Number> list) {

		for (int i = 0; i < list.size(); i++) {
			for(int j = 0; j < list.size()- 1; j++) {
				if(list.get(j) instanceof Comparable &&
						list.get(j + 1) instanceof Comparable) {

					if (((Comparable)list.get(j)).compareTo((Comparable)list.get(j + 1)) > 0){
						Number temp = list.get(j);
						list.set(j, list.get(j + 1));
						list.set(j + 1, temp);
					}
				}
			}
		}
	}
}
