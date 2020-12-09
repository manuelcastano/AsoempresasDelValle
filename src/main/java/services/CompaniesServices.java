package services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import entity.Companies;
import model.dto.CompaniesDTO;
import model.provider.CompaniesProvider;
import model.provider.ReportProvider;

import java.util.ArrayList;


@Path("company")
@Stateless
public class CompaniesServices {

    @GET
    @Path("best/{initialDate}/{finalDate}")
    @Produces("application/json")
    public CompaniesDTO bestCompany(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        long initial = Long.parseLong(iDate);
        long finalDate = Long.parseLong(fDate);
        CompaniesProvider provider = new CompaniesProvider();
        return provider.getBest(initial,finalDate);
    }

    @GET
    @Path("best/{initialDate}/{finalDate}")
    @Produces("application/json")
    public CompaniesDTO worstCompany(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        long initial = Long.parseLong(iDate);
        long finalDate = Long.parseLong(fDate);
        CompaniesProvider provider = new CompaniesProvider();
        return provider.getWorst(initial,finalDate);
    }

    @GET
    @Path("best/{initialDate}/{finalDate}")
    @Produces("application/json")
    public CompaniesDTO averageCompany(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        long initial = Long.parseLong(iDate);
        long finalDate = Long.parseLong(fDate);
        CompaniesProvider provider = new CompaniesProvider();
        return provider.getAverage(initial,finalDate);
    }

    @GET
    @Path("getallcompanies")
    @Produces("application/json")
    public ArrayList<CompaniesDTO> getAllCompanies(){

        CompaniesProvider compProvider = new CompaniesProvider();
        ArrayList<Companies> companies = compProvider.getAllCompanies();

        ArrayList<CompaniesDTO> dto = new ArrayList<CompaniesDTO>();


        for (Companies comp: companies) {

            dto.add(compProvider.getCompanyByID(comp.getId()));
        }

        return dto;
    }

    @GET
    @Path("getCompany/{id}")
    @Produces("application/json")
    public CompaniesDTO getCompanyById(@PathParam("id") String id){

        CompaniesProvider compProvider = new CompaniesProvider();
        ReportProvider reportProvider = new ReportProvider();

        CompaniesDTO comp = compProvider.getCompanyByID(Integer.parseInt(id));

        comp.setReports(reportProvider.getAllReportsByCompany(Integer.parseInt(id)));

        return comp;
    }

}
