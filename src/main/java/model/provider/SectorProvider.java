package model.provider;

import db.PoolConnection;
import entity.Companies;
import entity.Sector;
import model.dto.CompaniesDTO;
import model.dto.SectorsDTO;

public class SectorProvider {

    public PoolConnection pool;

    public void InsertSector(Sector sector){
        pool = PoolConnection.getInstance();
        String sql = "INSERT INTO sectores(name) VALUES ('$name')";
        sql = sql.replace("$name", sector.getName());
        pool.getConexion().executeSQL(sql);
    }

    public Sector mapFromDTO(SectorsDTO sector){
        Sector sectores = new Sector();
        sectores.setName(sector.getName());
        return sectores;
    }


}
