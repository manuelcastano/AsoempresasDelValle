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
    @Path("delete")
    public Response deleteEmoloyee(String user){
        EmployeeProvider employeeProvider = new EmployeeProvider();
        employeeProvider.removeEmployee(user);
        return new Response("Operacion exitosa");
    }

    @GET
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public boolean login(String user, String password){
        EmployeeProvider employeeProvider = new EmployeeProvider();
        return employeeProvider.login(user, password);
    }

    @GET
    @Path("login")
    @Consumes("application/json")
    @Produces("application/json")
    public boolean loginAdmid(String password){
        EmployeeProvider employeeProvider = new EmployeeProvider();
        return employeeProvider.loginAdmin(password);
    }

}
