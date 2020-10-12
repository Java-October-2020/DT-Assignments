
public class Wizard extends Human{

    //int health; //Will cause different value
    //int intelligence; //Will cause different value

    public Wizard(){
        super("Wizard");
        this.health = 50;
        this.intelligence = 8;
    }


    public void checkWiz(){

        System.out.println("Wizard " + this.health + " " + "getIntelligence() " + this.intelligence + " stealth:" + this.stealth);
    }
//     public void eatHumans() {
//     this.energyLevel += 25;
//     System.out.printf("I am a %s and humans are soooo tastie, ... scream, crunch, snap, ummmm.\n", this.species);
//   }

//   public void attackTown(){
//     this.energyLevel -= 100;
//      System.out.printf("%s attacks a town. Sounds like ... SNAP, CRACKLE, BOOM!!!!!\n", this.species);
//   }

//   public void fly(){
//     this.energyLevel -= 50;
//     System.out.printf("The sound of a giant %s taking off: Whoop! Whoop! Whoop!\n", this.species);
//   }

}//end of Wizard