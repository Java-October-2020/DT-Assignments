package demoProject;

import java.util.ArrayList;

public class AnimalController {
public static void main(String[] args) {
	Animal dog = new Animal("Buster", "dog", 4, 56);
		
		System.out.println("Spring Tool Suite is great!");
		
		ArrayList<Animal> myAnimals = new ArrayList<Animal>();
		
		myAnimals.add(dog);
		for(Animal a:myAnimals) {
			System.out.println("Array of animals includes: "+ a.getSpecies());
		}
}

}
