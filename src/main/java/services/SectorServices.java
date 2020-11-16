package services;

import config.Response;
import model.dto.SectorsDTO;
import model.provider.SectorProvider;

import javax.ejb.Stateless;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("sector")
public class SectorServices {

    @POST
    @Produces("application/json")
    @Path("create")
    public Response createSector(SectorsDTO sector){
        SectorProvider sec = new SectorProvider();
        sec.InsertSector(sec.mapFromDTO(sector));

        return new Response("Operacion exitosa");
    }

}
