public class BatTest{
    
    //have the gorilla throw things 3 times, eat bananas twice and climb once; then print the gorilla's energy level.

    public static void main(String[] args) {
    
    Bat mayDaun = new Bat();

    mayDaun.attackTown();
    mayDaun.fly();
  //  mayDaun.displayEnergy(mayDaun.getSpecies(), mayDaun.getEnergyLevel());

    mayDaun.attackTown();
    mayDaun.eatHumans();
    mayDaun.fly();
  //cd  mayDaun.displayEnergy("Gorilla", mayDaun.getEnergyLevel());

    mayDaun.attackTown();
    mayDaun.eatHumans();
    mayDaun.displayEnergy(mayDaun.getSpecies(), mayDaun.getEnergyLevel());

    }
}