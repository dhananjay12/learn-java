package mynotes.designPatterns.creational;

public class App {

	public static void main(String[] args) {
		Animal animal = AnimalFactory.createAnimal(AnimalFactory.DOG);
		animal.speak();

	}

}
