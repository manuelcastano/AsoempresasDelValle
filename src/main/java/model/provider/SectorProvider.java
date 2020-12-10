package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Companies;
import entity.Sector;
import model.dto.CompaniesDTO;
import model.dto.SectorsDTO;

import javax.xml.transform.Result;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SectorProvider {

    public PoolConnection pool;

    public SectorProvider(){
        pool = PoolConnection.getInstance();
    }

    public void InsertSector(Sector sector){
        String sql = "INSERT INTO sectores(name) VALUES ('$name')";
        sql = sql.replace("$name", sector.getName());
        pool.getConexion().executeSQL(sql);
    }


    public boolean existSector(int idSector){
        boolean t = false;
        MySQLConnection connection = pool.getConexion();
        try {
            String sql = "SELECT id FROM sectores WHERE sectores.id=" + idSector;
            ResultSet resultSet = connection.Query(sql);
            while (resultSet.next()){
                t = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
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