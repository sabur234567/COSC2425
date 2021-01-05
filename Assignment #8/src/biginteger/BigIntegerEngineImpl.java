package biginteger;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;


import biginteger.BigIntegerEngine;
import stack.StackList;
import stack.StackListLinkedListImpl;

public class BigIntegerEngineImpl implements BigIntegerEngine{
	
	private StackList<String> stack;
	private EventListenerList eventListenerList;  // stores one or more event listener
	private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);
	private String actionText;
	
	// Note: an engine keeps the sum of all operands in the engine updated at all times 
	//even as operands are modified
	public BigIntegerEngineImpl()
	{
		stack = new StackListLinkedListImpl<String>(BigIntegerEngine.MAX_OPERANDS);
		this.eventListenerList = new EventListenerList();
		this.actionText="Stack is EMPTY";
	}
	public BigIntegerEngineImpl(int aMax)
	{
		if(aMax>=0 && aMax <=StackList.LARGEST)
		{
			stack = new StackListLinkedListImpl<String>(aMax);
		}
		else
		{
			stack = new StackListLinkedListImpl<String>(BigIntegerEngine.MAX_OPERANDS);
		}
		this.eventListenerList = new EventListenerList();
		this.actionText="Stack is EMPTY";
	}
	//toString
	public String toString()
	{
		return this.stack.toString();
	}
	public String getActionText()
	{
		return this.actionText;
	}

	// receives: nothing
	//returns: the String representation of the received operandNumber, returns empty string if operandNumber is invalid
	//       invalid if operandNumber is not within:  1 <= operandNumber <= MAX_OPERANDS
	public String getOperand(int operandNumber)
	{
		if(operandNumber <= 0 || operandNumber > MAX_OPERANDS)
		{
			return "";
		}
		else
		{
			String operand = String.valueOf(operandNumber);
			return operand;
		}
	}

	//receives: nothing
		// returns: nothing
		// task: all operands, from 1 to MAX_OPERANDS are set to "0"
	public void clearOperands() {
		this.stack.clear();
		this.actionText = "CLEARD STACK: ";
		
		this.fireChangeEvent(CHANGE_EVENT);
		
	}

	//receives: operandNumber and value to set operandNumber to
	//        verifies that operandNumber>=1 and operandNumber <= MAX_OPERANDS
	// task: operandNumber given is set to operandValue if both operandValue is a valid integer string and 
	//      operandNumber is in range 1 to MAX_OPERANDS inclusive.
	//returns:  false if either argument is invalid and does not set anything, otherwise returns true
	public boolean setOperand(int operandNumber, String operandValue) {
		if(operandNumber <= 0 || operandNumber > MAX_OPERANDS)
		{
			return false;
		}
		char c=' ';
		for(int index =0; index<operandValue.length();index++)
		{
			c = operandValue.charAt(index);
			if(!Character.isDigit(c))
			{
				return false;
			}
		}

		return true;
		
	}

	public String getSum() {
		
		return null;
	}

	// EVENT CHANGES
	// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	public void addChangeListener(ChangeListener stackEngineListener) {
		eventListenerList.add(ChangeListener.class, stackEngineListener);
		
	}

	// removes change listener from this model's listener list.
	public void removeChangeListener(ChangeListener stackEngineListener) {
		eventListenerList.remove(ChangeListener.class, stackEngineListener);
		
	}

	// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	public void fireChangeEvent(ChangeEvent event) {
		// Guaranteed to return a non-null array
		Object[] listeners = eventListenerList.getListenerList();
		// Process the listeners last to first, notifying
		// those that are interested in this event
		for (int i = listeners.length-2; i>=0; i-=2) {
			if (listeners[i]==ChangeListener.class) {
				((ChangeListener)listeners[i+1]).stateChanged(event);
			}
		}
		
	}
	
}
