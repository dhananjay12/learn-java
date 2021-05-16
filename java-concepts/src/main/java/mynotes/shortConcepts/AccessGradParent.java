package mynotes.shortConcepts;

class GrandParent {
	int x = 10;
}

class Parent extends GrandParent {
	int x = 20;
}

class Child extends Parent {
	int x = 30;

	void show() {
		System.out.println("Child=>"+x);
		System.out.println("Parent=>"+super.x);
		System.out.println("GrandParent=>"+((GrandParent)this).x);
	}
}

public class AccessGradParent {
	public static void main(String[] args) {
		(new Child()).show();
	}
}
