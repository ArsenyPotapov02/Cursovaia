package ApplicaionForWorkers.GUI.TableModel;

import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.Workers;
import ApplicaionForWorkers.utility.Constant;

import javax.swing.table.AbstractTableModel;

public class WorkerTableModel extends AbstractTableModel {
    private Company company;

    public WorkerTableModel(Company company){
        this.company = company;
    }
    @Override
    public int getRowCount() {
        return company.getWorkersListSize();
    }

    @Override
    public int getColumnCount() {
        return Constant.WORKER_COL_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String str = "";
        Workers w = company.getWorker(rowIndex);
        switch (columnIndex){
            case 0:
                str = w.getFullName();
                break;
            case 1:
                str = w.getPosition();
                break;
            case 2:
                str = w.getEducation();
                break;
            case 3:
                str = w.getAddress();
                break;
            case 4:
                str = w.getPhoneNumber();
                break;
            case 5:
                str = Integer.toString(w.getSalary());
                break;
        }
        return str;
    }

    public String getColumnName(int column){
        switch (column){
            case 0: return "Имя рабочего";
            case 1: return "Тип профессии";
            case 2: return "Тип образования";
            case 3: return "Адресс";
            case 4: return "Номер телефона";
            case 5: return "Зарплата";
        }
        return "";
    }

}
