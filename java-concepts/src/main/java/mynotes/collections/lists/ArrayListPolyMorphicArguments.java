package mynotes.collections.lists;

import java.util.ArrayList;

public class ArrayListPolyMorphicArguments {

	public static void testOnArrays() {
		Animal[] animals = { new Dog(), new Cat()};
		Dog[] dogs = { new Dog(), new Dog()};
		System.out.println("Pass Animals Array");
		methodTakesArrayOfAnimals(animals);
		System.out.println("Pass Dogs Array");
		methodTakesArrayOfAnimals(dogs);

	}

	public static void testOnArraLists() {
		ArrayList<Animal> animals = new ArrayList<Animal>();
		System.out.println("Pass Animals ArrayList");
		animals.add(new Dog());
		animals.add(new Cat());
		methodTakesArrayListOfAnimals(animals);
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		System.out.println("Pass Animals ArrayList");
		dogs.add(new Dog());
		dogs.add(new Dog());
		//methodTakesArrayListOfAnimals(dogs);//Compile Time Error
		methodTakesArrayListOfAnimalsWildCard(dogs);
	}

	public static void methodTakesArrayOfAnimals(Animal[] animals) {
		for (Animal animal : animals) {
			animal.eat();
		}
	}
	public static void methodTakesArrayListOfAnimals(ArrayList<Animal> animals) {
		for (Animal animal : animals) {
			animal.eat();
		}
	}
	public static void methodTakesArrayListOfAnimalsWildCard(ArrayList<? extends Animal> animals) {
		for (Animal animal : animals) {
			animal.eat();
		}
		
	}

	public static void main(String[] args) {
		testOnArrays();
		testOnArraLists();
	}

}
