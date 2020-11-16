package entity;

public class MarketingExpenses {

    private int id;
    private int value;
    private String date;
    private int companyID;

    public MarketingExpenses() {
    }

    public MarketingExpenses(int id, int value, String date, int companyID) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.companyID = companyID;
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
}
