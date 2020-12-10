package config;


import services.*;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api") //Abre la puerta para generar servicios
public class ApplicationConfig  extends Application{
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(CompaniesServices.class);
        resources.add(DatabaseServices.class);
        resources.add(EmployeeService.class);
        resources.add(IndebtednessServices.class);
        resources.add(MarketingExpensesServices.class);
        resources.add(ReportService.class);
        return resources;
    }
}
