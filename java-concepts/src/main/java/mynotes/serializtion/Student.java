package mynotes.serializtion;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Student extends Person {

	private String id;
	private String stream;

	public Student(String id, String name, int age, String stream) {
		super(name, age);
		this.id = id;
		this.stream = stream;

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	/*private void writeObject(ObjectOutputStream oos) throws NotSerializableException {
		throw new NotSerializableException();
	}

	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		throw new IOException();
	}
*/
	@Override
	public String toString() {
		return "Name::" + super.getName() + " Age::" + super.getAge() + " Id::"
				+ this.id + " Stream::" + this.stream;
	}

}
