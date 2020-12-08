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
        ReportProvider reportProvider = new ReportProvider();
        reportProvider.insertReport(reportProvider.map(reportDTO));
        return new Response("Operacion exitosa");
    }

    @GET
    @Path("reportsbycompany")
    @Consumes("application/json")
    @Produces("application/json")
    public ArrayList<ReportsDTO> getAllReportsByCompany(int id){
        ReportProvider provider = new ReportProvider();
        ArrayList<ReportsDTO> reportsDTOS = provider.getAllReportsByCompany(id);
        return reportsDTOS;
    }
}
