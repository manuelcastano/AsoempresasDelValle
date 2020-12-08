package model.dto;

public class ReportsDTO {

    private int id;
    private String startDate;
    private String purchaseDate;
    private CompaniesDTO companies;

    public ReportsDTO() {
    }

    public ReportsDTO(int id, String startDate, String purchaseDate, CompaniesDTO companies) {
        this.id = id;
        this.startDate = startDate;
        this.purchaseDate = purchaseDate;
        this.companies = companies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
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
