package ApplicaionForWorkers.GUI.TableModel;

import ApplicaionForWorkers.Model.Company;
import ApplicaionForWorkers.Model.Detail;
import ApplicaionForWorkers.utility.Constant;

import javax.swing.table.AbstractTableModel;

public class DetailTableModel extends AbstractTableModel {
    private Company company;

    public DetailTableModel(Company company){
        this.company = company;
    }

    @Override
    public int getRowCount() {
        return company.getDetailListSize();
    }

    @Override
    public int getColumnCount() {
        return Constant.DETAIL_COL_COUNT;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Detail d = company.getAllDetailsList().get(rowIndex);
        switch (columnIndex){
            case 0:
                return Integer.toString(d.getCode());

            case 1:
                return  d.getTitle();

            case 2:
                return  Integer.toString(d.getDepartmentNumber());

            case 3:
                return  Integer.toString(d.getQuantity());


        }
        return null;
    }

    public String getColumnName(int column){
        switch (column){
            case 0: return "Код детали";
            case 1: return "Название детали";
            case 2: return "Номер отдела";
            case 3: return "Количество";
        }
        return "";
    }
}
