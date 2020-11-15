package model.dto;

import java.util.ArrayList;

public class SectorsDTO {

    private int id;
    private String name;
    private ArrayList<CompaniesDTO> companies;

    public SectorsDTO() {
    }

    public SectorsDTO(int id, String name, ArrayList<CompaniesDTO> companies) {

        this.id = id;
        this.name = name;
        this.companies = companies;
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

    public ArrayList<CompaniesDTO> getCompanies() {
        return companies;
    }

    public void setCompanies(ArrayList<CompaniesDTO> companies) {
        this.companies = companies;
    }
}
