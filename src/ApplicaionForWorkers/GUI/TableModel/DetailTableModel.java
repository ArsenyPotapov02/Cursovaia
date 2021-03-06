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
                return  Integer.toString(d.getDepartmentNumberForDetail());

            case 3:
                return  Integer.toString(d.getQuantity());


        }
        return null;
    }
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 0:try {
                company.getDetail(rowIndex).setCode(Integer.parseInt((String) aValue));
            } catch (NumberFormatException e){}
                break;
            case 1:
                company.getDetail(rowIndex).setTitle((String) aValue);
                break;
            case 2:
                try{
                    company.getDetail(rowIndex).setDepartmentNumberForDetail(Integer.parseInt((String) aValue));
                }
                catch (NumberFormatException e){}
                break;
            case 3:
                try {
                    company.getDetail(rowIndex).setQuantity(Integer.parseInt((String) aValue));
                }catch (NumberFormatException e){}
                break;
        }
        fireTableCellUpdated(rowIndex,columnIndex);

    }


    public String getColumnName(int column){
        switch (column){
            case 0: return "?????? ????????????";
            case 1: return "???????????????? ????????????";
            case 2: return "?????????? ????????????";
            case 3: return "????????????????????";
        }
        return "";
    }

}
