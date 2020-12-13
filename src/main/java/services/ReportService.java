package services;


import model.dto.ReportsDTO;
import model.dto.*;
import model.provider.ReportProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import java.util.ArrayList;

@Path("report")
@Stateless
public class ReportService {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createReport(ReportsDTO reportDTO){
        Response result = new Response("Operacion Fallida");
        ReportProvider reportProvider = new ReportProvider();
        if(reportProvider.insertReport(reportProvider.map(reportDTO))){
            result.setMessage("Operacion Exitosa");
        }
        return result;
    }

    @GET
    @Path("reportsbycompany/{id}")
    @Produces("application/json")
    public ArrayList<ReportsDTO> getAllReportsByCompany(@PathParam("id") String id){
        int a = Integer.parseInt(id);
        ReportProvider provider = new ReportProvider();
        ArrayList<ReportsDTO> reportsDTOS = provider.getAllReportsByCompany(a);
        return reportsDTOS;
    }
}
