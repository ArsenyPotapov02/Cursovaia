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
    private Date dateOfCompleteWork;

    private String workWithDetails;

        public ReportAboutWorks( int iDWorker, int codeDetail,String fullName, int departmentNumber, String position, String nameOfdetail, String workWithDetails, int quantity, Date dateOfCompleteWork){
            this.codeDetail = codeDetail;
            this.iDWorker = iDWorker;
            this.fullName = fullName;
            this.departmentNumber = departmentNumber;
            this.position = position;
            this.nameOfdetail = nameOfdetail;
            this.workWithDetails = workWithDetails;
            this.quantity = quantity;
            this.dateOfCompleteWork = dateOfCompleteWork;
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

    public Date getDateOfCompleteWork() {
        return dateOfCompleteWork;
    }
}
