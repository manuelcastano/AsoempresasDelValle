package services;

import model.dto.EmployeesDTO;
import model.dto.Response;
import model.provider.EmployeeProvider;

import javax.ejb.Stateless;
import javax.ws.rs.*;


@Path("employee")
@Stateless
public class EmployeeService {

    @POST
    @Path("create")
    @Consumes("application/json")
    @Produces("application/json")
    public Response createEmployee(EmployeesDTO employeeDTO){
        EmployeeProvider employeeProvider = new EmployeeProvider();
        employeeProvider.insertEmployee(employeeProvider.map(employeeDTO));
        return new Response("Operacion exitosa");
    }

    @DELETE
    @Path("delete/{id}")
    @Produces("application/json")
    public Response deleteEmoloyee(@PathParam("id")String id){
        EmployeeProvider employeeProvider = new EmployeeProvider();
        employeeProvider.removeEmployee(Integer.parseInt(id));
        return new Response("Operacion exitosa");
    }


    @POST
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public Response login(EmployeesDTO employeesDTO){
        Response response = new Response("Operacion fallo");
        EmployeeProvider employeeProvider = new EmployeeProvider();


        if(employeeProvider.login(employeesDTO.getUser(), employeesDTO.getPassword())){
            response.setMessage("Operacion exitosa");
        }
        return response;
    }


    @POST
    @Path("loginA")
    @Consumes("application/json")
    @Produces("application/json")
    public Response loginAdmid(EmployeesDTO dto){
        EmployeeProvider employeeProvider = new EmployeeProvider();
        if(employeeProvider.loginAdmin(dto.getPassword())){
            return new Response("Operacion exitosa");
        }else{
            return new Response("Operacion fallida");
        }
    }

}
