package services;

import config.Response;
import entity.MarketingExpenses;
import model.dto.MarketingExpensesDTO;
import model.provider.MarketingExpensesProvider;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("mes")
public class MarketingExpensesServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createMarketingExpenses(MarketingExpensesDTO marke){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();

        if(provider.createMarketingExtenses(provider.mapFromDTO(marke))){
            return new Response("Operacion exitosa");
        }else{
            return new Response("No hay ninguna compañia");
        }


    }



}
