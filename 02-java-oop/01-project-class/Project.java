
public class Project{
    private String name;
    private String description;
    private double initialCost;

    //getters
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getInitialCost(){
        return initialCost;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }

    public Project() {}

    public Project(String name) {}

    public Project(String name, String description) {}

    public static String elevatorPitch(String name, String description, double initialCost){
            result = (name + "(" + initialCost + ")" + ":" + description);
        return  result;

    }

}//end of Project Class