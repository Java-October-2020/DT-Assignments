
public class HumanTest{


   public static void main(String[] args) {
    Human Brutus = new Human("Warrior");
    Human Che = new Human("Ninja");
    Human Mansford = new Human("Wizard");

    Brutus.attack("Brutus", Che);
    Mansford.attack("Mansford", Che);
    Brutus.attack("Brutus", Che);
    Brutus.attack("Brutus", Mansford);
    Che.attack("Che", Che);
    Che.attack("Che", Brutus);

    Brutus.displayHealth(Brutus.getClassType(), Brutus.getHealth());
   
    Che.displayHealth(Che.getClassType(), Che.getHealth());
  

    Mansford.displayHealth(Mansford.getClassType(), Mansford.getHealth());
   }
    
}