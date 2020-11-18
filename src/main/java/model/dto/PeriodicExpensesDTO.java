package model.dto;

public class PeriodicExpensesDTO {

    private int id;
    private int value;
    private String date;
    private int companyID;
    private CompaniesDTO companies;

    public PeriodicExpensesDTO() {
    }

    public PeriodicExpensesDTO(int id, int value, String date, int companyID, CompaniesDTO companies) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.companyID = companyID;
        this.companies = companies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }

    public CompaniesDTO getCompanies() {
        return companies;
    }

    public void setCompanies(CompaniesDTO companies) {
        this.companies = companies;
    }
}
