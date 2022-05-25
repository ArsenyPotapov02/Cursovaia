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
        String str = "";
        Detail d = company.getDetail(rowIndex);
        switch (columnIndex){
            case 0:
                str = Integer.toString(d.getCode());
                break;
            case 1:
                str = d.getTitle();
                break;
            case 2:
                str = Integer.toString(d.getQuantity());
                break;

        }
        return str;
    }

    public String getColumnName(int column){
        switch (column){
            case 0: return "Код детали";
            case 1: return "Название детали";
            case 2: return "Количество";
        }
        return "";
    }
}
