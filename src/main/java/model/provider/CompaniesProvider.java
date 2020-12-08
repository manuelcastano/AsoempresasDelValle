package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Companies;
import entity.Surveys;
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


    public CompaniesDTO getCompanyByID(int id){
        MySQLConnection connection = pool.getConexion();
        String sql = "SELECT id, name, password, sectorID FROM company WHERE id="+id;
        ResultSet resultSet = connection.Query(sql);
        CompaniesDTO companiesDTO = new CompaniesDTO();
            try {
                while(resultSet.next()){
                    companiesDTO.setId(resultSet.getInt(1));
                    companiesDTO.setName(resultSet.getString(2));
                    companiesDTO.setPassword(resultSet.getString(3));
                    companiesDTO.setSectorID(resultSet.getInt(4));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        return companiesDTO;

    }

    public ArrayList<Companies> getAllCompanies(){
        ArrayList<Companies> compañias = new ArrayList<Companies>();
        MySQLConnection mysql = pool.getConexion();
        try {
            String sql = "SELECT * FROM company";
            ResultSet resultset = mysql.Query(sql);

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
        mysql.disconnect();
        return compañias;
    }

    public CompaniesDTO getBest(long initial, long finald){
        SurveyProvider provider = new SurveyProvider();
        ArrayList<Surveys> ref = provider.surveysInTheRange(initial, finald);
        Surveys bestSurvey = ref.get(0);
        for(int i=0;i<ref.size();i++){
            if(ref.get(i).getSatisfactionLevel()>bestSurvey.getSatisfactionLevel()){
                bestSurvey = ref.get(i);
            }
        }
        return getCompanyByID(bestSurvey.getCompanyID());
    }

    public CompaniesDTO getWorst(long initial, long finald){
        SurveyProvider provider = new SurveyProvider();
        ArrayList<Surveys> ref = provider.surveysInTheRange(initial, finald);
        Surveys worstSurvey = ref.get(0);
        for(int i=0;i<ref.size();i++){
            if(ref.get(i).getSatisfactionLevel()<worstSurvey.getSatisfactionLevel()){
                worstSurvey = ref.get(i);
            }
        }
        return getCompanyByID(worstSurvey.getCompanyID());
    }

    public CompaniesDTO getAverage(long initial, long finald){
        SurveyProvider provider = new SurveyProvider();
        ArrayList<Surveys> ref = provider.surveysInTheRange(initial, finald);
        int average = 0;
        int sumatotal = 0;
        Surveys averageSurveys = ref.get(0);
        for(int i=0;i<ref.size();i++){
                sumatotal += ref.get(i).getSatisfactionLevel();
            }
        average = sumatotal/ref.size();
        for (int i=0;i<ref.size();i++){
            if(Math.abs(ref.get(i).getSatisfactionLevel()-average) < Math.abs(averageSurveys.getSatisfactionLevel()-average)){
                averageSurveys = ref.get(i);
            }
        }

        return getCompanyByID(averageSurveys.getCompanyID());

    }

    public Companies mapFromDTO(CompaniesDTO compani){
        Companies company = new Companies();
        company.setName(compani.getName());
        company.setPassword(compani.getPassword());
        company.setSectorID(compani.getSector().getId());
        return company;
    }

    public boolean existCompany(int id){
        boolean t = false;
        ArrayList<Companies> compañias = getAllCompanies();

        for(int i = 0; i < compañias.size() & !t ;i++){

            if(compañias.get(i).getId() == id){
                t = true;
            }

        }

        return t;

    }


}
