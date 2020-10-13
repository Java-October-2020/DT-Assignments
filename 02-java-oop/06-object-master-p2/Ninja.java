import java.util.jar.Attributes.Name;

public class Ninja extends Human{

    public Ninja(){
        super("Ninja"); //required to pull attributes for classTypes per constructor
        this.stealth = 10;
      }

    public void steal(Human target) {
        target.health -= this.stealth;
        System.out.println("\n" + this.classType + " steals from " + target.classType + " reducing his/her health to: " + target.health + "\n");
      }

      public void runAway(){
        System.out.println("Ninja health = " + this.health);
        this.health -= 10;
        System.out.printf("\n" + this.classType + " runs away. Health has decreased to: " + this.health + "\n");
      }

}//end of Ninja