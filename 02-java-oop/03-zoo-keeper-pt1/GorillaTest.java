public class GorillaTest{
    
    //have the gorilla throw things 3 times, eat bananas twice and climb once; then print the gorilla's energy level.

    public static void main(String[] args) {
    
    Gorilla mightyJoe = new Gorilla();

    mightyJoe.throwSomething("chair");
  //  mightyJoe.displayEnergy(mightyJoe.getSpecies(), mightyJoe.getEnergyLevel());

    mightyJoe.throwSomething("water bottle");
    mightyJoe.eatBananas();
    mightyJoe.climb("tree");
  //  mightyJoe.displayEnergy("Gorilla", mightyJoe.getEnergyLevel());

    mightyJoe.throwSomething("banana peel");
    mightyJoe.eatBananas();
    mightyJoe.displayEnergy("Gorilla", mightyJoe.getEnergyLevel());

    }
}