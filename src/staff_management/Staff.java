package staff_management;

public class Staff {
    private String name;
    private boolean type;
    private boolean status;
    private double salary;

    public Staff() {
    }

    public Staff(String name, boolean type, boolean status, double salary) {
        this.name = name;
        this.type = type;
        this.status = status;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getType(){
        if (isType()){
            return "Fulltime";
        } return "Parttime";
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String geStatus(){
        if (isStatus()){
            return "Đang làm";
        } return "Thôi việc";
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Staff {"
                + name + ", "
                + getType() + ", "
                + geStatus() + ", "
                + salary +
                '}';
    }
}
