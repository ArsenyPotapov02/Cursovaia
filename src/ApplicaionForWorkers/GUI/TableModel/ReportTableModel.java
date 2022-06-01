package ApplicaionForWorkers.GUI.TableModel;

import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.Model.ReportAboutWorks;
import ApplicaionForWorkers.utility.Constant;

import javax.swing.table.AbstractTableModel;


public class ReportTableModel extends AbstractTableModel {
    private Company company;

    public ReportTableModel (Company company){
        this.company = company;
    }
    @Override
    public int getRowCount() {
        return company.getReportListSize();
    }

    @Override
    public int getColumnCount() {
        return Constant.REPORT_COL_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ReportAboutWorks d = company.getReportList().get(rowIndex);
        switch (columnIndex){
            case 0:
                return Integer.toString(d.getiDWork());

            case 1:
                return  d.getFullName();

            case 2:
                return  Integer.toString(d.getDepartmentNumber());

            case 3:
                return  d.getPosition();
            case 4:
                return  d.getNameOfdetail();
            case 5:
                return  d.getWorkWithDetails();
            case 6:
                return  Integer.toString(d.getQuantity());
            case 7:
                return  d.getDateOfCompleteWork();



        }
        return null;
    }

    public String getColumnName(int column){
        switch (column){
            case 0: return "ФИО рабочего";
            case 1: return "Номер отдела";
            case 2: return "Должность";
            case 3: return "Название детали";
            case 4: return "Работа с деталью";
            case 5: return "Количество деталей";
            case 6: return "Дата выполнения";
        }
        return "";
    }
}
