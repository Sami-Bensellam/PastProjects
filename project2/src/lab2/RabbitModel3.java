package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel3
{
  // TODO - add instance variables as needed
  private int Rabbitpopulation = 500;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel3()
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
	  Rabbitpopulation = Rabbitpopulation/2;

  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  Rabbitpopulation = 500;
	 
  }
}