package services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


import model.dto.CompaniesDTO;
import model.provider.CompaniesProvider;


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



}
