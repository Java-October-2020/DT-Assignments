
public class Samurai extends Human{
    private static int numSamurai =0;
    public Samurai(){
        super("Samurai");//required to pull attributes for classTypes per constructor
        this.health = 200;
    }  
    
    public void deathBlow(Human target) {
        target.health = 0;
        this.health = this.health/2;
        System.out.printf("\nThe " + this.classType + "'s Death Blow takes the health of the " + target + ". Health has decreased to: " + target.health + "\n");

        System.out.printf("\nBut the " + this.classType + " has weakened his/her own health which decreased to: " + this.health + ". He needs time to meditate.\n");
      }
    
      public void meditate() {
        this.health = 200;
        System.out.printf("\n The " + this.classType + " has time to meditate and his/her health is fully restored to: " + this.health + "\n");
      }

      public static int howMany() {
        //returns the total current number of Samurai.
        numSamurai +=1;
        return numSamurai;
      }


}//end of Samurai