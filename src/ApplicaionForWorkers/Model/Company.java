package ApplicaionForWorkers.Model;

import java.util.ArrayList;

public class Company {
    private ArrayList<Detail> AllDetailsList = new ArrayList<>();
    private ArrayList<Workers> workersList = new ArrayList<>();
    private ArrayList<ReportAboutWorks> reportList =new ArrayList<>();
    private Workers workers;

    private String position;
    private int departmentNumber;


    public  void setWorkersList(ArrayList<Workers> list){
        workersList = list;
    };
    public void setDetailList(ArrayList<Detail> list){
        this.AllDetailsList = list;
    };
    public void setReportList(ArrayList<ReportAboutWorks> list){
        this.reportList = list;

    };


    public int  getDetailListSize(){
        return AllDetailsList.size();
    }
    public int  getReportListSize(){
        return reportList.size();
    }
    public ReportAboutWorks getReportAboutWorks(int index){return reportList.get(index); }

    public int getWorkersListSize(){
        return workersList.size();
    }

    public Workers getWorker(int index){
        return workersList.get(index);
    }


    public Detail getDetail(int index){
        return this.AllDetailsList.get(index);
    }
    public Workers getIdWorker(int id){
        Workers workers = null;
        for (int i = 0; i < workersList.size(); i++) {
            if(workersList.get(i).getid() == id){
                workers = workersList.get(i);
            }
        }
        return workers;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Workers getWorkers() {
        return workers;
    }

    public String getPosition() {
        return position;
    }

    public int getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public ArrayList<Detail> getAllDetailsList(){
        return AllDetailsList;
    }
    public ArrayList<ReportAboutWorks> getReportList(){
        return reportList;
    }


    public void addDetail(Detail detail){
        this.AllDetailsList.add(detail);
    }

    public void addWorker(Workers workers){
        this.workersList.add(workers);
    }

    public void deleteWorker(int index){
        this.workersList.remove(index);
    }

    public void deleteDetail(int index){
        this.AllDetailsList.remove(index);
    }
    public  void  deleteWork (int index){this.reportList.remove(index);}

}
