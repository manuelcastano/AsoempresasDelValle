package services;

import javax.ejb.Stateless;
import javax.ws.rs.*;


import entity.*;
import model.dto.CompaniesDTO;
import model.dto.PeriodicExpensesDTO;
import model.dto.Response;
import model.provider.CompaniesProvider;
import model.provider.PeriodicExpensesProvider;
import model.provider.ReportProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@Path("company")
@Stateless
public class CompaniesServices {

    //Modificar para hacerlo con respecto al sector
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

    //Modificar para hacerlo con respecto al sector
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

    //Modificar para hacerlo con respecto al sector
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
    @Produces("application/json")
    @Path("getallcompanies")
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

    @GET
    @Path("bestMarketing/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<MarketingExpenses> bestMarketing(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<MarketingExpenses> aux = null;
        try {
            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = null;
            date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();
            aux = provider.getBestMarketingExpenses(initial,finalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return aux;
    }


    @GET
    @Path("worstMarketing/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<MarketingExpenses> worstMarketing(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<MarketingExpenses> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getWorstMarketingExpenses(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }


    @GET
    @Path("averageMarketing/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<MarketingExpenses> AverageMarketing(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<MarketingExpenses> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getAverageMarketingExpenses(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }


    @GET
    @Path("bestIndebtedness/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<Indebtedness> bestIndebtedness(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<Indebtedness> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getBestIndebtedness(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }

    @GET
    @Path("worstIndebtedness/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<Indebtedness> worstIndebtedness(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<Indebtedness> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getWorstIndebtedness(
                    initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }

    @GET
    @Path("AverageIndebtedness/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<Indebtedness> averageIndebtedness(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<Indebtedness> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getAverageIndebtedness(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }


    @GET
    @Path("bestPreriodicExpenses/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<PeriodicExpenses> bestPreriodicExpenses(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<PeriodicExpenses> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getBestPeriodicExpenses(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }

    @GET
    @Path("worstPreriodicExpenses/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<PeriodicExpenses> worstPeriodicExpenses(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<PeriodicExpenses> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getWorstPeriodicExpenses(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }

    @GET
    @Path("AveragePeriodicExpenses/{initialDate}/{finalDate}")
    @Produces("application/json")
    public ArrayList<PeriodicExpenses> averageIPeriodicExpenses(@PathParam("initialDate") String iDate, @PathParam("finalDate") String fDate){
        CompaniesProvider provider = new CompaniesProvider();
        ArrayList<PeriodicExpenses> aux = null;
        try{

            String fecha1 = iDate;
            String fecha2 = fDate;
            SimpleDateFormat f = new SimpleDateFormat("MM-dd-yyyy");
            Date date1 = (Date)f.parse(fecha1);
            Date date2 = (Date)f.parse(fecha2);
            long initial = date1.getTime();
            long finalDate = date2.getTime();

            aux = provider.getAveragePeriodicExpenses(initial,finalDate);

        }catch (ParseException e){

        }
        return aux;
    }

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createCompany(CompaniesDTO dto){
        CompaniesProvider provider = new CompaniesProvider();
        boolean could = provider.InsertCompanies(provider.mapFromDTO(dto));
        if(could){
            return new Response("Operacion exitosa");
        }else{
            return new Response("Operacion fallida");
        }
    }

}
