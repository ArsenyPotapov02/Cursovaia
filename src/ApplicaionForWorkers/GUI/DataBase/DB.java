package ApplicaionForWorkers.GUI.DataBase;

import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.ReportAboutWorks;
import ApplicaionForWorkers.Model.Workers;

import java.util.ArrayList;

public class DB extends SqliteHelper{
    private ArrayList<Detail> allDetailsList  = new ArrayList<>();
    private ArrayList<Workers> allWorkersList = new ArrayList<>();
    private ArrayList<ReportAboutWorks> ReportList = new ArrayList<>();

}
