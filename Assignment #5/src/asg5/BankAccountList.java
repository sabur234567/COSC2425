package asg5;

public interface BankAccountList
{

	public static final int MAX_SIZE = 15; // max # allowed in the list

	//receives: nothing
	// returns: number of BankAccounts currently in the list
	//  Example use
	//  BankAccountList list = new BankAccountListImpl();  // create empty list
	//   assertTrue(list.getSize() == 0);   // size should be 0
	//  boolean result = list.add(new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL));
	//  assertTrue(list.getSize() == 1);
	public int getSize();

	// receives: a BankAccount instance that is NOT null
	// returns:  true if received bankaccount matches any bankaccount in this list, 
	//          assumes equals is overloaded in BankAccount class 
	//          returns false if received bankaccount is not currently in this list
	public boolean contains(BankAccount bankaccount);

	//receives: a BankAccount instance that is NOT null
	//task:   bankaccount is added to this list if not already contained in this list
	//      (bank accounts must be unique for each account number)
	//returns:  true if bankaccount was added, false if no room in the list or duplicate
	//      bankaccount is found in the list
	//      a bankaccount is a duplicate if it has the same account number for our purposes
	//      Example use:
	//        BankAccountList list = new BankAccountListImpl();
	//        boolean result = list.add(new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL));
	//        assertTrue(result == true);
	public boolean add(BankAccount bankaccount);

	// receives: a positon (int) in this bank account list
	// returns: the bankaccount in the list at given position.
	//       uses zero-based positions, so 0 is the position of the first bank account in the list
	//       returns null if received position is out of range (0 to less than size of list.)
	//  Example use:
	//        BankAccountList list = new BankAccountListImpl();
	//        BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//        boolean result = list.add(b2);
	// 		  BankAccount b1 = list.get(0);
	//        assertTrue(b1.equals(b2));
	public BankAccount get(int position);

	// receives: a BankAccount instance (not null)
	// returns:  the position of received bankaccount in the list (0 based positioning)
	//       (uses overloaded equals when matching)
	//       returns -1 if received bankaccount is not found in current list at any position
	//        BankAccountList list = new BankAccountListImpl();
	//        BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//        boolean result = list.add(b2);
	//		  int position = list2.find(b2);
	//	      assertTrue(position == 0);
	public int find(BankAccount bankaccount);


	// receives: nothing
	// returns: a String containing a list (1 bank account per line) of bank accounts
	//      that have a balance below 0.0
	//      returns an EMPTY String if NO bank accounts have a balance less than 0.0
	//	    Example use:
	//	    BankAccountList list = new BankAccountListImpl();
	//        BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//        boolean result = list.add(b2);
	//        assertTrue(result == true);
	// 		String list1 = list.getBankAccountsDeficient();
	//      assertTrue(list1.equals(""));
	public String getBankAccountsDeficient();

	// receives: aAccountType, a bank account type
	// returns: a String containing a list (1 bank account per line) of bank accounts
	//       that are of the received account type.
	//    Example use:
	//	BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 		String list1 = list.getBankAccountsWithAccountType(AccountType.CHECKING);
	//      assertTrue(MyUtils.numberLines(list1) == 1);
	public String getBankAccountsWithAccountType(AccountType aAccountType);

	// receives: a last name (String)
	// returns: a String containing a list (1 bank account per line) of bank accounts
	//      with last name matching  received String, requires properFormat for comparisons of last names
	//      if no matches exist, returns empty string
	//  Example use:
	//	BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 		String accountNames = list.getBankAccountsWithMatchingLastName("GARCIA");
	//      assertTrue(MyUtils.numberLines(accountNames) == 1);
	public String getBankAccountsWithMatchingLastName(String aName);

	// receives: nothing
	// returns: nothing
	// task:   this BankAccountList is sorted by account number from lowest to highest (alphabetically)
	//  Example use (give 2 more):
	//	BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//      BankAccount b3 = new BankAccount("ddKK33"," ROGERS MetCALF","Mary Louise ",0.0,AccountType.SAVINGS, BusinessType.PERSONAL); 
	//      boolean result = list.add(b3);
	//      assertTrue(result == true);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	// 	list.sort();
	//      System.out.println("here is the sorted list:\n" + list);  // should be in appropriate order smallest acct number to largest
	//       should output: 1122aa  Garcia, Joey 0.0 CHECKING -- PERSONAL
	//                      ddkk33  Rogers Metcalf, Mary Louise  0.0 SAVINGS -- PERSONAL
	public void sort();

	// receives: a BankAccount instance, not null
	// returns:   a BankAccount instance  in this list that is found that MATCHES the
	//      received bankaccount (assume equals is overloaded for BankAccount)
	//      the BankAccount instance in the list that matched received bankaccount is removed
	//       from this list AND RETURNED.
	//       If no BankAccount instance is found that matches received bankaccount
	//       then null is RETURNED
	//    Example use:
	//      BankAccountList list = new BankAccountListImpl();
	//      BankAccount b2 = new BankAccount("1122AA","Garcia","Joey",0.0,AccountType.CHECKING, BusinessType.PERSONAL);
	//      BankAccount b3 = new BankAccount("ddKK33"," ROGERS MetCALF","Mary Louise ",0.0,AccountType.SAVINGS, BusinessType.PERSONAL);
	//      boolean result = list.add(b3);
	//      assertTrue(result == true);
	//      boolean result = list.add(b2);
	//      assertTrue(result == true);
	//      assertTrue(list.getSize() ==2);
	//      BankAccount remAct = list.remove(b2);
	//      assertTrue(remAct.equals(b2));
	//      assertTrue(list.getSize() == 1);
	//     Example use #2:
	//        remAct = list.remove(b2);
	//        assertTrue(remAct == null);
	public BankAccount remove(BankAccount bankaccount);

	// receives: nothing
	// returns: nothing
	// task:  this BankAccountList instance is made to be empty
	//        clear out all bank accounts from this instance
	public void clear();
}