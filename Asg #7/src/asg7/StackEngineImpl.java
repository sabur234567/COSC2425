package asg7;
/** engine implementation that models the use of two different stack implementations
 *   provides a minimal set of methods
 *  that models/uses two stacks and allows a few operations on those stacks
 *  @author: LJBaker
 */
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

import stack.StackList;
import stack.StackListLinkedListImpl;

public class StackEngineImpl implements StackEngine {
	
	private StackList<String> stack; // one of 2 stacks used in this engine
	private EventListenerList eventListenerList;  // stores one or more event listener
	private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);
	private String actionText;

	// default constructor, builds the stack with default max size of 4
	public StackEngineImpl()
	{
		stack = new StackListLinkedListImpl<String>(StackEngine.DEFAULT_MAX_SIZE);
		this.eventListenerList = new EventListenerList();
		this.actionText="Stack is EMPTY";
	}
	public StackEngineImpl(int aMax)
	{
		if(aMax>=0 && aMax <=StackList.LARGEST)
		{
			stack = new StackListLinkedListImpl<String>(aMax);
		}
		else
		{
			stack = new StackListLinkedListImpl<String>(StackEngine.DEFAULT_MAX_SIZE);
		}
		this.eventListenerList = new EventListenerList();
		this.actionText="Stack is EMPTY";
	}
	//the expected method for any class, returns a string of
	// the current stack contents 
	public String toString()
	{
		String temp = "";
		temp = stack.toString();

		return temp;
	}

	public String getActionText()
	{
		return this.actionText;
	}

	//pre: stack being pushed is not full
	// post: stack has contents of element on the top
	//       actionText contains information about results.
	public void push(String element) {
		if(stack.getSize() >= stack.getMaxSize())
		{
			actionText = "NO PUSH FULL Stack";
		}
		else
		{
			stack.push(element);
			actionText = "PUSHED: " + element;
		}

		this.fireChangeEvent(CHANGE_EVENT);
	}
	//pre: stack is not empty
	// post: sets actionText to describe top element on current stack
	//       actionText contains information about value peeked at.
	public  void peek() 
	{
		if(stack.isEmpty())
		{
			actionText = "Cannot Peek -- EMPTY STACK";
		}
		else 
		{
			String res = this.stack.peek();
			actionText = "PEEKED: " + res;
		}
		this.fireChangeEvent(CHANGE_EVENT);


	}
	//pre: stack is not empty
	// post: returns AND REMOVES top element on current stack
	//       actionText contains information about results.
	public void pop() {
		if(stack.isEmpty())
		{
			actionText = "Cannot POP -- EMPTY STACK";
		}
		else 
		{
			String res = this.stack.pop();
			actionText = "POPPED: " + res;
		}
		this.fireChangeEvent(CHANGE_EVENT);
	}
	//pre: none
	// post: number of elements on stack is returned
	public int getSize() {

		return this.stack.getSize();
	}
	//pre: none
	// post: returns max size for current stack 
	public int getMaxSize()
	{
		return this.stack.getMaxSize();
	}
	public void showMaxSize()
	{
		actionText= "Stack Max Size: " + StackEngine.DEFAULT_MAX_SIZE;
		this.fireChangeEvent(CHANGE_EVENT);

	}
	//pre: none
	// post: returns true iff the current stack has a size of 0.
	public void testEmpty() 
	{
		if(stack.isEmpty())
		{
			actionText = "Stack Is Empty.";
		}
		else
		{
			actionText = "Stack Is Not Empty.";
		}
		this.fireChangeEvent(CHANGE_EVENT);		

	}
	//pre: none
	// post: returns true if the stack currently has MAX_ELEMENTS on it.
	public void testFull() 
	{
		if(stack.isFull())
		{
			actionText = "Stack Is Full.";
		}
		else
		{
			actionText = "Stack Is Not Full.";
		}

		this.fireChangeEvent(CHANGE_EVENT);			
	}
	// pre: none
	// post: current stack is empty, size is 0.
	public void clear()
	{  
		this.stack.clear();
		actionText = "CLEARD STACK: ";
		
		this.fireChangeEvent(CHANGE_EVENT);
		//fill in code
	}
	//standard boilerplate method for change events
	public void addChangeListener(ChangeListener changeListener)
	{
		eventListenerList.add(ChangeListener.class, changeListener);
	}
	//standard boilerplate method for change events
	public void removeChangeListener(ChangeListener changeListener)
	{
		eventListenerList.remove(ChangeListener.class, changeListener);
	}
	//standard boilerplate method for change events
	// used when we need to notify the view that a change to the model has taken place
	// so that the view can update itself.
	public void fireChangeEvent(ChangeEvent changeEvent) {
		// Guaranteed to return a non-null array
		Object[] listeners = eventListenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) {
			if (listeners[i]==ChangeListener.class) {
				((ChangeListener)listeners[i+1]).stateChanged(changeEvent);
			}
		}
	}

}
