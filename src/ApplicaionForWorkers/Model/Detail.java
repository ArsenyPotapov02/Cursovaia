package ApplicaionForWorkers.Model;

public class Detail {
    private int code;
    private String title;
    private int quantity;

    public Detail(int code, String title, int quantity){
        this.code = code;
        this.title = title;
        this.quantity =quantity;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }
}
