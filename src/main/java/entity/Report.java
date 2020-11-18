package entity;

public class Report {

    private int ID;
    private String startDate;
    private String purchase;
    private int companyID;

    public Report(){

    }

    public Report(int ID, String startDate, String purchase, int companyID) {
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getPurchase() {
        return purchase;
    }

    public void setPurchase(String purchase) {
        this.purchase = purchase;
    }

    public int getCompanyID() {
        return companyID;
    }

    public void setCompanyID(int companyID) {
        this.companyID = companyID;
    }
}
