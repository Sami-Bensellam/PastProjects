package hw1;

public class TV {
	public static final double VOLUME_INCREMENT = 0.07;//the volume increment we will be adding by each time we need to use volume up or down
	private double Volume; //initializing a variable to use as the volume 
	private int curChannel;//initializing the variable to use as the current channel
	private int prevChannel;//initializing the variable to use as the previous channel
	private int Start;//initializing the variable to use as the starting channel and the bound for the least channel we can have
	private int numChannels;//initializing the number of channels 
	
	public TV(int givenStart, int givenNumChannels){
		Start = givenStart; //initialized the numbers so they could be used in all the methods
		numChannels = givenNumChannels; //initialized the numbers so they could be used in all the methods
		curChannel = Start;//set the first curChannel to Start 
		Volume = 0.5;//set volume to .5
	
	}
	public void channelDown() {
	//I saved curChannel as prevChannel before it is changed so the previous channel would be saved in prevChannel 
		prevChannel = curChannel;
	// I used modulo the same way I did for channel Up but instead I made it so each time you do channel down it subtracts from curChannel and basically increasing what we substract from start plus the number of channels
        curChannel = (Start+numChannels)-((numChannels-(curChannel-Start-1))%(numChannels));
	}
	public void channelUp() {
		//sets curChannel to prevChannel before it is changed
		prevChannel = curChannel;
		//I used modulo to set the bounds for increasing and if it reaches a certain point the modulo basically adds from zero again I also removed the starting values to make it simpler and added it back at the end
		curChannel = Start+((curChannel-Start+1)%(numChannels));
	}
	public String display() {
	//rounded volume times 100 to return un the method display
		int rVolume = (int) Math.round(Volume*100);
		return ("Channel "+curChannel+" Volume "+rVolume+"%");
	}
	public int getChannel() {
		//simply put returning CurChannel
		return curChannel;
	}
	public double getVolume() {
		//simply put returning Volume through return
		return Volume;
	}	
	public void goToPreviousChannel() {
	//Sets the current channel to the most recent previous channel. by assigning curChannel to previous channel
		curChannel = prevChannel;
	}
	public void resetStart(int givenStart) {
	
		Start = givenStart;//setting the private variable start to givenStart
		prevChannel = Math.max(prevChannel, Start);//setting the bounds of prevChannel using the selection of math min and math max(between Start and Start plus number of channels minus 1)
		prevChannel = Math.min(prevChannel, Start+numChannels-1);
	
		curChannel = Math.max(curChannel, Start);//setting the bounds of curChannel using the selection of math min and math max(between Start and Start plus number of channels minus 1)
		curChannel = Math.min(curChannel, Start+numChannels-1);
		}
	public void resetNumChannels(int givenNumChannels) {
		numChannels = givenNumChannels;//assigning the number of channels to the input of the method
		prevChannel = Math.min(prevChannel, Start+numChannels-1);//the previous channel after using the method to never be above the starting number plus the number of channels minus one 
		
		curChannel = Math.min(curChannel, Start+numChannels-1);//the previous channel after using the method to never be above the starting number plus the number of channels minus one 
	}
	public void setChannel(int channelNumber) {
	//assigning previous channel to curChannel since  it is going to change
		prevChannel = curChannel;
		curChannel = Math.min(channelNumber, (Start+numChannels-1));//bounds the channel channel Number to be less than start plus the number of channels minus 1
		curChannel = Math.max(curChannel, Start);//bounds the current channel to never be less than start(the starting number
	}
	public void volumeDown() {
//
		Volume = Math.max(Volume-VOLUME_INCREMENT,0);//binding the volume to always be more than zero because math max selects the bigger number

	}
	public void volumeUp() {
		Volume = Math.min(Volume+VOLUME_INCREMENT,1);//binding the number to always be less or equal to 1 since the math.min selects the smaller number between the number and 1 (in this case...)

	
	}
	
	
}
	
	

