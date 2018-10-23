package mynotes.serializtion;

import java.io.Serializable;

public class Skills implements Serializable{
	
	private String language;
	private double yearOfExperiace;
	
	public Skills(String language,double yearOfExperiace) {
		this.language=language;
		this.yearOfExperiace=yearOfExperiace;
	}
	
	@Override
	public String toString() {
		return "Language::"+this.language+" Exp::"+this.yearOfExperiace;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public double getYearOfExperiace() {
		return yearOfExperiace;
	}
	public void setYearOfExperiace(double yearOfExperiace) {
		this.yearOfExperiace = yearOfExperiace;
	}
	

}
