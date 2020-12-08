package entity;

public class Report {

    private int ID;
    private long startDate;
    private long purchase;
    private int companyID;

    public Report(){

    }

    public Report(int ID, long startDate, long purchase, int companyID) {
        this.ID = ID;
        this.startDate = startDate;
        this.purchase = purchase;
        this.companyID = companyID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public long getPurchase() {
        return purchase;
    }

    public void setPurchase(long purchase) {
        this.purchase = purchase;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
