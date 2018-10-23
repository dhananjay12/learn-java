package mynotes.shortConcepts;

public class SomeInitializers {

	int length = 10; // (1) Non-Static
	// double area = length * width; // (2) Not Ok. Illegal forward reference.
	double area = length * this.width; // (3) Ok, but width has default value 0.
	int width = 10; // (4)
	int sqSide = height = 20; // (5) OK. Legal forward reference.
	int height; // (6)
	int noOfDays = 7 * NO_OF_WEEKS;// (7) Nonstatic - OK- Legal forward as static varialbe will initialize first
	static int NO_OF_WEEKS = 52; // (8) Static
	//static int x=this.y; //(9) Not ok, illegal forward reference for static variables
	int y =10;
}
