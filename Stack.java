package AhmedAlkhattatCyrilleLingaiJonathanGrant_05;

/**
 * 
 * A linked list implement of stack to handle expressions of any data type.
 * 
 * @author		Ahmed Alkhattat, Jonathan Grant.
 * @version		11/12/19.
 * @param <T>	Abstract data type.
 * 
 */
public final class Stack<T> {
	
	// Declaring Instance Variables
	
	private Node<T> topNode; // A linked list of characters of an infix expression.

//***************************************************************************
	
	// Constructor
	/**
	 * 
	 */
	public Stack() {
		
		topNode = null;
		
	} // End Stack constructor.
	
//***************************************************************************
	
	/**
	 * Insert new character on the top of the stack
	 * @param newEntry
	 */
	public void push(T newEntry) {
		
		// Creates a node with the entry and links it to the previous node.
		
		Node<T> newNode = new Node<T>(newEntry, topNode);
		
		// Designates the new node as the top node of the stack.
		
		topNode = newNode;
		
	} // End push method.
	
//***************************************************************************
	
    /**
     * Check if the stack is empty otherwise pop the top char and return it,
     * @return the top of the stack or null 
     */
	public T pop() {
		
		// Declaring Local Variables.
		
		Node<T> poppedNode; // The top node to return.
		
		// Check if the stack is empty.
		if(isEmpty()) { 
			return null ;
		} // End if.
		
		// Remove the top node and reference the next node as the top one.
		
		poppedNode = topNode;
		
		topNode = topNode.getNextNode();
		
		return poppedNode.getData();
	
	} // End pop method.
	
//***************************************************************************
	
	/**
	 * Check if the stack is empty, return null .
	 * Otherwise retrieve, but do not remove,the first element
	 * @return null or top of the stack
	 */
	public T peek() {
		
		// Return the top nodes data or nothing.
		
		if (!isEmpty()) {
			
			return topNode.getData();
			
		} // End if.
		
		return null;
	
	} // End peek method.
	
//***************************************************************************
	
	/**
	 * Check if the stack is empty
	 * @return true if it is empty or false if it is not empty
	 */
	public boolean isEmpty() {
		
		return topNode == null;
		
	} // End isEmpty method.

//***************************************************************************
/**
 * Clear all the element in the stack
 */
	public void clear() {
		
		topNode = null;
		
	} // End clear method.

}// End class
