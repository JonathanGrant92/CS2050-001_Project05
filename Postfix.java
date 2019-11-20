package AhmedAlkhattatCyrilleLingaiJonathanGrant_05;

/**
 * The Postfix class converts valid infix expression to their postfix
 * counterparts using the stack.
 * 
 * @author Ahmed Alkhattat, Jonathan Grant.
 * @version 11/12/19.
 */
public class Postfix {
	
	// Declaring Instance Variables
	
	static String invalidReason = "";			// Reason input is invalid.
	static final String OPERATORS = "()–+/*^";  // Sequence of operators. 
	static final int [] PRECEDENCE = {-1,-1,0,0,1,1,2} ;  
				// Sequence indicating the precedence of corresponding operators.
	
//***************************************************************************
	
	/**
	 * Converts the infix expression to the postfix equivalent using the linked
	 * list implement of a stack.
	 * 
	 * @param 	inputExpression		The infix expression.
	 * @return						The postfix expression.
	 */
	public static String convertToPostfix(String inputExpression) {
		
		// Declare Local Variables
		
		String postFix = "";		// The postfix expression of infix input.
		Stack<Character> operatorStack = new Stack<Character>();
									// Operators for postfix expression.
		
		// Eliminate the whitespace in the expression.
		inputExpression = String.join("",inputExpression.split("\\s"));
		
        if(isInvalid(inputExpression)) {
        	return "None. Invalid syntax. " + invalidReason;
        } // End if.
		
        // Check each character and push to the stack or process if appropriate.
        
		for(Character oneChar: inputExpression.toCharArray()) {
			
			if((oneChar != '(' && oneChar != ')') && OPERATORS.contains(oneChar.toString())) {
				Character operator = oneChar;

				if(operatorStack.isEmpty()) {
					operatorStack.push(operator);
					continue ;
				} // End if.
				
				int topPrecedence = PRECEDENCE[OPERATORS.indexOf(operatorStack.peek())];
				int nextPrecedence = PRECEDENCE[OPERATORS.indexOf(operator)];
				
				if(nextPrecedence < topPrecedence) {
					
					while (topPrecedence > nextPrecedence) {
						
						postFix+= operatorStack.pop();
						postFix += " ";
						
						if(operatorStack.isEmpty()) {
							break;
						} // End if.
						
						topPrecedence = PRECEDENCE[OPERATORS.indexOf(operatorStack.peek())];
						
					} // End while.
					
					operatorStack.push(operator);
				} // End if.
				
				else if(nextPrecedence == topPrecedence) {
					postFix += operatorStack.pop();
					postFix += " ";
					operatorStack.push(operator);
				} // End else if.
				
				else {
					operatorStack.push(operator);
				} // End else.
				
			} // End if.
			
			else {
				Character operand = oneChar;
				if(operand == '(') {
					operatorStack.push(operand);

					continue;
				} // End if.
				
				if(operand == ')') {
					while(operatorStack.peek() != '(') {
						
						postFix += operatorStack.pop();
						postFix += " ";
						
					} // End while.

					operatorStack.pop();
					continue;
					
				} // End if.
				
				postFix += operand;
				postFix += " ";
				
			} // End else.
		} // End for.
		
		while(!operatorStack.isEmpty()) {
			
			postFix += operatorStack.pop();
			postFix += " ";
			
			} // End while.
		
		return postFix;
		
	} // End convertToPostfix method.

//***************************************************************************
	
	/**
	 * 
	 * Find the 
	 * 
	 * @param inputExpression	The infix expression.
	 * @return					True if invalid, false if valid.
	 */
	
	private static boolean isInvalid(String inputExpression) {
		
		// Declare Local Variables
		
		int parenthesesCounter = 0;		// The number of parentheses.
		int variableCounter = 0;		// The number of operands.
		int operatorCounter = 0;		// The number of operators
		boolean isValid = false;		// True if possible to convert to postfix.
		
		// Analyse the infix expression: count all the operands and operators.
		
		for (Character charLetter : inputExpression.toCharArray()) {
			
			if (OPERATORS.contains(charLetter.toString())) {
				
				if (charLetter == '(' || charLetter == ')') {
					parenthesesCounter++;
				} // End if.
				else {
					operatorCounter++;
				} // End else.
				
			} // End if.
			else {
				variableCounter++;
			} // End else.
		} // End for.
		
		// Check that parentheses match and all operators have matching operands.
		
		if ((parenthesesCounter % 2 == 0)
				&& (operatorCounter + 1 == variableCounter)) {
			
			isValid = true;
			
		} // End if.
		
		else {
			
			// Determine the reason for the invalid infix expression.
			
			if (operatorCounter + 1 != variableCounter) {
				invalidReason = "The operators and operands do not match: ";
			} // End if.
			
			else {
				invalidReason = "The parentheses do not match: ";
			} // End else.
			
			invalidReason += inputExpression + ".";
			
		} // End else.
		
		return !isValid; // If valid, isInvalid method should return false, not true.
		
	} // End isInvalid method.

} // End PostFix class.