package mynotes.serializtion;

import java.io.Serializable;
import java.util.ArrayList;


public class Employee implements Serializable {

	private String id;
	private String name;
	
	private ArrayList<Skills> skills;

	public Employee(String id, String name, ArrayList<Skills> skills) {
		this.id = id;
		this.name = name;
		this.skills = skills;
	}

	@Override
	public String toString() {
		String output = "Id::" + this.id + " Name" + this.name + "\n";
		String skill = null;
		for (int i = 0; i < this.skills.size(); i++) {
			if (i == 0) {
				skill = skills.get(i).toString() + "\n";
			} else {
				skill = skill + skills.get(i).toString() + "\n";
			}
		}

		return output + skill;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Skills> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<Skills> skills) {
		this.skills = skills;
	}

}
