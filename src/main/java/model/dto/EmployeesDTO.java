package model.dto;

public class EmployeesDTO {

    private int id;
    private String userName;
    private String password;
    private CompaniesDTO company;

    public EmployeesDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CompaniesDTO getCompany() {
        return company;
    }

    public void setCompany(CompaniesDTO company) {
        this.company = company;
    }
}
