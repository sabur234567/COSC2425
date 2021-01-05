package asg3;

public class HousePet {
	public static final String DEFAULT_NAME = "Aa$$$$";
	public static final int DEFAULT_YEARBORN = 2019;
	private String petName;
	private int yearBorn;
	private PetType petType;
	private GenderType gender;
	
	// default constructor, creates a default HousePet instance
    // name: DEFAULT_NAME, year born: DEFAULT_YEARBORN, gender: Gender.UNKNOWN, pet type: PetType.UNKNOWN
	public HousePet()
	{
		this.setPetName(DEFAULT_NAME);
		this.setYearBorn(DEFAULT_YEARBORN);
		this.setGender(GenderType.UNKNOWN);
		this.setPetType(PetType.UNKNOWN);
	}
	// creates HousePet instance with given data, if any received data is invalid
    // puts default value into field
    // valid data:  1900 <= year born <= DEFAULT_YEAR_BORN
    // pet name:  may not be an empty string nor all whitespace, must have at least 2 letters in it.
    // any invalid name received, use  DEFAULT_NAME instead     
	public HousePet(String aName, int aYear, GenderType aGender, PetType aPetType)
	{
		this.setPetName(aName);
		this.setYearBorn(aYear);
		this.setGender(aGender);
		this.setPetType(aPetType);
	}
	//sets this HousePet's name to aName AFTER calling 
    //MyUtils.properFormat() method on it remember no empty or all whitespace strings for  pet names allowed
    //uses default name if received name is invalid
	public void setPetName(String aName)
	{
		int count = 0;
		String temp = "";
		temp = utils.MyUtils.properFormat(aName);
		for (int index = 0; index<temp.length(); index++)
		{
			char ch = temp.charAt(index);
			if(Character.isLetter(ch))
			{
				count += 1;
			}
		}
		if(count < 2)
		{
			this.petName = DEFAULT_NAME;
			return;
		}
		if (temp.isEmpty() || temp.length() < 2)
		{
			this.petName = DEFAULT_NAME;
		}
		else
		{
			this.petName = temp;
		}
	}
	//sets this HousePet's year born to given value if in proper range or use default year born    
	public void setYearBorn(int aYearBorn)    
	{
		if(aYearBorn < 1900 || aYearBorn > DEFAULT_YEARBORN)
		{
			this.yearBorn = DEFAULT_YEARBORN;
		}
		else
		{
			this.yearBorn = aYearBorn;
		}
	}
	//sets this HousePet's gender to given gender
	public void setGender(GenderType aGender)
	{
		this.gender = aGender;
	}
	// sets this HousePet's pet type to given pet type.
	public void setPetType(PetType aPetType)
	{
		this.petType = aPetType;
	}
	// returns the name of this HousePet
	public String getPetName()
	{
		return this.petName;
	}
	// returns the year born of this HousePet
	public int getYearBorn() 
	{
		return this.yearBorn;
	}
	// returns the gender  of this HousePet
	public GenderType getGender()
	{
		return this.gender;
	}
	// returns the pet type  of this HousePet
	public PetType getPetType()
	{
		return this.petType;
	}
	// returns a nicely formatted String of this HousePet on same line NO NEWLINE
    // NOTE: age of pet MUST be printed, rather than year born (hint: compute age using this year, 2019)
	public String toString()
	{
		String temp = "";
		temp += "NAME: "+this.getPetName();
		temp += " AGE: "+(DEFAULT_YEARBORN - this.getYearBorn());
		temp += " GENDER: "+ this.getGender();
		temp += " PET TYPE: "+ this.getPetType();
		return temp;
	}
}
