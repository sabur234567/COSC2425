package transactionlist;

import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.Scanner;

import transaction.Transaction;
import transaction.TransactionUtilsImpl;


public class TransactionListLinkedListImpl implements TransactionList {
	private int count;
	private Node <Transaction> first;
	public TransactionListLinkedListImpl() //default constructor
	{
		this.count = 0;
		this.first = null;
	}
	public TransactionListLinkedListImpl(String filename) //constructor that takes in filename
	{
		Scanner inFile = null;
		this.count=0;
		this.first=null;
		try {
			inFile = new Scanner(new File(filename));		
		}
		catch (IOException e) {
			System.out.println("Sorry, Cannot Open File, " + filename);
			return;
		}
		while(inFile.hasNext())
		{
			Transaction trans = TransactionUtilsImpl.readFromScanner(inFile);
			if(trans!=null)
			{
				this.add(trans);
			}
		}
		inFile.close();
	}
	//receives: nothing
		// returns:  number transactions in the list
	public String toString()
	{

		String temp = "";
		Node <Transaction> current = this.first;
		while(current!= null)
		{
			temp += current.data + "\n";
			current = current.link;
		}
		return temp;
	}
	
	
	public int getSize()
	{
		return this.count;
	}
	//receives: nothing
		// returns: returns a String of all transactions in current list instance that occurred on given date
		// each transaction is separated by a newline character. Returns an empty string
		// if no transactions occurred on received date.
	public String getTransactionListByDate(GregorianCalendar date)
	{
		String temp ="";
		Node<Transaction> current = this.first;
		while(current!=null)
		{
			if(date.equals(current.data.getDateCalendar()))
			{
				temp+= current.data + "\n";
			}
			current = current.link;
		}
		return temp;
	}
	//receives: nothing
		//returns:  true if this TransactionList instance contains received transaction false if not in list.
		// uses equals method and assumes it is overloaded for Transaction instances
	public boolean contains(Transaction transaction)
	{
		Node <Transaction> current = this.first;
		while(current!=null)
		{
			if(current.data.equals(transaction))
			{
				return true;
			}
			current = current.link;
		}
		return false;
	}
	// receives: nothing
		// returns: adds transaction to list if not full (at MAX_SIZE) and 
		//       if not in list already 
		//       returns true if added, false if not
		//       list remains sorted by date at all times (most recent to least recent date)
	public boolean add(Transaction transaction)
	{
		Node <Transaction> current = this.first;
		Node <Transaction> previous = null;
		if(this.getSize() >= MAX_SIZE)
		{
			return false;
		}
		while(current!= null)
		{
			if(current.data.equals(transaction))
			{
				return false; // found transaction already in list
			}
			if(current.data.getDateCalendar().compareTo(transaction.getDateCalendar())<=0)
			{
				break;
			}
			previous = current;
			current = current.link;
		}
		Node <Transaction> node = new Node <Transaction> (transaction);
		if(previous==null) // connected to the front
		{
			node.link = this.first;
			this.first = node;
		}
		else
		{
			node.link = previous.link;
			previous.link = node;
		}
		this.count ++;
		return true;
	}
	//receives: nothing
		// returns:  the transaction in the list at given position. 
		//       uses zero-based positions, so 0 is the position of the first transaction in the list
		//       returns null if received position is out of range for this transaction list instance.
		//  Example use:  
		//        TransactionList tList = new TransactionListImpl("transactions.txt");    
		// 		  Transaction t1 = list.get(0);
		//        assertTrue(t1!=null);
	public Transaction get(int position)
	{
		if(position <0 || position > count)
		{
			return null;
		}
		Node<Transaction> current = this.first;
		int index = 0;
		while(current != null)
		{
			if (index == position)
			{
				return current.data;
			}
			current = current.link;
			index += 1;
		}
		return null;
	}
	//receives: nothing
		// returns:  the position of received transaction in the list 
		//       (uses equals method which is overloaded when matching)
		//       returns -1 if received transaction is not found in current list at any position
		//        TransactionList list = new TransactionListImpl("transaction.txt");
		//        Deposit d2 = new Deposit("aabb","3/15/2017", 100.00).
		//		  int position = list.find(d2);
		//	      assertTrue(position != -1);
	public int find(Transaction transaction)
	{
		int position = 0;
		Node<Transaction> current= this.first;
		while (current != null)
		{
			if(transaction.equals(current.data))
			{
				return position;
			}
			current = current.link;
			position ++;
		}
		return -1;
	}
	// receives: nothing
	// returns:  transaction  in this list instance that matches given transaction, removes it from list
	//       list remains sorted by date after removal. (most recent to least recent)
	//       if transaction is not in the list instance, returns null
	public Transaction remove(Transaction transaction)
	{
		Node<Transaction> previous = null;
		Node<Transaction> current = this.first;
		while(current!= null)
		{
			if(current.data.equals(transaction))
			{
				break; //found it
			}
			previous = current;
			current = current.link;
			
		}
		if(current ==null)
		{
			return null;
		}
		Transaction retValue = current.data;
		if(previous==null)
		{
			this.first = this.first.link;
		}
		else {
			previous.link = current.link;
		}
		this.count --;
		return retValue;
	
	}
	//receives: nothing
		// task: all transactions removed from this list instance, 
	public void clear() 
	{
		this.first = null;
		this.count = 0;
	}
	
	
	
	
	
	
	
	/** Node.java
	 *implements Node class generically
	 * used for Linked List classes
	 * @version 1.1
	 */

	public class Node <DataType> {
	  public DataType data;       // the data portion of a Node (public since this is only used by use within a class implementation)
	  public Node<DataType> link; // the link portion of a Node (public since this is only used by use within a class implementation)

	/** creates an empty Node with both data and link null
	 */
	  public Node () {
	    this.data=null;
	    this.link = null;
	  }
	/** creates a Node with given data value, link is null
	 *@param theData - the data value to use
	 */
	  public Node  (DataType theData) {
	    this.data = theData;
	    this.link = null;
	  }
	/** creates a Node with given link value, data is null
	 *@param theLink - the link value to use
	 */
	  public Node  (Node<DataType> theLink) {
	    this.data = null;
	    this.link = theLink;
	  }


	/** creates a Node with given data and link
	 *@param  - theData - the data value to place into Node's data
	 *@param  - theLink - the value to link the Node to (next link)
	*/
	  public Node  (DataType theData, Node<DataType> theLink) {
	    this.data = theData;
	    this.link = theLink;
	 }
	}//end of Node<T> class


}
