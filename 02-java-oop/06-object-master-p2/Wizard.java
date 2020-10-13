
public class Wizard extends Human{

    //int health; //Will cause different value
    //int intelligence; //Will cause different value

    public Wizard(){
        super("Wizard"); //required to pull attributes for classTypes per constructor
        this.health = 50;
        this.intelligence = 8;
      }

    // public void checkWiz(){
    //     System.out.println("Wizard " + this.health + " " + "getIntelligence() " + this.intelligence + " stealth:" + this.stealth);
    // }

    public void heal(Human target) {
    target.health += this.intelligence;
    System.out.printf("\n" + target.classType + " is provided a portion of healing. Health has increased to: " + target.health + "\n");
  }

  public void fireBall(Human target) {
    target.health -= (3 * this.intelligence);
    System.out.printf("\n" + target.classType + " is hit with the wizard's fireball. Health has decreased to: " + target.health + "\n");
  }

}//end of Wizard