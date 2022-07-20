interface Data {
	public double volume();
}

class Base implements Data {
	double radius;
	Base(double radius) {
		this.radius = radius;
	}
	public double volume() {
		return 0.0d;
	}
	void show() {
		System.out.printf("Radius: %f\n", radius);
	}
}

class CalVol extends Base {
	double ht;
	CalVol(double ht, double radius) {
		super(radius);
		this.ht = ht;
	}

	public double volume() {
		return 3.141592653589793 * Math.pow(radius, 2) * ht;
	}
	void show() {
		super.show();
		System.out.printf("Height: %f\nVolume: %f\n", ht, volume());
	}
}

class Test {
	public static void main(String[] args) {
		java.util.Scanner s = new java.util.Scanner(System.in);
		System.out.print("Enter the radius and height: ");
		CalVol cylinder = new CalVol(s.nextDouble(), s.nextDouble());
		cylinder.show();
		s.close();
	}
}
