package ApplicaionForWorkers.Model;

public class Workers {

    private int id;
    private String fullName;
    private String position;
    private String education;
    private String address;
    private String phoneNumber;
    private int salary;

    public Workers(int id, String fullName, String position, String education, String address, String phoneNumber, int salary){
        this.id = id;
        this.fullName = fullName;
        this.position = position;
        this.education = education;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }
}
