package queue;


	public interface QueueList <T>
	{

		//max size used by default if none given.
	    public static final int DEFAULT_MAX_SIZE = 4;
	    public static final int LARGEST = 100000;  // largest allowable size for a QueueList instance
	    
	/** receives: nothing
	 *  task:  tests to see if this QueueList has 0 elements
	 *  returns: true if this QueueList is empty (has 0 elements) false otherwise;
	 */
	  public boolean isEmpty();

	  /** receives: nothing
		 *  task:  tests to see if this QueueList has getMaxSize() elements
		 *  returns: true if this QueueList is full (has getMaxSize() elements) false otherwise;
		 */
	  public boolean isFull();

	/** receives: nothing
	 * returns:  number of elements in this QueueList
	 */
	  public int getSize();

	  /** receives: nothing
		 * returns:  max allowable number of elements in this QueueList
		 */
	  public int getMaxSize();


	/** places item at the REAR of this QueueList
	 *receives: nothing
	 * returns: nothing
	 * task:  element is placed at the REAR or END of this QueueList if it is NOT full
	 *throws: RuntimeException if this QueueList is full
	 */
	  public void add(T element);

	/** receives: nothing
	   returns:  removes and returns the FRONT item from this QueueList if it is NOT empty
	 * @throws - RuntimeException if attempt to remove from an empty QueueList
	
	 */
	  public T remove();

	/** receives: nothing
	 * returns: the FRONT item from this QueueList if it is
	 * not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 */
	  public T getFront();

	/** receives: nothing
	 * returns: the REAR (or last)  item from this QueueList if it is
	 *      not empty.  DOES NOT REMOVE IT.
	 * @throws - RuntimeException if this QueueList is empty.
	 */
	  public T getRear();

	/** receives: nothing
	    task: removes all items from this QueueList making it empty.
	    returns: nothing
	 */
	  public void clear();
}
