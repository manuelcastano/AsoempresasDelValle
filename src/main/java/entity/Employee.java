package entity;

public class Employee {

    private int ID;
    private String user;
    private String password;


    public Employee(){

    }

    public Employee(int ID, String user, String password, int companyID) {
        this.ID = ID;
        this.user = user;
        this.password = password;

    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setID(int ID) {
        this.ID = ID;
    }
}
