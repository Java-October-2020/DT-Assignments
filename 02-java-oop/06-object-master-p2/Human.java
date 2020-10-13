
public class Human{
protected int strength;
protected int stealth;
protected int intelligence;
protected int health;
protected String classType;  //Wizard, Ninja, Samurai, Warrior


public Human(){

}

public Human(String classType){
    this.strength = 3;
    this.stealth = 3;
    this.intelligence = 3;
    this.health = 100;
    this.classType = classType;
}



public Human(int strength, int stealth, int intelligence, int health, String classType){
    this.strength = strength;
    this.stealth = stealth;
    this.intelligence = intelligence;
    this.health = health;
    this.classType = classType;
}

//getters
public int getStrength(){
    return this.strength;
}

public int getStealth(){
    return this.stealth;
}

public int getIntelligence(){
    return this.intelligence;
}

public int getHealth(){
    return this.health;
}

public String getClassType(){
    return this.classType;
}

//setters
public void setStrength(int strength){
this.strength = strength;
}

public void setStealth(int stealth){
    this.stealth = stealth;
    }

public void setIntelligence(int intelligence){
    this.intelligence = intelligence;
    }

public void setHealth(int health){
    this.health = health;
    }

public void setClassType(String classType){
    this.classType = classType;
    }


public void attack(String human, Human target){
//attack reduces the target's health by the attacker's strength

System.out.println("The attacking human is: " + human + " the " + this.classType + ".");
    System.out.println("Target is: " + target.classType);

target.health -= this.getStrength();
System.out.println("After the attack the new health score for the " + target.classType + " is: " + target.health + "\n");

}//end of attack

public int displayHealth(String classType, int health){
    this.classType = classType;
    this.health = health;
    System.out.println("The health for the " + classType + " is: " + health + "\n");
    return health;
  }

}//end of human