package queue;


public class QueueListLinkedListImpl<T> implements QueueList<T> {
	private int count;
	private Node <T> first;
	private Node <T> last;
	private int max_size;
	
	public QueueListLinkedListImpl() //default constructor
	{
		this.count =0;
		this.first=null;
		this.last = null;
		this.max_size = DEFAULT_MAX_SIZE;
	}
	public QueueListLinkedListImpl(int maxSize) // second constructor to test max size
	{
		if(maxSize>=0 && maxSize  <= LARGEST)
		{
			this.max_size = maxSize;
		}
		else
		{
			this.max_size = DEFAULT_MAX_SIZE;
		}
	}
	public String toString()
	{
		String temp ="";
		Node <T> current = this.first;
		while(current!= null)
		{
			temp += current.data.toString() + "\n";
			current = current.link;
		}
		return temp;
	}
	
	/** receives: nothing
	 *  task:  tests to see if this QueueList has 0 elements
	 *  returns: true if this QueueList is empty (has 0 elements) false otherwise;
	 */
	 public boolean isEmpty()
	 {
		if(this.count==0)
		{
			return true;
		}
		else
		{
			return false;
		}
	 }
	 /**receives: nothing
	  *  task:  tests to see if this StackList instance has getMaxSize() elements 
	  *  returns: true if this StackList is full (has getMaxSize() elements) false otherwise;
	*/
	public boolean isFull() 
	{
		if (this.count == getMaxSize()) 
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}
	/** receives: nothing
	 * returns: number of elements on this StackList (always <= to getMaxSize())
	 */
	public int getSize()
	{
		return this.count;
	}
	 /** receives: nothing
	 * returns:  max allowable number of elements in this QueueList
	 */
	public int getMaxSize()
	{
		return this.max_size;
	}
	/** places item at the REAR of this QueueList
	 *receives: nothing
	 * returns: nothing
	 * task:  element is placed at the REAR or END of this QueueList if it is NOT full
	 *throws: RuntimeException if this QueueList is full
	 */
	public void add(T element)
	{
		if(this.isFull())
		{
			throw new RuntimeException("Cannot add, full list.");
		}
		Node<T> node = new Node<T>(element);
		if(this.isEmpty())
		{
			this.first=node;
			this.last=node;
			this.count++;
		}
		else
		{
			last.link = node;
			this.last= node;
			this.count++;
		}
	}
	/** receives: nothing
	   returns:  removes and returns the FRONT item from this QueueList if it is NOT empty
	 * @throws - RuntimeException if attempt to remove from an empty QueueList
	
	 */
	public T remove()
	{
		if(this.isEmpty())
		{
			throw new RuntimeException("Cannot remove. Empty list.");
		}
		Node<T> current = this.first;
		first = first.link;
		count--;
		return current.data;
	}
	/** receives: nothing
	 * returns: the FRONT item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 */
	 public T getFront()
	 {
		 if(this.isEmpty())
		 {
			 throw new RuntimeException("Cannot peek. Empty list.");
		 }
		 Node<T> current = this.first;
		 return current.data;
	 }
	 /** receives: nothing
		 * returns: the REAR (or last)  item from this QueueList if it is
		 *      not empty.  DOES NOT REMOVE IT.
		 * @throws - RuntimeException if this QueueList is empty.
		 */
	 public T getRear()
	 {
		 if(this.isEmpty())
		 {
			 throw new RuntimeException("Cannot peek. Empty list.");
		 }
		 Node<T> current = this.last;
		 return current.data; 
	 }
	 /** receives: nothing
	    task: removes all items from this QueueList making it empty.
	    returns: nothing
	 */
	 public void clear()
	 {
		 this.first=null;
		 this.count=0;
	 }
	
	private class Node<T>
	{

	    public T data; 
	    public Node<T> link;

	    //default constructor 
	    public Node()
		{
		    this.data = null;
		    this.link = null;
		}//end of constructor

	    public Node(T theData)
		{
		    this.data = theData;
		    this.link = null;
		}

	    public Node(Node<T> theLink)
		{
		    this.data = null;
		    this.link = theLink;
		}

	    public Node(T theData, Node<T> theLink)
		{
		    this.data = theData;
		    this.link = theLink;
		}

	}//End of Node<T> public class. 
}
