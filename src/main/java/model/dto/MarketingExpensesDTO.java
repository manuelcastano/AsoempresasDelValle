package model.dto;

public class MarketingExpensesDTO {

    private int id;
    private int value;
    private String date;
    private CompaniesDTO companies;


    public MarketingExpensesDTO() {
    }

    public MarketingExpensesDTO(int id, int value, String date, CompaniesDTO companies) {
        this.id = id;
        this.value = value;
        this.date = date;
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

    public CompaniesDTO getCompanies() {
        return companies;
    }

    public void setCompanies(CompaniesDTO companies) {
        this.companies = companies;
    }
}
