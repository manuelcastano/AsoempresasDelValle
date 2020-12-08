package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Companies;
import entity.Sector;
import model.dto.CompaniesDTO;
import model.dto.SectorsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectorProvider {

    public PoolConnection pool;

    public void InsertSector(Sector sector){
        pool = PoolConnection.getInstance();
        String sql = "INSERT INTO sectores(name) VALUES ('$name')";
        sql = sql.replace("$name", sector.getName());
        pool.getConexion().executeSQL(sql);
    }


    public boolean existSector(int idSector){
        boolean t = false;
        ArrayList<Sector> sectores = getAllSectores();

        for(int i = 0; i < sectores.size() && !t ;i++){
            if(sectores.get(i).getId() == idSector){
                t = true;
            }
        }
        return t;
    }

    public ArrayList<Sector> getAllSectores(){
        ArrayList<Sector> sectores = new ArrayList<Sector>();
        MySQLConnection mysql = pool.getConexion();
        try {
            String sql = "SELECT id, name FROM sectores";
            ResultSet resultset = mysql.Query(sql);

            while(resultset.next()){
                sectores.add(new Sector(
                                resultset.getInt(1),
                                resultset.getString(2)
                        )
                );
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        mysql.disconnect();
        return sectores;

    }

    public void delateSector(int id){

        String sql = ("DELETE FROM sectores WHERE sectores.id = $SECTORESID")
                .replace("$SECTORESID" ,"" + id);
        pool.getConexion().executeSQL(sql);

    }


    public Sector mapFromDTO(SectorsDTO sector){
        Sector sectores = new Sector();
        sectores.setName(sector.getName());
        return sectores;
    }


}