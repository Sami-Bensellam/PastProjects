package pack;

public class Test {
public static void main(String[] args) {
	Locomotion b;
	b = new Grasshopper();
	
	b.move();
	
	b = new Bee();
	
	b.move();
	
	((Bee) b).makeHoney();
}
}
