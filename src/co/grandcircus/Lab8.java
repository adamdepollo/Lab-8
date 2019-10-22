package co.grandcircus;

import java.util.Scanner;

public class Lab8 {
	public static void main(String[] args) {
		// Create scanner and string cont to use to continue looping through program
		Scanner scnr = new Scanner(System.in);
		String cont = "yes";

		// Loop based on whether the user wants to continue
		while (cont.equalsIgnoreCase("yes")) {
			// Ask user to input a student number 1-10 and validate the choice using
			// Validator.getInt()
			int studentNum = Validator.getInt(scnr, "Which student would you like to know about? (pick a number 1-10)",
					1, 10);
			System.out.println();
			// Pull and print student name using the getStudentInfo array item at the user's
			// pick
			System.out.println("Alright, that student's name is " + getStudentInfo(0)[studentNum - 1] + ".");
			System.out.println();

			// Create a loop to continually ask user what info they want to know
			String goAgain;
			do {
				System.out.println(
						"What would you like to know about them?\n 1. Their age\n 2. Their hometown\n 3. The price at which they would be willing to sell the rights to their likeness and identity for promotional purposes");

				// Call validateInfoChoice method to try/catch for out of index exceptions on
				// user choice and print requested info if input is valid
				validateInfoChoice(scnr, studentNum);

				// Clear scanner
				scnr.nextLine();
				System.out.println();

				// Ask whether the user would like to know more info about this student and
				// break
				// loop if not
				System.out.println("Do you want to know more info about them? (yes/no)");
				goAgain = scnr.nextLine();
				System.out.println();
			} while (goAgain.equalsIgnoreCase("yes"));

			// Ask user whether they'd like to know something about a different student and
			// break loop if not
			System.out.println();
			System.out.println("Do you want to know something about a different student? (yes/no)");
			cont = scnr.nextLine();
		}

		// Say goodbye to user and close scanner
		System.out.println("Ok then, bye!");
		scnr.close();
	}

	// Create method to serve as a repository for info about students to be pulled
	// from in main method
	public static String[] getStudentInfo(int userChoice) {
		// Need default array to ensure method compiles (need a return value outside of
		// if statements below)
		String[] defaultArray = new String[1];
		String[] names = { "Jim", "JimJim", "JohnJohn", "JohnJimmers", "JimmyJohn", "John", "LongJohn", "SlimJim",
				"Johm", "Jimn" };
		String[] hometown = { "Jamestown", "Old Jimminy", "John's Sorrowful Holler", "New Johnsonville",
				"James-on-the-Wheatroll", "Jacksonville", "Little Johnton", "James' Long Shadow", "Johnny Knoxville",
				"Jomntowm" };
		String[] age = { "12", "14", "76", "22", "47", "52", "32", "40", "19", "85" };
		String[] selloutPrice = { "$55.99", "$125.00", "$4,999,999.99", "$4,999.99", "$3.50", "$7.99", "$800.00", "$29.99",
				"$12.42", "$6.66" };
		if (userChoice == 0) {
			return names;
		} else if (userChoice == 1) {
			return age;
		} else if (userChoice == 2) {
			return hometown;
		} else if (userChoice == 3) {
			return selloutPrice;
		}
		return defaultArray;
	}
	
	//Create a method to validate user's info request
	public static void validateInfoChoice(Scanner scnr, int studentNum) {
		//Try to draw info from the studentInfo method repository based on the user's input
		try {
			int infoChoice = scnr.nextInt();
			String info = getStudentInfo(infoChoice)[studentNum - 1];
			System.out.println();
			if (infoChoice == 1) {
				System.out.println("OK, " + getStudentInfo(0)[studentNum - 1] + " is " + info + " years old.");
			} else if (infoChoice == 2) {
				System.out.println(getStudentInfo(0)[studentNum - 1] + " is from " + info + ".");
			} else if (infoChoice == 3) {
				System.out.println("OK, " + getStudentInfo(0)[studentNum - 1]
						+ " is willing to sell the rights to their likeness for " + info + ".");
			}
		} 
		//If user enters a number that isn't defined, ask them to put info again and run the method again using the new input
		catch (IndexOutOfBoundsException e) {
			System.out.println("Whoops, that wasn't one of the options. Try again:");
			validateInfoChoice(scnr, studentNum);
		}
	}

}
