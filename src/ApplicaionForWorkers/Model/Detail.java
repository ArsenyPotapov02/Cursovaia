package ApplicaionForWorkers.Model;

public class Detail {
    private int code;
    private String title;
    private int quantity;
    private int departmentNumberForDetail;

    public Detail(int code, String title, int departmentNumberForDetail, int quantity){
        this.code = code;
        this.title = title;
        this.departmentNumberForDetail = departmentNumberForDetail;
        this.quantity =quantity;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
    public int getDepartmentNumber(){return departmentNumberForDetail;}

    public int getQuantity() {
        return quantity;
    }
}
