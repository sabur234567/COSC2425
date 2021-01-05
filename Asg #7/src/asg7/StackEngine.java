package asg7;
/** engine interface that models the use of a stack interface
 *   provides a minimal set of methods typically used with a stack
 *   models/uses a stack of strings for educational/display use only
 *   many of the engine's "stack" methods, set a text field that contains the 
 *   result of the method's action as well as modifying the stack.
 *   method getActionText() should be called on the engine to see the most recent 
 *   action and its result
 * 
 *  @author: LJBaker
 */
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public interface StackEngine{
	//max size used by default if none given.
    public static final int DEFAULT_MAX_SIZE = 4;
	//receives: element to push
	// task: if stack is not full pushes element, records result in action text.  
    //       if stack is full, records that in action text of engine.   
    // returns: nothing
	public void push(String element);
	
	//receives: nothing
	//task:  pops stack and returns value popped
	//       if stack is empty records that in action text of engine
	//returns: nothing
	public void pop();
	
	//receives: nothing
	// returns: size of stack as an int
	public int getSize();
	
	//receives: nothing
	// returns: max size of this stack 
	public int getMaxSize();
	
	//receives: nothing
	//task: sets action text to be current max size with message
	// returns: nothing
	public void showMaxSize();
	
	//receives: nothing
	// task:  currentStack is peeked at and action text has result
	//        if stack is empty no peek occurs and 
	//       records that information in action text
	public void peek();
	
	//receives: nothing
	//task: sets action text with empty or not empty result
	// returns: nothing
	public  void testEmpty();
	
	//receives: nothing
	//task: sets action text with full or not full
	// returns: nothing
	public void testFull();
	
	//receives: nothing
	//task: empties current stack
	//     fills action text with message regarding cleared.
	//returns: nothing
	public void clear();
	
	//receives: nothing
	//returns:  the action text of the last method used on this stackEngine
	public String getActionText();
	
	// EVENT CHANGES
	// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
	public void addChangeListener(ChangeListener stackEngineListener);
	
	// removes change listener from this model's listener list.
	public void removeChangeListener(ChangeListener stackEngineListener);
	
	// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
	public void fireChangeEvent(ChangeEvent event);

}
