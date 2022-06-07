package ApplicaionForWorkers.utility.DataBase;

import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.ReportAboutWorks;
import ApplicaionForWorkers.Model.Workers;
import ApplicaionForWorkers.utility.Constant;


import java.sql.*;
import java.util.ArrayList;

public abstract class SqliteHelper {

    private Connection connection;
    private PreparedStatement statement;
    private ResultSet resultSet;

    public void openDB() throws SQLException{
        connection = DriverManager.getConnection(Constant.URL);
        if (connection != null){
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getDriverName());
        }

    }
    public void closeDB() throws  SQLException{
        connection.close();
    }

    public void createDB() throws SQLException, Exception{
        statement = connection.prepareStatement("CREATE TABLE Department " +
                "(Number_of_department INTEGER NOT NULL Check (Number_of_department > 0)," +
                "Name_of_department TEXT NOT NULL," +
                "Quantity_of_workers INTEGER NOT NULL Check (Quantity_of_workers >= 0 )," +
                "PRIMARY KEY( Number_of_department )" +
                ");");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE Details (" +
                "Code_detail INTEGER NOT NULL Check (Code_detail > 0 )," +
                "Name_of_detail TEXT NOT NULL," +
                "Department_number integer null Check (Department_number > 0) ," +
                "Quantity INTEGER NOT NULL Check (Quantity>=0)," +
                "FOREIGN KEY( Department_number ) REFERENCES Department( Number_of_department )," +
                "PRIMARY KEY( Code_detail )" +
                ");");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE  Workers " +
                "( ID_worker INTEGER NOT NULL Check (ID_worker > 0)," +
                "Department_number INTEGER NOT NULL Check (Department_number > 0)," +
                "Full_name TEXT NOT NULL," +
                "Position TEXT NOT NULL," +
                "Adress TEXT NOT NULL," +
                "Phone_number TEXT NOT NULL check (length (Phone_number) = 12)," +
                "Salary INTEGER NOT NULL Check (Salary > 0)," +
                "Password	TEXT NOT NULL UNIQUE," +
                "FOREIGN KEY( Department_number ) REFERENCES Department(Number_of_department)," +
                "PRIMARY KEY(ID_worker AUTOINCREMENT)" +
                ");");
        statement.execute();
        statement = connection.prepareStatement("CREATE TABLE Accomplishment " +
                "( ID_work INTEGER NOT NULL Check (ID_work > 0)," +
                " ID_worker INTEGER NOT NULL Check (ID_worker > 0)," +
                " Work_with_details Text NOT NULL," +
                " Check_of_complete_work text NOT NULL," +
                " Code_detail INTEGER NOT NULL Check (Code_detail > 0)," +
                " FOREIGN KEY( ID_worker ) REFERENCES Workers(ID_worker)," +
                " FOREIGN KEY( Code_detail ) REFERENCES Details(Code_detail)," +
                " PRIMARY KEY( ID_work  AUTOINCREMENT)" +
                ");");
        statement.execute();
//        statement = connection.prepareStatement("Insert into Department (Number_of_department, Name_of_department, Quantity_of_workers) values (111,'Малярный отдел', 26)");
//        statement.execute();
//        statement = connection.prepareStatement("Insert into Department (Number_of_department, Name_of_department, Quantity_of_workers) values (21,'Отдел сборки', 23)");
//        statement.execute();
//        statement = connection.prepareStatement("Insert into Department (Number_of_department, Name_of_department, Quantity_of_workers) values (32,'Энергетический отдел', 22)");
//        statement.execute();
//        statement = connection.prepareStatement("Insert into Department (Number_of_department, Name_of_department, Quantity_of_workers) values (1,'Испытания отдел', 26)");
//        statement.execute();
//        statement = connection.prepareStatement("Insert into Details (Code_detail, Name_of_detail, Department_number,Quantity) values (1,'фюзеляж', 32, 2)");
//        statement.execute();
//        statement = connection.prepareStatement("Insert into Details (Code_detail, Name_of_detail, Department_number,Quantity) values (2,'Киль', 21, 3)");
//        statement.execute();
        statement.close();
    }

    public void updateWorker(int id_worker, int departmentNumber, String fullName, String position, String adress, String phone_number, int salary, String password) throws SQLException{
        statement = connection.prepareStatement("Update Workers Set Department_number = ?, Full_name = ?, Position = ?, Adress = ?, Phone_number = ?, Salary = ?, Password = ? where ID_worker = ?; ");
        statement.setObject(1,departmentNumber);
        statement.setObject(2,fullName);
        statement.setObject(3,position);
        statement.setObject(4,adress);
        statement.setObject(5,phone_number);
        statement.setObject(6,salary);
        statement.setObject(7,password);
        statement.setObject(8,id_worker);
        statement.executeUpdate();
        statement.close();
    }

    public void updateAccomplishment(int iD_worker, String workWithDetails, String checkOfCompleteWork, int codeDetail, int id_work) throws SQLException{
        statement = connection.prepareStatement("Update Accomplishment Set ID_worker = ?, Work_with_details = ?, Check_of_complete_work = ?, Code_detail = ? where ID_work = ?; ");
        statement.setObject(1,iD_worker);
        statement.setObject(2,workWithDetails);
        statement.setObject(3,checkOfCompleteWork);
        statement.setObject(4,codeDetail);
        statement.setObject(5,id_work);
        statement.executeUpdate();
        statement.close();
    }
    public void updateDetails(int code, String nameOfDetail, int departmentNumber, int quantity) throws SQLException{
        statement = connection.prepareStatement("Update Details Set Name_of_detail = ?, Department_number = ?,  Quantity = ?  where Code_detail = ?;");
        statement.setObject(1,nameOfDetail);
        statement.setObject(2,departmentNumber);
        statement.setObject(3,quantity);
        statement.setObject(4,code);
        statement.executeUpdate();
        statement.close();

    }

    public void createWorker(Workers workers) throws SQLException{
        statement = connection.prepareStatement("INSERT INTO Workers(Department_number, Full_name , Position , Adress , Phone_number , Salary, Password ) VALUES (?,?,?,?,?,?,?);");
        statement.setObject(1,workers.getDepartmentNumber());
        statement.setObject(2,workers.getFullName());
        statement.setObject(3,workers.getPosition());
        statement.setObject(4,workers.getAddress());
        statement.setObject(5, workers.getPhoneNumber());
        statement.setObject(6,workers.getSalary());
        statement.setObject(7,workers.getPassword());
        statement.execute();
        statement.close();
    }

    public void createDetail(Detail detail) throws SQLException{
        statement = connection.prepareStatement("INSERT INTO Details(Code_detail, Name_of_detail , Quantity, Department_number ) VALUES (?,?,?,?);");
        statement.setObject(1,detail.getCode());
        statement.setObject(2,detail.getTitle());
        statement.setObject(3,detail.getQuantity());
        statement.setObject(4,detail.getDepartmentNumberForDetail());
        statement.execute();
        statement.close();
    }
    public void createAccoplishment( int idWorker, String workWithDetails, String checkOfCompleteWork  , int codeDetail) throws  SQLException{
        statement = connection.prepareStatement("INSERT INTO Accomplishment( ID_worker ,Work_with_details, Check_of_complete_work,Code_detail) VALUES (?,?,?,?);");
        statement.setObject(1,idWorker);
        statement.setObject(2,workWithDetails);
        statement.setObject(3,checkOfCompleteWork);
        statement.setObject(4,codeDetail);
        statement.execute();
        statement.close();
    }

    public void deleteWorker (int id_worker) throws SQLException{
        statement = connection.prepareStatement("Delete from Workers where ID_worker = ?");
        statement.setObject(1, id_worker);
        statement.executeUpdate();
    }

    public void deleteWork(int id_work) throws SQLException{
        statement = connection.prepareStatement("Delete from Accomplishment where ID_work = ?");
        statement.setObject(1,id_work);
        statement.executeUpdate();
    }

    public void deleteDetail(int code) throws SQLException{
        statement = connection.prepareStatement("Delete from Details where Code_detail = ?");
        statement.setObject(1,code);
        statement.executeUpdate();
    }
    public ArrayList<ReportAboutWorks> getReportList(int departmentNumber){
        ArrayList<ReportAboutWorks> ReportList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM Work_in_select_department where Department_number = ? ");
            statement.setObject(1,departmentNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ReportList.add(new ReportAboutWorks (resultSet.getInt("ID_work"),
                        resultSet.getInt("ID_worker"),
                        resultSet.getInt("Code_detail"),
                        resultSet.getString("Full_name"),
                        resultSet.getInt("Department_number"),
                        resultSet.getString("Position"),
                        resultSet.getString("Name_of_detail"),
                        resultSet.getString("Work_with_details"),
                        resultSet.getInt("Quantity"),
                        resultSet.getString("Check_of_complete_work")
                ));
            }

        }catch (Exception e){
            System.out.println(e.getMessage());

        }

        return ReportList;
    }
    public ArrayList<Detail>  getDetailsList(int departmentNumber){
        ArrayList<Detail> allDetailsList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM Details where Department_number = ?");
            statement.setObject(1,departmentNumber);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allDetailsList.add(new Detail (resultSet.getInt("Code_detail"),
                        resultSet.getString("Name_of_detail"),
                        resultSet.getInt("Department_number"),
                        resultSet.getInt("Quantity")
                ));

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return allDetailsList;
    }

    public ArrayList<Workers>  getWorketsList(int departmentNumber ){
        ArrayList<Workers> allWorkersList = new ArrayList<>();
        try{
            statement = connection.prepareStatement("SELECT * FROM Workers where Department_number = ?  ");
            statement.setObject(1,departmentNumber);

            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                allWorkersList.add(new Workers (
                        resultSet.getInt("ID_worker"),
                        resultSet.getInt("Department_number"),
                        resultSet.getString("Full_name"),
                        resultSet.getString("Position"),
                        resultSet.getString("Adress"),
                        resultSet.getString("Phone_number"),
                        resultSet.getInt("Salary"),
                        resultSet.getString("Password")
                ));

            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return allWorkersList;
    }

    public Workers getAuthentacationWorker(int id) {
        Workers workers = null;
        try {
            openDB();
            statement = connection.prepareStatement("select *from Workers where ID_worker = ? ");
            statement.setObject(1, id);
            resultSet = statement.executeQuery();
            workers = new Workers(
                    resultSet.getInt("ID_worker"),
                    resultSet.getInt("Department_number"),
                    resultSet.getString("Full_name"),
                    resultSet.getString("Position"),
                    resultSet.getString("Adress"),
                    resultSet.getString("Phone_number"),
                    resultSet.getInt("Salary"),
                    resultSet.getString("Password")
            );
            closeDB();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return workers;
    }
}





