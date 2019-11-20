package AhmedAlkhattatCyrilleLingaiJonathanGrant_05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * 
 * The mathematic expression program to handle infix and postfix statements.
 * 
 * @author Ahmed Alkhattat, Cyrille Lingai, Grant Jonathan.
 * @version 11/12/19.
 */

public class AhmedAlkhattatCyrilleLingaiJonathanGrant_05 {
	
	// Declaring Main Variables
	
	static Scanner scan = new Scanner(System.in); // get input from keyboard
	
	/**
	 * Main execution of program.
	 * 
	 * @param		args.
	 * @throws		FileNotFoundException 	If the file is not found.
	 * @throws		IOException				If there is not to a writable file.		
	 */
	public static void main(String[] args) {
		
		// Declaring Local Variables
		
		int lineNumber = 0;		// Track the line an expression is scanned from.
		String xx = "XX";			// The file number to identify and scan files.
		String inputFileName = "AhmedAlkhattat_05_Input" + xx + ".txt";
								// The file of infix expression.
		String postfixData = "Postfix Conversions\n";
								// The postfix expressions to write to file.
		String outputFileName = "AhmedAlkhattat_05_Output" + xx + ".txt";
								// The file of corresponding postfix expressions.
		File file = null;				// File object for input file.
		FileWriter fileWriter = null;	// The text of postfix expression.
		
		// Get input from user and find the corresponding file.
		
		System.out.print("Enter file number: ");
		xx = scan.next(); // Read the file
		inputFileName = inputFileName.replace("XX", xx);
		outputFileName = outputFileName.replace("XX", xx);
		
		file = new File(inputFileName);
	      
		try {
		     Scanner scannedFile = new Scanner(file); // Declaring Scanner
		     String line = null; 
		  
		     // While loop till file has line
		     while (scannedFile.hasNextLine()) {
			 
		    	// Read the line
			    line = scannedFile.nextLine();
			    postfixData += "\n" + line + "\n" 
			    				+ Postfix.convertToPostfix(line) + "\n";
			 } // End while.
		     
		     scannedFile.close();
		} // End try.

		catch (FileNotFoundException e) {
			System.err.println(e);
		} // End catch.
		  
		// Attempt to find pre-existing file or create new one of specified name,
		// and write the postfix expressions to file.
		
		try {
			fileWriter = new FileWriter(outputFileName);
			fileWriter.write(postfixData);
			fileWriter.close();
		} // End try.
		
		catch (IOException e) {
			System.err.println(e.getMessage());
		}  // End catch.

	} // End main method.
} // End class.

