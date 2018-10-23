package mynotes.shortConcepts;

import java.util.Date;

public class ImmutableClass {

	private final String name;	//Immutable
	private final String mobile;//Immutable
	private final Date dateOfBirth;//Mutable

	public ImmutableClass(String name, String mobile,Date dob) {
		this.name = name;
		this.mobile = mobile;
		this.dateOfBirth=dob;
	}

	public String getName() {
		return name;
	}

	public String getMobile() {
		return mobile;
	}
	
	//Here we returned a new object instead of giving reference that could lead to problems
	public Date getDateOfBirth() {
		return (Date)dateOfBirth.clone();
	}

}
