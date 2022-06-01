package ApplicaionForWorkers;

import ApplicaionForWorkers.GUI.DataBase.DB;
import ApplicaionForWorkers.GUI.Controller;
import ApplicaionForWorkers.GUI.Window.DetailInputWindow;
import ApplicaionForWorkers.GUI.Window.View;
import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;

public class Main {
    public static void main(String[] args) {
        DB db = new DB();
        Company company = new Company();


        try {
            db.openDB();
            //db.createDB();
//
            //db.createDetail(new Detail(444, "Крыло", 111, 100));
           // db.createDetail(new Detail(442, "Кабина", 111, 102));
//            dataBase.addProduct(new Product(445, "молоко", 30, 100));
//            dataBase.addProduct(new Product(446, "кефир", 40, 100));
            //dataBase.deleteProduct(450);
            //dataBase.updateProduct(451, 20);
            //dataBase.getCashierID("Сергей");
            //dataBase.addCashier(new Cashier("Сергей", "админ"));
           // controller.setDataBase(db);
            company.setReportList(db.getReportList());
            company.setWorkersList(db.getWorketsList());
            company.setDetailList(db.getDetailsList());
            //store.setCashierList(dataBase.getCashierList());
            //dataBase.buyProduct(444, 20);
            //System.out.println(dataBase.getReceiptCount());

            db.closeDB();
        } catch (Exception e) {
           // System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Controller controller = new Controller(company,db);

        View view = new View();
        //DetailInputWindow window = new DetailInputWindow();
        controller.execute(view);
       // controller.executeDetailInputWindow(window);


    }
}
