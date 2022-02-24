package pack;

public class Grasshopper extends Insect implements Locomotion{
public Grasshopper(int size, String color) {
		super(size, color);
	}
@Override
public void move()
{
	System.out.println("hop");
	}
public String feedOn() {
	return "grass";
}
}
