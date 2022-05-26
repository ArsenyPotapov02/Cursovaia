package ApplicaionForWorkers;

import ApplicaionForWorkers.GUI.BD;
import ApplicaionForWorkers.GUI.Controller;
import ApplicaionForWorkers.GUI.Window.View;

public class Main {
    public static void main(String[] args) {

        //Company company = new Company();
        View view = new View();

        Controller controller = new Controller();
        controller.execute(view);
        BD.BDmain();
    }
}
