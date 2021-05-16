package mynotes.shortConcepts;

public class AssertionExample {
	
	public double calculateSpeed(double distance, double time){
		
		assert distance>=0.0;
		assert time>=0.0 : "Time is not positive="+time;
		double speed =distance/time;
		return speed;
		
	}
	
	public static void main(String[] args) {
		AssertionExample aAssertionExample=new AssertionExample();
		//double speed= aAssertionExample.calculateSpeed(13, 2);
		//double speed= aAssertionExample.calculateSpeed(-13, 2);
		double speed= aAssertionExample.calculateSpeed(13, -2);
		System.out.println("Speed in km/h = "+ speed);
	}

}
