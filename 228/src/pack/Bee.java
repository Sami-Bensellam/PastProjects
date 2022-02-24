package pack;

public class Bee extends Insect implements Locomotion, Polination{

public Bee(int size, String color) {
		super(size, color);
	}
@Override
public void move() {
System.out.println("fly");
}
public void makeHoney() {
	System.out.println("orange blossom");

}
public String getSwarm() {
	return swarm;
}
}
