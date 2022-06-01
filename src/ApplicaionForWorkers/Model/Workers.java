package ApplicaionForWorkers.Model;

public class Workers {
    private String fullName;
    private String position;

    private String address;
    private String phoneNumber;
    private int salary;
    private int departmentNumber;

    public Workers(int departmentNumber, String fullName, String position, String address, String phoneNumber, int salary){
        this.departmentNumber = departmentNumber;
        this.fullName = fullName;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public String getAddress() {
        return address;
    }

    public int getDepartmentNumber(){
        return departmentNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }
}
