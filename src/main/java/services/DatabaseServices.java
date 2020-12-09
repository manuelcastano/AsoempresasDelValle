package services;

import config.Response;
import db.MySQLConnection;
import db.PoolConnection;

import javax.ejb.Stateless;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Path("db")
public class DatabaseServices {

    @POST
    @Path("create")
    @Produces("application/json")
    public Response createDB(){
        PoolConnection pool = PoolConnection.getInstance();

        if(pool.getConexion().createDatabase()){
            return new Response("Base de datos creada con exito");
        }else{
            return new Response("Base de datos no fue creada");
        }
    }

}