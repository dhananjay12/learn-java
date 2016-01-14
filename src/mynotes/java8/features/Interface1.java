package mynotes.java8.features;

public interface Interface1 {
    
    //regular method declaration
    void method1();
     
    //default method with a body
     default String method2(){        
        return "Method 2 default implementation";
    }
 
}

class TestClient1 implements Interface1 {
	 
    @Override
    public void method1() {
        // TODO Auto-generated method stub
    }
 
}
