package mynotes.patterns.structural.decorator;

public class DecoratorApp {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " =$" + beverage.cost());

		Beverage beverage2 = new HouseBlend();
		System.out.println(beverage2.getDescription() + " =$" + beverage2.cost());
		beverage2 = new Mocha(beverage2);
		System.out.println(beverage2.getDescription() + " =$" + beverage2.cost());
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " =$" + beverage2.cost());
		beverage2 = new Whip(beverage2);
		System.out.println(beverage2.getDescription() + " =$" + beverage2.cost());

	}
}
