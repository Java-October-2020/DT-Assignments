public class Gorilla extends Mammal{
String item;
String structure;

public Gorilla(){
    super("Gorilla", 100);
    }

    public void eatBananas() {
    this.energyLevel += 10;
    System.out.printf("I am a %s and I love eating a banana\n", this.species);
  }

  public void throwSomething(String item){
    this.energyLevel -= 5;
    this.item = item;
    System.out.printf("I am a %s throwing a %s\n", this.species, this.item);
  }

  public void climb(String structure){
    this.energyLevel -= 10;
    this.structure = structure;
    System.out.printf("I am a %s and I've climbed this %s\n", this.species, this.structure);
  }

}