package biginteger;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public interface BigIntegerEngine {
	// Note: an engine keeps the sum of all operands in the engine updated at all times 
	//		even as operands are modified

	public int MAX_OPERANDS = 4;

	// receives: nothing
	//returns: the String representation of the received operandNumber, returns empty string if operandNumber is invalid
	//       invalid if operandNumber is not within:  1 <= operandNumber <= MAX_OPERANDS
	public String getOperand(int operandNumber);

	//receives: nothing
	// returns: nothing
	// task: all operands, from 1 to MAX_OPERANDS are set to "0"
	public void clearOperands();

	//receives: operandNumber and value to set operandNumber to
	//          verifies that operandNumber>=1 and operandNumber <= MAX_OPERANDS
	// task: operandNumber given is set to operandValue if both operandValue is a valid integer string and 
	//      operandNumber is in range 1 to MAX_OPERANDS inclusive.
	//returns:  false if either argument is invalid and does not set anything, otherwise returns true
	public boolean setOperand(int operandNumber, String operandValue);


	//receives: nothing
	//returns: the current sum of all operands(as a String) , from 1st to last which are 1 to MAX_OPERANDS inclusive
	public String getSum();


	// EVENT CHANGES
	// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	public void addChangeListener(ChangeListener stackEngineListener);

	// removes change listener from this model's listener list.
	public void removeChangeListener(ChangeListener stackEngineListener);

	// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	public void fireChangeEvent(ChangeEvent event);

}
