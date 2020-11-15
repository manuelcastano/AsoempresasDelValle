package model.dto;

import java.util.ArrayList;

public class CompaniesDTO {

    private int id;
    private String name;
    private String password;
    private int sectorID;
    private ArrayList<EmployeesDTO> empleados;
    private SectorsDTO sector;
    private ArrayList<SurveysDTO> surveys;
    private ArrayList<PeriodicExpensesDTO> periodics;
    private ArrayList<MarketingExpensesDTO> marketings;
    private ArrayList<IndebtednessDTO> indebtedness;
    private ArrayList<ReportsDTO> reports;

    public CompaniesDTO() {
    }

    public CompaniesDTO(int id, String name, String password, int sectorID, ArrayList<EmployeesDTO> empleados, SectorsDTO sector, ArrayList<SurveysDTO> surveys,
                        ArrayList<PeriodicExpensesDTO> periodics, ArrayList<MarketingExpensesDTO> marketings,
                        ArrayList<IndebtednessDTO> indebtedness, ArrayList<ReportsDTO> reports) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.sectorID = sectorID;
        this.empleados = empleados;
        this.sector = sector;
        this.surveys = surveys;
        this.periodics = periodics;
        this.marketings = marketings;
        this.indebtedness = indebtedness;
        this.reports = reports;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }

    public ArrayList<EmployeesDTO> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<EmployeesDTO> empleados) {
        this.empleados = empleados;
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
