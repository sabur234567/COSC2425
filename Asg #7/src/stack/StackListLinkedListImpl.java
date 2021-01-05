package stack;

public class StackListLinkedListImpl<T> implements StackList<T> {
	
	private int count;
	private Node <T> first;
	private int max_size;
	
	public StackListLinkedListImpl() //default constructor 
	{
		this.count =0;
		this.first=null;
		this.max_size = DEFAULT_MAX_SIZE;
	}
	
	public StackListLinkedListImpl(int maxSize) //2nd default constructor
	{
		this.count=0;
		this.first=null;
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
			temp += current.data + "\n";
			current = current.link;
		}
		return temp;
	}
	 /**receives: nothing
     *  task:  tests to see if the Stack has 0 elements
     *  returns: true if this StackList is empty (has 0 elements) false otherwise;
     */
	public boolean isEmpty()
	{
		if(this.first==null)
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
	/**receives: nothing
	   *  task:  tests to see if this StackList instance has getMaxSize() elements 
	   *  returns: true if this StackList is full (has getMaxSize() elements) false otherwise;
	*/
	  public boolean isFull()
	  {
		  if(this.count == getMaxSize())
		  {
			  return true;
		  }
		  else
		  {
			  return false;
		  }
	  }
	  
	  /** receives: nothing
	   * returns: max number of elements allowed on this StackList (always <= to getMaxSize())
	   */
	   public int getMaxSize()
	   {
		   return this.max_size;
	   }

	   /** receives: element to place on top of this StackList
	    * task: received element is on top of this StackList instance if it is not full
	    * returns: nothing
	    *@throws RuntimeException if this StackList is full (has max size elements already)
	    */
	   public void push(T element)
	   {
		   if(this.isFull())
		   {
			   throw new RuntimeException("Cannot add, full list.");
		   }
		   Node <T> node = new Node<T>(element);
		   node.link = this.first;
		   this.first= node;
		   this.count++;
	   }
	
	   /** receives: nothing
	   returns:  removes AND returns the top item from this StackList if  it is NOT empty. 
	 * @throws - RuntimeException if attempt to pop an empty StackList
	 */
	   public T pop()
	   {
		   if(this.isEmpty())
		   {
			   throw new RuntimeException("Cannot remove. Empty list.");
		   }
		   Node<T> current = this.first;
		   first = first.link;
		   this.count--;
		   return current.data;
	   }
	   
	   /** receives: nothing
	    *returns the top item from this StackList  if it is
	   *         not empty.  DOES NOT POP IT.
	   * @throws - RuntimeException if attempt to peek at an empty StackList instance
	   */
	   public T peek()
	   {
		   if(this.isEmpty())
		   {
			   throw new RuntimeException("Cannot peek. Empty list.");
		   }
		   Node<T> current = this.first;
		   return current.data;
	   }
	   /**receives: nothing
	    returns: nothing
	    task:  removes all items from this StackList, making it empty.
	 */
	   public void clear()
	   {
		   this.first=null;
		   this.count=0;
	   }
	   
	   
	   
	   
	   
	/** a typical node class for a linked list
	 * single traditional linked list node
	 * templated to hold any object-based type
	 * @author LJBaker
	 *
	 * @param <T> the object based type stored in the node
	 * all data is public as this is used internally by a linked list
	 * never used in any public sense
	 */

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