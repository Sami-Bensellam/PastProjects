package lab2;

public class TestModel
{
  public static void main(String[] args)
  {
    RabbitModel5 model = new RabbitModel5();

    // Check that the initial population is 2
    System.out.println(model.getPopulation());
    System.out.println("Expected 0");

    // A year goes by...
    model.simulateYear();
    System.out.println(model.getPopulation());
    System.out.println("Expected 1");

    model.simulateYear();
    System.out.println(model.getPopulation());
    System.out.println("Expected 2");

    model.simulateYear();
    System.out.println(model.getPopulation());
    System.out.println("Expected 3");

    model.simulateYear();
    System.out.println(model.getPopulation());
    System.out.println("Expected 0");

    model.simulateYear();
    System.out.println(model.getPopulation());
    System.out.println("Expected 1");

    model.simulateYear();
    System.out.println(model.getPopulation());
    System.out.println("Expected 2");

    
    // Start over
    model.reset();
    System.out.println(model.getPopulation());
    System.out.println("Expected 0");
  }
}