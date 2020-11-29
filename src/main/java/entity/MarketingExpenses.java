package entity;

public class MarketingExpenses {

    private int id;
    private int value;
    private long date;
    private int companyID;

    public MarketingExpenses() {
    }

    public MarketingExpenses(int id, int value, long date, int companyID) {
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

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
