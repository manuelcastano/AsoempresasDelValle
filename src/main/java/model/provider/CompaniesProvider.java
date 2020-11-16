package model.provider;

import db.PoolConnection;
import entity.Companies;
import model.dto.CompaniesDTO;

public class CompaniesProvider {

    private PoolConnection pool;

    public void InsertCompanies(Companies company){
        pool = PoolConnection.getInstance();
        String sql = "INSERT INTO company(name,password,sectorID) VALUES ('$name','$password','$sectorID')";
        sql = sql.replace("$name", company.getName());
        sql = sql.replace("$password", company.getPassword());
        sql = sql.replace("$sectorID", "" + company.getSectorID());
        pool.getConexion().executeSQL(sql);
    }



    public Companies mapFromDTO(CompaniesDTO compani){
        Companies company = new Companies();
        company.setName(compani.getName());
        company.setPassword(compani.getPassword());
        company.setSectorID(compani.getSector().getId());

        return company;
    }

}
