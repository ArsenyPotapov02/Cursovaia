package ApplicaionForWorkers.Model;

import java.util.Date;

public class ReportAboutWorks {
    private int iDWork;
    private String fullName;
    private int departmentNumber;
    private String position;
    private String nameOfdetail;
    private int quantity;
    private int iDWorker;
    private int codeDetail;
    private String checkOfCompleteWork;

    private String workWithDetails;

        public ReportAboutWorks( int iDWork, int iDWorker, int codeDetail, String fullName, int departmentNumber, String position, String nameOfdetail, String workWithDetails, int quantity, String checkOfCompleteWork){

            this.iDWork = iDWork;
            this.iDWorker = iDWorker;
            this.fullName = fullName;
            this.departmentNumber = departmentNumber;
            this.position = position;
            this.codeDetail = codeDetail;
            this.nameOfdetail = nameOfdetail;
            this.workWithDetails = workWithDetails;
            this.quantity = quantity;
            this.checkOfCompleteWork = checkOfCompleteWork;
        }


    public int getCodeDetail() {
        return codeDetail;
    }

    public int getiDWorker() {
        return iDWorker;
    }

    public int getiDWork() {
        return iDWork;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public String getPosition() {
        return position;
    }

    public String getNameOfdetail() {
        return nameOfdetail;
    }

    public String getWorkWithDetails() {
        return workWithDetails;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCheckOfCompleteWork() {
        return checkOfCompleteWork;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setCheckOfCompleteWork(String checkOfCompleteWork) {
        this.checkOfCompleteWork = checkOfCompleteWork;
    }

    public void setCodeDetail(int codeDetail) {
        this.codeDetail = codeDetail;
    }

    public void setNameOfdetail(String nameOfdetail) {
        this.nameOfdetail = nameOfdetail;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setiDWork(int iDWork) {
        this.iDWork = iDWork;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setiDWorker(int iDWorker) {
        this.iDWorker = iDWorker;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWorkWithDetails(String workWithDetails) {
        this.workWithDetails = workWithDetails;
    }
}
