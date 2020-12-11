package model.dto;

public class ReportsDTO {

    private int id;
    private String start_Date;
    private String purchaseDate;
    private CompaniesDTO companies;

    public ReportsDTO() {
    }

    public ReportsDTO(int id, String start_Date, String purchaseDate, CompaniesDTO companies) {
        this.id = id;
        this.start_Date = start_Date;
        this.purchaseDate = purchaseDate;
        this.companies = companies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(String startDate) {
        this.start_Date = startDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public CompaniesDTO getCompanies() {
        return companies;
    }

    public void setCompanies(CompaniesDTO companies) {
        this.companies = companies;
    }
}
