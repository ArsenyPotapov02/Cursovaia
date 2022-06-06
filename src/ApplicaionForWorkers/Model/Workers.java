package ApplicaionForWorkers.Model;

public class Workers {
    private String fullName;
    private String position;

    private String password;
    private String address;
    private String phoneNumber;
    private int salary;
    private int departmentNumber;
    private int idWorker;

    public Workers(int idWorker,int departmentNumber, String fullName, String position, String address, String phoneNumber, int salary, String password){
        this.idWorker = idWorker;
        this.departmentNumber = departmentNumber;
        this.fullName = fullName;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.password = password;

    }
    public Workers(int departmentNumber, String fullName, String position, String address, String phoneNumber, int salary, String password){
        this.departmentNumber = departmentNumber;
        this.fullName = fullName;
        this.position = position;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
    public int getid(){
        return idWorker;
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

    public void setDepartmentNumber(int departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getIdWorker() {
        return idWorker;
    }

    public void setIdWorker(int idWorker) {
        this.idWorker = idWorker;
    }
}
