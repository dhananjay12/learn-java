package mynotes.shortConcepts;

public class BuggyInitializer {	
	
	public int length=10;
	public int area=getArea();//BUG
	public int breath=5;
	
	public int getArea(){
		System.out.println("length::"+this.length);
		System.out.println("breath::"+this.breath);
		return this.length*this.breath;
	}	

	public static void main(String[] args) {
		BuggyInitializer aBuggyInitializer=new BuggyInitializer();
		System.out.println("After Object creation");
		System.out.println("area::"+aBuggyInitializer.area);
		System.out.println("length::"+aBuggyInitializer.length);
		System.out.println("breath::"+aBuggyInitializer.breath);

	}
}
