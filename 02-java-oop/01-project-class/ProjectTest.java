
//import Project;
public class ProjectTest{

    public static void main(String[] args) {

        Project projectController = new Project("classProject", "project for class");
        projectController.setName("Deliver");
        projectController.setDescription("description for Deliver");
        projectController.setInitialCost(2000.00);
        System.out.println(projectController.getName());
        System.out.println(projectController.getDescription());

   
   projectController.elevatorPitch("Forward", "We are going forward", 5000.00);
   

    // System.out.println(projectController.elevatorPitch("Forward", "We are going forward", 5000.00));
}
}