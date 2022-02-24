package lab2;
import java.util.Random;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel4
{
  // TODO - add instance variables as needed
  private int Rabbitpopulation = 0;
  Random rand = new Random(137);

  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel4()
  {
    
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {

    return Rabbitpopulation;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  Rabbitpopulation += rand.nextInt(10);

  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  Rabbitpopulation = 0;
	 
  }
}