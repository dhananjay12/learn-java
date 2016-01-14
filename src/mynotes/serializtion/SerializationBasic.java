package mynotes.serializtion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SerializationBasic {
	
	public void writeObjects(){
		System.out.println("Writing Objects Begin...");
		
		/*Person person1=new Person("Jack",23);
		Person person2=new Person("Jill",25);
		System.out.println(person1);
		System.out.println(person2);*/
		/*Student student1=new Student("123", "Jack", 23, "CS");
		Student student2=new Student("124", "Jill", 25, "IT");
		System.out.println(student1);
		System.out.println(student2);*/
		
		ArrayList<Skills> skills=new ArrayList<Skills>();
		skills.add(new Skills("java", 4.3));
		skills.add(new Skills("pl/sql", 1));
		skills.add(new Skills("javaScript", 1));
		Employee employee1=new Employee("1", "jack", skills);
		System.out.println(employee1);
		
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		
		try {
			 fos =new FileOutputStream("storage.dat");
			 oos=new ObjectOutputStream(fos);
			
			//oos.writeObject(person1);
			//oos.writeObject(person2);
			
			//oos.writeObject(student1);
			//oos.writeObject(student2);
			
			oos.writeObject(employee1);
			
			oos.close();
			fos.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Writing Objects Exit...");
		
	}
	
	public void readObjects(){
		System.out.println("Reading Objects Begin...");
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		
		try {
			fis=new FileInputStream("storage.dat");
			ois=new ObjectInputStream(fis);
			
			/*Person person1=(Person) ois.readObject();
			Person person2=(Person) ois.readObject();
			System.out.println(person1);
			System.out.println(person2);*/
			
			/*Student student1=(Student) ois.readObject();
			Student student2=(Student) ois.readObject();
			System.out.println(student1);
			System.out.println(student2);
			*/
			
			Employee employee1=(Employee) ois.readObject();
			System.out.println(employee1);
			ois.close();
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Reading Objects Exit...");
	}
	
	public static void main(String[] args) {
		
		SerializationBasic aSerializationBasic=new SerializationBasic();
		aSerializationBasic.writeObjects();
		aSerializationBasic.readObjects();
	}
	
	

}
