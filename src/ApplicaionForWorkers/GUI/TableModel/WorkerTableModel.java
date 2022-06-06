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
                str = Integer.toString(w.getIdWorker());
                break;
            case 1:
                str = Integer.toString(w.getDepartmentNumber());
                break;
            case 2:
                str = w.getFullName();
                break;
            case 3:
                str = w.getPosition();
                break;
            case 4:
                str = w.getAddress();
                break;
            case 5:
                str = w.getPhoneNumber();
                break;
            case 6:
                str = Integer.toString(w.getSalary());
                break;
        }
        return str;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 0:
                try {
                company.getWorker(rowIndex).setDepartmentNumber(Integer.parseInt((String) aValue));
            } catch (NumberFormatException e){}
                break;
            case 1:
                company.getWorker(rowIndex).setFullName((String) aValue);
                break;
            case 2:
                company.getWorker(rowIndex).setPosition((String) aValue);
                break;
            case 3:
                company.getWorker(rowIndex).setAddress((String) aValue);
                break;
            case 4:
                company.getWorker(rowIndex).setPhoneNumber((String) aValue);
                break;
            case 5:
                try {
                    company.getWorker(rowIndex).setSalary(Integer.parseInt((String) aValue));
                } catch (NumberFormatException e){}
                break;
        }

    }


    public String getColumnName(int column){
        switch (column){
            case 0: return "ID работника";
            case 1: return "Номер отдела";
            case 2: return "ФИО работника";
            case 3: return "Должность";
            case 4: return "Адрес";
            case 5: return "Номер телефона";
            case 6: return "Зарплата";
        }
        return "";
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

}
