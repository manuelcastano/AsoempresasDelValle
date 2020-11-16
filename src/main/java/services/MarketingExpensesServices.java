package services;

import config.Response;
import model.dto.MarketingExpensesDTO;

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

        return new Response("Operacion exitosa");
    }

}
