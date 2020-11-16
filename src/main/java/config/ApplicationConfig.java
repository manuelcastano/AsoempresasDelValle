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
        resources.add(SectorServices.class);
        resources.add(MarketingExpensesServices.class);
        return resources;
    }
}
