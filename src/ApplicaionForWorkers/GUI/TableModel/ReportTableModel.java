package ApplicaionForWorkers.GUI.TableModel;

import ApplicaionForWorkers.Model.Company;

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
                return d.getFullName();

            case 1:
                return  Integer.toString(d.getDepartmentNumber());

            case 2:
                return  d.getPosition();

            case 3:
                return  d.getNameOfdetail();
            case 4:
                return  d.getWorkWithDetails();
            case 5:
                return Integer.toString(d.getQuantity());

            case 6:
                return  d.getCheckOfCompleteWork();

        }
        return null;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 0:
                company.getReportAboutWorks(rowIndex).setFullName((String) aValue);
                break;
            case 1:
                try {
                    company.getReportAboutWorks(rowIndex).setDepartmentNumber(Integer.parseInt((String) aValue));
                }catch (NumberFormatException e){}
                break;
            case 2:
                try {
                    company.getReportAboutWorks(rowIndex).setPosition((String) aValue);
                }
                catch (NumberFormatException e){}
                break;
            case 3:
                company.getReportAboutWorks(rowIndex).setNameOfdetail((String) aValue);
                break;
            case 4:
                company.getReportAboutWorks(rowIndex).setWorkWithDetails((String) aValue);
                break;
            case 5:
                company.getReportAboutWorks(rowIndex).setQuantity(Integer.parseInt((String) aValue));
                break;
            case 6:
                company.getReportAboutWorks(rowIndex).setCheckOfCompleteWork((String) aValue);
                break;

        }
        fireTableCellUpdated(rowIndex,columnIndex);

    }


    public String getColumnName(int column){
        switch (column){
            case 0: return "ФИО рабочего";
            case 1: return "Номер отдела";
            case 2: return "Должность";
            case 3: return "Название детали";
            case 4: return "Работа с деталью";
            case 5: return "Количество деталей";
            case 6: return "Статус";
        }
        return "";
    }




}
