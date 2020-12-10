package services;

import model.dto.Response;
import model.dto.MarketingExpensesDTO;
import model.provider.CompaniesProvider;
import model.provider.MarketingExpensesProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("mes")
public class MarketingExpensesServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createMarketingExpenses(MarketingExpensesDTO marke){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();
        CompaniesProvider compa = new CompaniesProvider();
        if(provider.createMarketingExtenses(provider.mapFromDTO(marke))){
            return new Response("Operacion exitosa");
        }else{
            return new Response("No hay ninguna compañia");
        }


    }

    @DELETE
    @Path("delete/{id}")
    public Response delateMarketingExpenses(@PathParam("id") String id){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();
        provider.delateMarketingExtenses(Integer.parseInt(id));
        return new Response("Operacion Exitosa");
    }

    @PUT
    @Path("{id}")
    public Response updateMarketingExpenses(@PathParam("id") String id, MarketingExpensesDTO marke){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();
        if(provider.updateMarketingExtenses(Integer.parseInt(id),provider.mapFromDTO(marke))){
            return new Response("Operacion exitosa" + "xsadsad");
        }else{
            return new Response("No se pudo hacer");
        }

    }




}
