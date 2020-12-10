package services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import entity.Companies;
import entity.Surveys;
import model.dto.CompaniesDTO;
import model.provider.CompaniesProvider;
import model.provider.ReportProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Path("company")
@Stateless
public class CompaniesServices {

    @GET
    @Path("best/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<Surveys> bestCompany(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<Surveys> aux = null;
        try{
            String fech1 = iDate;
            String fech2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fech1);
            Date date2 = (Date)f.parse(fech2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();
            aux = provider.getBest(initial,finalDate);

        }catch (ParseException e){
            e.printStackTrace();
        }
        return aux;
    }

    @GET
    @Path("worst/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<Surveys> worstCompany(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<Surveys> aux = null;
        try{
            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getWorst(initial,finalDate);

        }catch (ParseException e){
            e.printStackTrace();
        }
        return aux;
    }

    @GET
    @Path("average/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<Surveys> averageCompany(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<Surveys> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getAverage(initial,finalDate);

        }catch (ParseException e){

        }

        return aux;
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
