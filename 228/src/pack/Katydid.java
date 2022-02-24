package pack;

public class Katydid extends Grasshopper {
	public Katydid (int size, String color) {
		super(size,color);
	}
	@Override 
	public String feedOn() {
		return "Variety";
	}
}
