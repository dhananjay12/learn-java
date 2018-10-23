package mynotes.shortConcepts;

public class PassByValue {

	public static void tricky(Point p1, Point p2) {
		p1.setX(100);
		p1.setY(100);
		Point temp = p1;
		p1 = p2;
		p2 = temp;
		System.out.println("p1::"+p1);
		System.out.println("p2::"+p2);
	}

	public static void main(String[] args) {

		Point point1=new Point(0,0);
		Point point2=new Point(50,50);
		System.out.println("Point1::"+point1);
		System.out.println("Point2::"+point2);
		tricky(point1,point2);
		System.out.println("Point1::"+point1);
		System.out.println("Point2::"+point2);

	}

}
