  package stack;

import java.util.ArrayList;

public class StackListArrayListImpl<T> implements StackList<T>{
	
	private int max_size;
	private ArrayList<T> list;
	private int retValue;
	
	public StackListArrayListImpl() //default constructor 
	{
		this.max_size = DEFAULT_MAX_SIZE;
		this.list = new ArrayList<T>(DEFAULT_MAX_SIZE);
	}
	
	public StackListArrayListImpl(int maxSize) //2nd default constructor
	{
		if(maxSize>=0 && maxSize  <= LARGEST)
		{
			this.max_size = maxSize;
		}
		else
		{
			this.max_size = DEFAULT_MAX_SIZE;
		}
		this.list = new ArrayList<T>(max_size);
	}
	public String toString()
	{
		String temp ="";
		for(int index=list.size()-1; index<list.size();index--)
		{
			temp+= list.get(index) + "\n";
		}
		return temp;
	}
	
	   /**receives: nothing
     *  task:  tests to see if the Stack has 0 elements
     *  returns: true if this StackList is empty (has 0 elements) false otherwise;
     */
	public boolean isEmpty()
	{
		if(list.size()==0)
		{
			return true;
		}
		else {
			return false;
		}
	}
	/**receives: nothing
	   *  task:  tests to see if this StackList instance has getMaxSize() elements 
	   *  returns: true if this StackList is full (has getMaxSize() elements) false otherwise;
	*/
	 public boolean isFull()
	  {
		  if(list.size()== getMaxSize())
		  {
			  return true;
		  }
		  else {
			  return false;
		  }
	  }
	 /** receives: nothing
	  * returns: number of elements on this StackList (always <= to getMaxSize())
	  */
	 public int getSize()
	 {
		 int size = list.size();
		 return size;
	 }
	 /** receives: nothing
	  * returns: max number of elements allowed on this StackList (always <= to getMaxSize())
	  */
	 public int getMaxSize()
	 {
		  return this.max_size;
	 }

	 /** receives: nothing
	  * returns: max number of elements allowed on this StackList
	  *
	   public int getMaxSize();

	 /** receives: element to place on top of this StackList
	  * task: received element is on top of this StackList instance if it is not full
	  * returns: nothing
	  *@throws RuntimeException if this StackList is full (has max size elements already)
	  */
	  public void push(T element)
	  {
		  if(this.isFull())
		  {
			  throw new RuntimeException("Cannot remove. Empty list.");
		  }
		  else
		  {
			  list.add(element);
		  }
		  
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
		  else
		  {
			  return list.remove(list.size()-1);
		  }
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
			  throw new RuntimeException("Cannot remove. Empty list.");
		  }
		  else
		  {
			  return list.get(list.size()-1);
		  }
	  }

	 /**receives: nothing
	     returns: nothing
	     task:  removes all items from this StackList, making it empty.
	  */
	  public void clear()	
	  {
		  list.clear();
	  }
	 
}