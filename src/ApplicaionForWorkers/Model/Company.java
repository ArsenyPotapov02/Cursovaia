package ApplicaionForWorkers.Model;

import java.util.ArrayList;

public class Company {
    private ArrayList<Detail> AllDetailsList = new ArrayList<>();
    private ArrayList<Workers> workersList = new ArrayList<>();
    private ArrayList<ReportAboutWorks> reportList =new ArrayList<>();

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

    public int getWorkersListSize(){
        return workersList.size();
    }

    public Workers getWorker(int index){
        return workersList.get(index);
    }


    public Detail getDetail(int index){
        System.out.println(this.AllDetailsList);
        return this.AllDetailsList.get(index);
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

}
