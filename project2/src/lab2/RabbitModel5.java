package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel5
{
  // TODO - add instance variables as needed
  private int Rabbitpopulation = 0;
  private int Rabbitpopulation2 = 0;
  private int Rabbitpopulation3 = 1;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel5()
  {
    
  }  
 
  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {

    return Rabbitpopulation2;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  
	  
	  Rabbitpopulation2 = Rabbitpopulation + Rabbitpopulation3;
	  Rabbitpopulation = Rabbitpopulation3;
	  Rabbitpopulation3 = Rabbitpopulation2;
	  

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