
public class HumanTest{


   public static void main(String[] args) {
    Human Brutus = new Human("Warrior");
    Human Che = new Human("Ninja");
    Human Mansford = new Human("Wizard");

    Brutus.attack("Brutus", Che);
    Mansford.attack("Mansford", Che);
    Brutus.attack("Brutus", Che);
    Brutus.attack("Brutus", Mansford);
    Che.attack("Che", Mansford);
    Che.attack("Che", Brutus);

    Brutus.displayHealth(Brutus.getClassType(), Brutus.getHealth());
   
    Che.displayHealth(Che.getClassType(), Che.getHealth());
  

    Mansford.displayHealth(Mansford.getClassType(), Mansford.getHealth());

    //A new wizard enters to assist Mansford
    Wizard Rylie  = new Wizard();
    //Rylie.checkWiz();
    Rylie.heal(Mansford);
    Rylie.fireBall(Che);
   // Rylie.attack("Rylie", Mansford);

    //Human Joi = new Human("Samurai"); //does not work
    Samurai Joi = new Samurai();
    Joi.deathBlow(Rylie);

      Ninja Li = new Ninja();
    //Li responds to attack
   Li.steal(Mansford);
   Li.runAway();

   Joi.meditate();
   System.out.printf("\n There are(is) " + Joi.howMany() + " Samurai.\n");

    //DT Note: values of Rylie.intelligence and Rylie.getIntelligence vary if declaration of int intelligence; is added outside of constructor.
   //  System.out.println("\nWizard intelligence: " + Rylie.intelligence + " " + Rylie.getIntelligence() + " <This last digit is incorrect. " + Rylie.health + " health: " + Rylie.getHealth());
   }
    
}