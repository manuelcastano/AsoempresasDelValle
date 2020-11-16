package services;


import config.Response;
import model.dto.CompaniesDTO;
import model.provider.CompaniesProvider;

import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Stateless
@Path("cs")
public class CompaniesServices {

    @POST
    @Consumes("application/json")
    @Path("create")
    public Response createCompanie(CompaniesDTO company) {

        CompaniesProvider companyProvider = new CompaniesProvider();

        if(companyProvider.InsertCompanies(companyProvider.mapFromDTO(company))){
            return new Response("Operacion exitosa");
        }else{
            return new Response("No se encontro el sector existente");
        }

    }

}
