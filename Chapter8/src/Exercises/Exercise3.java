package Exercises;

public class Exercise3 {

	public static void main(String[] args) {
		// Students' answers to the questions
		char[][] answers = {
				{'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'D', 'B', 'A', 'B', 'C', 'A', 'E', 'E', 'A', 'D'},
				{'E', 'D', 'D', 'A', 'C', 'B', 'E', 'E', 'A', 'D'},
				{'C', 'B', 'A', 'E', 'D', 'C', 'E', 'E', 'A', 'D'},
				{'A', 'B', 'D', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'B', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D'},
				{'E', 'B', 'E', 'C', 'C', 'D', 'E', 'E', 'A', 'D'}};

		// Key to the questions
		char[] keys = {'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D'};
		int[] correctAnswers = new int[answers.length];
		int[] studentsId = new int[answers.length];
		
		// Grade all answers
		for (int i = 0; i < answers.length; i++) {
			// Grade one student
			int correctCount = 0;
			for (int j = 0; j < answers[i].length; j++) {
				if (answers[i][j] == keys[j])
					correctCount++;
			}
			correctAnswers[i] = correctCount;
			studentsId[i] = i;
		}
		
		sortStudentGrades(correctAnswers, studentsId);
		
		for (int i = 0; i < answers.length; i++) 
			System.out.println("Student " + studentsId[i] + "'s correct count is " +
					correctAnswers[i]);
		
	}
	
	public static void sortStudentGrades(int[] correctAnswers, int[] studentsId) {
		int temp;
		int temporary;
		for(int i = 0; i < correctAnswers.length; i++) {
			for (int j = 0; j < correctAnswers.length - 1; j++) {
				if (correctAnswers[j] > correctAnswers[j + 1]) {
					temp = correctAnswers[j];
					correctAnswers[j] = correctAnswers[j + 1];
					correctAnswers[j + 1] = temp;
					
					temporary = studentsId[j];
					studentsId[j] = studentsId[j + 1];
					studentsId[j + 1] = temporary;
				}
			}	
		}
	}
}
