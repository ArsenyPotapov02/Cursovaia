package ApplicaionForWorkers;

import ApplicaionForWorkers.GUI.DataBase.DB;
import ApplicaionForWorkers.GUI.Controller;
import ApplicaionForWorkers.GUI.Security.Encryption;
import ApplicaionForWorkers.GUI.Window.AuthentacationWindow;
import ApplicaionForWorkers.GUI.Window.DetailInputWindow;
import ApplicaionForWorkers.GUI.Window.View;
import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        Company company = new Company();
        View view = new View();
        System.out.println(Encryption.encrypt("0000"));
        System.out.println(Encryption.encrypt("1111"));
        System.out.println(Encryption.encrypt("2222"));
        System.out.println(Encryption.encrypt("3333"));
        System.out.println(Encryption.encrypt("4444"));


        AuthentacationWindow authentacationWindow = new AuthentacationWindow(view);
        Controller controller = new Controller(company,db);
        controller.executeAuthenticationWindow(authentacationWindow,view);


        //DetailInputWindow window = new DetailInputWindow();
        controller.execute(view);
       // controller.executeDetailInputWindow(window);


    }
}
