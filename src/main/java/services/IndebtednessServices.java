package services;

import config.Response;
import model.dto.IndebtednessDTO;
import model.dto.MarketingExpensesDTO;
import model.provider.CompaniesProvider;
import model.provider.IndebtednessProvider;
import model.provider.MarketingExpensesProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;

@Stateless
@Path("Ine")
public class IndebtednessServices {
    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createIndebtedness(IndebtednessDTO marke){
        IndebtednessProvider provider = new IndebtednessProvider();
        if(provider.createIndebtedness(provider.mapFromDTO(marke))){
            return new Response("Operacion exitosa");
        }else{
            return new Response("No hay ninguna compañia");
        }
    }

    @DELETE
    @Path("delete/{id}")
    public Response delateMarketingExpenses(@PathParam("id") String id){
        IndebtednessProvider provider = new IndebtednessProvider();
        provider.delateIndebtednessProvider(Integer.parseInt(id));
        return new Response("Operacion Exitosa");
    }

    @PUT
    @Path("{id}")
    public Response updateMarketingExpenses(@PathParam("id") String id, IndebtednessDTO ine){
        IndebtednessProvider provider = new IndebtednessProvider();
        if(provider.updateIndebtedness(Integer.parseInt(id),provider.mapFromDTO(ine))){
            return new Response("Operacion exitosa" + "xsadsad");
        }else{
            return new Response("No se pudo hacer");
        }

    }

}
