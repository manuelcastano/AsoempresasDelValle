package entity;

public class Surveys {

    private int id;
    private int satisfactionLevel;
    private long date;
    private int companyID;

    public Surveys() {
    }

    public Surveys(int id, int satisfactionLevel, long date, int companyID) {
        this.id = id;
        this.satisfactionLevel = satisfactionLevel;
        this.date = date;
        this.companyID = companyID;
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