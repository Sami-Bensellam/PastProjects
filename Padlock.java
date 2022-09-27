package hw2;

import java.util.Random;//importing Random for Randomize positions

//WHICH DISK OR DISC IS THE RIGHT WORD FOR DISC-K I HAVE NO IDEEAAAA

public class Padlock{
private int Disk3;//disc 3 which is the main disc
private int Disk2;//disc 2 which is the middle disc
private int Disk1;//disc 1 is the farthest disc 
private boolean Alignment;//boolean which gives off true or false for whether the padlock is aligned with padlock
private boolean isopen = true;//boolean which changes based of wether
private int PLK1;//Padlock key for disk 3
private int PLK2;//Padlock key for disk 2
private int PLK3;//Padlock key for disk 1
private int tempDisk2;//it stores an unchanged Disk2
private int difference;//difference is how much disk2 moved
private int tempDisk3;//it stores an unchanged Disk3
public final static int TOOTH = 2; // TOOTH width which is a constant
private int Distance1;//the distance between Disk2 and 3
private int Distance2;//the distance between Disk1 and 2
/**
 * 
 * @param n1
 * @param n2
 * @param n3
 */
	public Padlock(int n1, int n2, int n3) {
		Random rand = new Random();//Initializing rand
		PLK1 = n3;//PLK1 is the padlock key for Disk3
		PLK2 = n2;//PLK2 is the padlock key for Disk2
		PLK3 = n1;//PLK3 is the padlock key for Disk1
		Disk3 = 0;//I just initialized each disk to the starting positions 0 2 and 4
		Disk2 = 2;
		Disk1 = 4;
	}
	/**
	 * 
	 * @param n1
	 * @param n2
	 * @param n3
	 */
	public void setPositions(int n1, int n2, int n3) {
		Disk3 = (n3+360)%360;//Disk3 is equal to n3 and I formatted it so that even if the number is negative It formatts correctly.
		Disk2 = (n2+360)%360;
		Disk1 = (n1+360)%360;
		
		if((Math.abs(Disk3 - Disk2)<2)) {//I used an if statement so if the difference between Disk3 and Disk2 is less than 2 Disk3 we add 2 to disk2
			Disk2 = (Disk3+2)%360;//I added modulo just in case it goes above 360
		}
		if((Math.abs(Disk2-Disk1))<2) {//I did the same thing as the fist if statement but changed Disk3 for 2 and Disk2 for 1
			Disk1 = (Disk2+2)%360;
		}
		if((Disk2 == 0)&&(Disk3== 359)) {//I added this one in case it is in 359 because the if statements on top do not include the edge between 359 and 1 since comparing them would make 359 -0 would be 359
			Disk2 = (Disk3 + TOOTH)%360;
		}

		//is disk2-disk1 > 2 == disk
	}
	public void turnLeftTo(int number) {
		
		turn(getDifference(number, Disk3));//I basically found the distance between Disk3 and number and added it to turn 
		
	}
	public void turnRightTo(int number) {
		turn(-getDifference(Disk3, number));//I did the same thing as the first one but rather I found the opposite distance
	
}
	
	public void turn(int degrees) {
		if(degrees >= 0) {
			tempDisk2 = Disk2;//saves the original position of disk3
			tempDisk3 = Disk3;//saves the original position of disk2
			Distance1 = getDifference(Disk2, Disk3);//finds the distance between Disk2 and Disk3
			Distance2 = getDifference(Disk1, Disk2);//finds the distance between Disk 1 and Disk2
			Disk3 = ((Disk3+degrees)%(360));//adding the degrees input into disk3 plus setting the modulo so it resets once they reach 360
				if(degrees > Distance1) {//compares the disance between Disk3 and Disk2 whether it is greater than degrees 
				
					Disk2 = Disk3+2; //if the degrees are greater than the distance between Disk3 and Disk2 Disk2 should become Disk3 + 2 since it attaches 
					difference =  degrees - getDifference(tempDisk2, tempDisk3);
					
					if(difference > Distance2) {//The same thing done but instead with how much Disk2 moved and the distance between disk2 and disk3
						
						Disk1 = Disk2 +TOOTH;
						Disk1 = Disk1%360;
					}
				
				Disk2 = Disk2%360;
				}
					}
		else {
			degrees = degrees*-1;//I did the same thing as in turn positive but rather changed the difference to be the other distance between disk2 and 3, and disk2 and 1 
			tempDisk3 = Disk3;
			tempDisk2 = Disk2;
			Distance1 = getDifference(Disk3, Disk2);//gets the opposite distance between disk 3 and 2 
			Distance2 = getDifference(Disk2, Disk1);//gets the opposite distance between disk 2 and 1
			Disk3 = (360)-((360-(Disk3-degrees))%(360));

			if(degrees > Distance1) {

						Disk2 = Disk3-TOOTH; 
						Disk2 = 360-((360-Disk2)%360);//for this method I just substracted what ever the turn method is and did a modulo and substracted again to always get a positive number so that it always rotates between 0 and 359
						difference = degrees - getDifference(tempDisk3, tempDisk2);
						
						if(difference > Distance2) {//I did the same thing but with Disk 2 and 1 rather than Disk3 and 2
							
							Disk1 = Disk2-TOOTH;
							Disk1 = 360-((360-Disk1)%360);
						}
					
					Disk2 = Disk2%360;
					}
						}
		
	}
	/**
	 * 
	 * @param which basically which disc should the method return
	 * @return	returns the disc selected
	 */
	public int getDiscPosition(int which) {
		if(which == 1) {//the if statement checks which number is input
			return Disk1;
		}
		if(which == 2) {
			return Disk2;
		}
		if(which == 3) {
			return Disk3;
		}
		else {
		return 69;
		}
		}
	/**
	 * 
	 * @return returns if the disks are aligned or not
	 */
	public boolean isAligned(){
		if((Disk3 == PLK1)&&(Disk2 == (PLK2+TOOTH)%360)&&(Disk1 == (PLK3-(TOOTH*2)+360)%360)) {
			//compares whether the disks are aligned and since the TOOTH is a certain width the Disks to be aligned the Disk 2 should be one tooth less since we are moving backwards and disk 1 should be 2 TOOTHS forward
			Alignment = true;
		}
		return Alignment;	
	}
	public void open() {
		if(isAligned() == true) {//checks if the disks are aligned to open
			isopen = true;//sets is open to true
		}
	}
	public void close() {
		isopen = false;//closes the padlock using the isopen boolean
		
	}
	public boolean isOpen() {
		return isopen;//returns the boolean isopen when checking if the padlock is open or closed
	}
	//finds the difference between 2 numbers input and could be used to find the distance between two numbers
	private int getDifference(int number2, int number1){
	if(number2 - number1 < 0) {//if the difference between the number is negative it adds to 360 because that means that the distance is over since the lock is 360
		return 360 + (number2 - number1);
	}
	else {
		return number2 - number1;//returns the difference if it's positive
	}
	}
	public void randomizePositions(Random rand){//randomized the positions of each disk in the padlock
	Disk3 = rand.nextInt(360);//randomizes disk3 using rand with the parameter 360
	Disk2 = rand.nextInt(360);//randomizes disk2 using rand with the parameter 360
	Disk1 = rand.nextInt(360);//randomizes disk1 using rand with the parameter 360

	}
}

