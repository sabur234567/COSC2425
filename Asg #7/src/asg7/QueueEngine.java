package asg7;
/** engine interface that models the use of a queue interface
 *   provides a minimal set of methods typically used with a queue
 *   models/uses a queue of strings for educational/display use only
 *   many of the engine's "queue" methods, set a text field that contains the 
 *   result of the method's action as well as modifying the queue itself
 *   method getActionText() should be called on the engine to see the most recent 
 *   action and its result
 * 
 *  @author: LJBaker
 */
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public interface QueueEngine {
	    //max size used by default if none given.
	    public static final int DEFAULT_MAX_SIZE = 4;
	    
	    //receives: nothing
		// task: element is added to this queue
		// throws: RuntimeException if queue is full      
		public void add(String element);
		
		//receives: nothing
		// task:  removes front item from queue places info into action text of this engine
		//  throws RuntimeException  if queue is empty
		 public void remove();
		 
		//receives: nothing
		// task:  places front value of this instance into action text of this engine
		// throws RuntimeException if empty queue
		public void  showFront();
		
		//receives: nothing
		//task: returns current queue's size
		// does not change actionText
		// returns size of this instance
		public int getSize();
		
		//receives: nothing
		// task: sets action text to contain size of this instance
		public void showSize();
		
		//receives: nothing
		// task: returns max size of current queue
		public void showMaxSize();
		
		//receives: nothing
		//task: returns current queue's max size
		// does not change actionText
		// returns size of this instance
		public int getMaxSize();
		
		//receives: nothing
		// task:  rear (or last) item in this instance is placed in action text 
		// if queue is empty, sets action text to state that
		public void showRear();
		
		//receives: nothing
		//task: sets action text to message regarding queue if empty or not empty
		//returns: nothing
		public void testEmpty();
		
		//receives: nothing
		//task: sets action text to message regarding queue
	    //      whether or not it is full
		// returns: nothing
		public void testFull();
		
		//receives: nothing
		// task: clears current queue and records that in action text
		public void clear();
		
		//receives: nothing
		// returns: the last action as text, that was taken on this engine instance
		public String getActionText();
		// EVENT CHANGES
		// boiler plate standard methods for use with a model - adds change listener instance to this model's listener list
		public void addChangeListener(ChangeListener stackEngineListener);
		// removes change listener from this model's listener list.
		public void removeChangeListener(ChangeListener stackEngineListener);
		// raises or fires off a change event so that any listeners can hear it and thus update their situation (ie the view)
		public void fireChangeEvent(ChangeEvent event);

}
