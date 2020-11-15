package model.dto;

public class SurveysDTO {

    private int id;
    private int satisfactionLevel;
    private String date;
    private int companyID;
    private CompaniesDTO company;

    public SurveysDTO() {
    }

    public SurveysDTO(int id, int satisfactionLevel, String date, int companyID, CompaniesDTO company) {
        this.id = id;
        this.satisfactionLevel = satisfactionLevel;
        this.date = date;
        this.companyID = companyID;
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSatisfactionLevel() {
        return satisfactionLevel;
    }

    public void setSatisfactionLevel(int satisfactionLevel) {
        this.satisfactionLevel = satisfactionLevel;
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

    public CompaniesDTO getCompany() {
        return company;
    }

    public void setCompany(CompaniesDTO company) {
        this.company = company;
    }
}
