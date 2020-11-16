package model.provider;

import db.PoolConnection;
import entity.Companies;
import model.dto.CompaniesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompaniesProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public boolean InsertCompanies(Companies company){
        boolean t = false;
        SectorProvider sec = new SectorProvider();

        if(sec.existSector(company.getSectorID())){

            String sql = "INSERT INTO company(name,password,sectorID) VALUES ('$name','$password','$sectorID')";
            sql = sql.replace("$name", company.getName());
            sql = sql.replace("$password", company.getPassword());
            sql = sql.replace("$sectorID", "" + company.getSectorID());
            pool.getConexion().executeSQL(sql);
            t = true;
        }

        return t;


    }

    public boolean existCompany(int id){
        boolean t = false;
        ArrayList<Companies> compañias = new ArrayList<Companies>();

        for(int i = 0; i < compañias.size() & !t ;i++){

            if(compañias.get(i).getId() == id){
                t = true;
            }

        }

        return t;

    }

    public ArrayList<Companies> getAllCompanies(){
        ArrayList<Companies> compañias = new ArrayList<Companies>();
        try {
            String sql = "SELECT id, name, password,sectorID FROM company";
            ResultSet resultset = pool.getConexion().Query(sql);

            while(resultset.next()){
                compañias.add(new Companies(
                        resultset.getInt(1),
                        resultset.getString(2),
                        resultset.getString(3),
                        resultset.getInt(4)
                        )
                );
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return compañias;
    }

    public void delateCompany(int id){



    }

    public Companies mapFromDTO(CompaniesDTO compani){
        Companies company = new Companies();
        company.setName(compani.getName());
        company.setPassword(compani.getPassword());
        company.setSectorID(compani.getSector().getId());
        return company;
    }

}
