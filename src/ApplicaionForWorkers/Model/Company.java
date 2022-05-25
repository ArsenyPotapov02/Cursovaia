package ApplicaionForWorkers.Model;

import java.util.ArrayList;

public class Company {
    private ArrayList<Detail> detailList = new ArrayList<>();
    private ArrayList<Workers> workersList = new ArrayList<>();

    public int getDetailListSize(){
        return detailList.size();
    }

    public int getWorkersListSize(){
        return workersList.size();
    }

    public Workers getWorker(int index){
        return workersList.get(index);
    }

    public Detail getDetail(int index){
        return detailList.get(index);
    }

}
