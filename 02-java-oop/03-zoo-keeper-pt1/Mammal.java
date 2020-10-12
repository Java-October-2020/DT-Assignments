
public class Mammal {
 protected String species;
 // protected int health;
 protected int energyLevel;

 public Mammal() {
    // this.species = species;
    // this.health = health;
  }

  public Mammal(String species) {
    this.energyLevel = 100;
    this.species = species;

  }

  public Mammal(String species, int energyLevel) {
    this.energyLevel = energyLevel;
    this.species = species;

  }

  //getters
  public String getSpecies() {
    return species;
  }

  public int getEnergyLevel() {
    return energyLevel;
  }

  //setters
  public void setSpecies(String species) {
    this.species = species;
  }

  public void setEnergyLevel(int energyLevel) {
    this.energyLevel = energyLevel;
  }

  public int displayEnergy(String species, int energyLevel){
    this.energyLevel = energyLevel;
    this.species = species;
    System.out.println("The Energy Level for the " + species + " is: " + energyLevel + "\n");
    return energyLevel;
  }

//   public void battle(Attackable target) {
//     // decrement health
//     int currentHealth = target.getHealth();
//     currentHealth -= 5;
//     target.setHealth(currentHealth);
//   }
}