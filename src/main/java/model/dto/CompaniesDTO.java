package model.dto;

import java.util.ArrayList;

public class CompaniesDTO {

    private int id;
    private String name;
    private int sectorID;
    private SectorsDTO sector;
    private ArrayList<SurveysDTO> surveys;
    private ArrayList<PeriodicExpensesDTO> periodics;
    private ArrayList<MarketingExpensesDTO> marketings;
    private ArrayList<IndebtednessDTO> indebtedness;
    private ArrayList<ReportsDTO> reports;

    public CompaniesDTO() {
    }

    public CompaniesDTO(int id, String name,  int sectorID, SectorsDTO sector, ArrayList<SurveysDTO> surveys,
                        ArrayList<PeriodicExpensesDTO> periodics, ArrayList<MarketingExpensesDTO> marketings,
                        ArrayList<IndebtednessDTO> indebtedness, ArrayList<ReportsDTO> reports) {
        this.id = id;
        this.name = name;
        this.sectorID = sectorID;
        this.sector = sector;
        this.surveys = surveys;
        this.periodics = periodics;
        this.marketings = marketings;
        this.indebtedness = indebtedness;
        this.reports = reports;
    }
    public CompaniesDTO(int id, String name, int sectorID) {
        this.id = id;
        this.name = name;
        this.sectorID = sectorID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }


    public SectorsDTO getSector() {
        return sector;
    }

    public void setSector(SectorsDTO sector) {
        this.sector = sector;
    }

    public ArrayList<SurveysDTO> getSurveys() {
        return surveys;
    }

    public void setSurveys(ArrayList<SurveysDTO> surveys) {
        this.surveys = surveys;
    }

    public ArrayList<PeriodicExpensesDTO> getPeriodics() {
        return periodics;
    }

    public void setPeriodics(ArrayList<PeriodicExpensesDTO> periodics) {
        this.periodics = periodics;
    }

    public ArrayList<MarketingExpensesDTO> getMarketings() {
        return marketings;
    }

    public void setMarketings(ArrayList<MarketingExpensesDTO> marketings) {
        this.marketings = marketings;
    }

    public ArrayList<IndebtednessDTO> getIndebtedness() {
        return indebtedness;
    }

    public void setIndebtedness(ArrayList<IndebtednessDTO> indebtedness) {
        this.indebtedness = indebtedness;
    }

    public ArrayList<ReportsDTO> getReports() {
        return reports;
    }

    public void setReports(ArrayList<ReportsDTO> reports) {
        this.reports = reports;
    }
}
