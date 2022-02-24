package lab2;

/**
 * A RabbitModel is used to simulate the growth
 * of a population of rabbits. 
 */
public class RabbitModel
{
  // TODO - add instance variables as needed
	private int lastYearPopulation;
	private int population;
	  private int previousYearPopulation;
  /**
   * Constructs a new RabbitModel.
   */
  public RabbitModel()
  {
	   lastYearPopulation = 1;
	   population = 1;
	   previousYearPopulation = 0;
  }  

  /**
   * Returns the current number of rabbits.
   * @return
   *   current rabbit population
   */
  public int getPopulation()
  {

    return population;
  }
  
  /**
   * Updates the population to simulate the
   * passing of one year.
   */
  public void simulateYear()
  {
	  
	  
	  previousYearPopulation = lastYearPopulation;
	  lastYearPopulation = population;
	  population = lastYearPopulation + previousYearPopulation;
	  
	  

  }
  
  /**
   * Sets or resets the state of the model to the 
   * initial conditions.
   */
  public void reset()
  {
	  lastYearPopulation = 1;
	   population = 1;
	   previousYearPopulation = 0;	 
  }
}