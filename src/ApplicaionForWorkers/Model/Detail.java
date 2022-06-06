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
        this.quantity = quantity;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }
    public int getDepartmentNumberForDetail(){return departmentNumberForDetail;}

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDepartmentNumberForDetail(int departmentNumberForDetail) {
        this.departmentNumberForDetail = departmentNumberForDetail;
    }
}
