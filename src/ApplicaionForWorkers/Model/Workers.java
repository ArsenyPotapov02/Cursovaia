package ApplicaionForWorkers.Model;

public class Workers {
    private String fullName;
    private String position;
    private String education;
    private String address;
    private String phoneNumber;
    private int salary;

    public Workers(String fullName, String position, String education, String address, String phoneNumber, int salary){
        this.fullName = fullName;
        this.position = position;
        this.education = education;
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

    public String getEducation() {
        return education;
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
