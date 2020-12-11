package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.*;
import model.dto.CompaniesDTO;
import model.dto.PeriodicExpensesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompaniesProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public boolean InsertCompanies(Companies company){
        boolean t = false;
        SectorProvider sec = new SectorProvider();

        if(sec.existSector(company.getSectorID())){

            String sql = "INSERT INTO company(name,sectorID) VALUES ('$name','$sectorID')";
            sql = sql.replace("$name", company.getName());
            sql = sql.replace("$sectorID", "" + company.getSectorID());
            System.out.println(sql);
            pool.getConexion().executeSQL(sql);
            t = true;
        }
        System.out.println(t);
        return t;


    }


    public CompaniesDTO getCompanyByID(int id){
        MySQLConnection connection = pool.getConexion();
        String sql = "SELECT id, name, sectorID FROM company WHERE id="+id;
        ResultSet resultSet = connection.Query(sql);
        CompaniesDTO companiesDTO = new CompaniesDTO();
            try {
                while(resultSet.next()){
                    companiesDTO.setId(resultSet.getInt(1));
                    companiesDTO.setName(resultSet.getString(2));
                    companiesDTO.setSectorID(resultSet.getInt(3));
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
                                resultset.getInt(resultset.findColumn("id")),
                                resultset.getString(resultset.findColumn("name")),
                                resultset.getInt(resultset.findColumn("id"))
                        )
                );
            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        mysql.disconnect();
        return compañias;
    }

    public ArrayList<Surveys> getBest(long initial, long finald){
        SurveyProvider provider = new SurveyProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<Surveys> mejorPorDia = new ArrayList<>();
        for(int j = 0; j < dias; j++){
            ArrayList<Surveys> ref = provider.surveysInTheRange(diaSiguiente, diaSiguiente + 86400000);
            Surveys bestSurvey = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getSatisfactionLevel()>bestSurvey.getSatisfactionLevel()){
                    bestSurvey = ref.get(i);
                }
            }
            mejorPorDia.add(bestSurvey);
            diaSiguiente += 86400000;
        }
        return mejorPorDia;
    }

    public ArrayList<Surveys> getWorst(long initial, long finald){
        SurveyProvider provider = new SurveyProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<Surveys> peorPorDia = new ArrayList<>();
        for(int j = 0; j < dias; j++){
            ArrayList<Surveys> ref = provider.surveysInTheRange(diaSiguiente, diaSiguiente + 86400000);
            Surveys bestSurvey = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getSatisfactionLevel()<bestSurvey.getSatisfactionLevel()){
                    bestSurvey = ref.get(i);
                }
            }
            peorPorDia.add(bestSurvey);
            diaSiguiente += 86400000;
        }
        return peorPorDia;
    }

    public ArrayList<Surveys> getAverage(long initial, long finald){
        SurveyProvider provider = new SurveyProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<Surveys> promedioPorDia = new ArrayList<>();
        for(int j = 0; j < dias; j++){
            ArrayList<Surveys> ref = provider.surveysInTheRange(diaSiguiente, diaSiguiente + 86400000);
            int valor = 0;
            for(int i=0;i<ref.size();i++){
                valor += ref.get(i).getSatisfactionLevel();
            }
            valor /= ref.size();
            Surveys s = new Surveys();
            s.setSatisfactionLevel(valor);
            s.setDate(diaSiguiente);
            promedioPorDia.add(s);
            diaSiguiente += 86400000;
        }
        return promedioPorDia;

    }


    public ArrayList<MarketingExpenses> getBestMarketingExpenses(long initial, long finald){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();
        long dias = (long) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<MarketingExpenses> mejorPorDia = new ArrayList<MarketingExpenses>();
        for(int j = 0; j < dias; j++){
            ArrayList<MarketingExpenses> ref = provider.marketingInTheRange(diaSiguiente, diaSiguiente + 86400000);
            if(ref.size() > 0){
                MarketingExpenses bestMarketing = null;
                if(!ref.isEmpty()){
                    bestMarketing = ref.get(0);
                }
                for(int i=0;i<ref.size();i++){
                    if(ref.get(i).getValue()>bestMarketing.getValue()){
                        bestMarketing = ref.get(i);
                    }
                }
                mejorPorDia.add(bestMarketing);
                diaSiguiente += 86400000;
            }else{
                diaSiguiente += 86400000;
            }

        }
        return mejorPorDia;
    }

    public ArrayList<MarketingExpenses> getWorstMarketingExpenses(long initial, long finald){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<MarketingExpenses> peorPorDia = new ArrayList<MarketingExpenses>();
        for(int j = 0; j < dias; j++){
            ArrayList<MarketingExpenses> ref = provider.marketingInTheRange(diaSiguiente, diaSiguiente + 86400000);
            MarketingExpenses bestMarketing = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getValue()<bestMarketing.getValue()){
                    bestMarketing = ref.get(i);
                }
            }
            peorPorDia.add(bestMarketing);
            diaSiguiente += 86400000;
        }
        return peorPorDia;
    }

    public ArrayList<MarketingExpenses> getAverageMarketingExpenses(long initial, long finald){
        MarketingExpensesProvider provider = new MarketingExpensesProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<MarketingExpenses> promedioPorDia = new ArrayList<MarketingExpenses>();
        for(int j = 0; j < dias; j++){
            ArrayList<MarketingExpenses> ref = provider.marketingInTheRange(diaSiguiente, diaSiguiente + 86400000);
            int valor = 0;
            for(int i=0;i<ref.size();i++){
                valor += ref.get(i).getValue();
            }
            valor /= ref.size();
            MarketingExpenses s = new MarketingExpenses();
            s.setValue(valor);
            s.setDate(diaSiguiente);
            promedioPorDia.add(s);
            diaSiguiente += 86400000;
        }
        return promedioPorDia;
    }

    public ArrayList<Indebtedness> getBestIndebtedness(long initial, long finald){

        IndebtednessProvider provider = new IndebtednessProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<Indebtedness> mejorPorDia = new ArrayList<Indebtedness>();
        for(int j = 0; j < dias; j++){
            ArrayList<Indebtedness> ref = provider.indebtednessInTheRange(diaSiguiente, diaSiguiente + 86400000);
            Indebtedness bestIndebtedness = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getValue()>bestIndebtedness.getValue()){
                    bestIndebtedness = ref.get(i);
                }
            }
            mejorPorDia.add(bestIndebtedness);
            diaSiguiente += 86400000;
        }
        return mejorPorDia;

    }

    public ArrayList<Indebtedness> getWorstIndebtedness(long initial, long finald){
        IndebtednessProvider provider = new IndebtednessProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<Indebtedness> peorPorDia = new ArrayList<Indebtedness>();
        for(int j = 0; j < dias; j++){
            ArrayList<Indebtedness> ref = provider.indebtednessInTheRange(diaSiguiente, diaSiguiente + 86400000);
            Indebtedness bestIndebtedness = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getValue()<bestIndebtedness.getValue()){
                    bestIndebtedness = ref.get(i);
                }
            }
            peorPorDia.add(bestIndebtedness);
            diaSiguiente += 86400000;
        }
        return peorPorDia;
    }

    public ArrayList<Indebtedness> getAverageIndebtedness(long initial, long finald){
        IndebtednessProvider provider = new IndebtednessProvider();
        int dias = (int) ((finald-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<Indebtedness> promedioPorDia = new ArrayList<Indebtedness>();
        for(int j = 0; j < dias; j++){
            ArrayList<Indebtedness> ref = provider.indebtednessInTheRange(diaSiguiente, diaSiguiente + 86400000);
            int valor = 0;
            for(int i=0;i<ref.size();i++){
                valor += ref.get(i).getValue();
            }
            valor /= ref.size();
            Indebtedness s = new Indebtedness();
            s.setValue(valor);
            s.setDate(diaSiguiente);
            promedioPorDia.add(s);
            diaSiguiente += 86400000;
        }
        return promedioPorDia;
    }


    public Companies mapFromDTO(CompaniesDTO c){
        Companies company = new Companies();
        company.setName(c.getName());
        company.setSectorID(c.getSectorID());
        return company;
    }

    public boolean existCompany(int id){
        boolean t = false;
        ArrayList<Companies> compañias = getAllCompanies();

        for(int i = 0; i < compañias.size() & !t ;i++){
            System.out.println(compañias.get(i).getId());
            if(compañias.get(i).getId() == id){
                t = true;
            }

        }

        return t;

    }

    public ArrayList<Surveys> getOnlyOneCompanyBySurveys(int idEmpresa,long initial, long finald){
        ArrayList<Surveys> out = new ArrayList<>();
        SurveyProvider survs = new SurveyProvider();
        if(existCompany(idEmpresa)) {
                out = survs.surveysInTheRangeByID(initial,finald,idEmpresa);
        }
        return out;
    }

    public ArrayList<MarketingExpenses> getOnlyOneCompanyByMarketing(int idEmpresa,long initial, long finald){
        ArrayList<MarketingExpenses> out = new ArrayList<>();
        MarketingExpensesProvider marke = new MarketingExpensesProvider();
        if(existCompany(idEmpresa)) {
            out = marke.marketingInTheRangeByID(initial,finald,idEmpresa);
        }
        return out;
    }

    public ArrayList<Indebtedness> getOnlyOneCompanyByIndebtedness(int idEmpresa,long initial, long finald){
        ArrayList<Indebtedness> out = new ArrayList<>();
        IndebtednessProvider indeb = new IndebtednessProvider();
        if(existCompany(idEmpresa)){
            out = indeb.indebtednessInTheRangeByID(initial,finald,idEmpresa);
        }
        return out;
    }


    public ArrayList<PeriodicExpenses> getBestPeriodicExpenses(long initial, long finalDate) {

        PeriodicExpensesProvider provider= new PeriodicExpensesProvider();
        int dias = (int) ((finalDate-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<PeriodicExpenses> mejorPorDia = new ArrayList<PeriodicExpenses>();
        for(int j = 0; j < dias; j++){
            ArrayList<PeriodicExpenses> ref = provider.periodicExpensesInTheRange(diaSiguiente, diaSiguiente + 86400000);
            PeriodicExpenses bestPeriodicExpenses = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getValue()>bestPeriodicExpenses.getValue()){
                    bestPeriodicExpenses = ref.get(i);
                }
            }
            mejorPorDia.add(bestPeriodicExpenses);
            diaSiguiente += 86400000;
        }
        return mejorPorDia;
    }

    public ArrayList<PeriodicExpenses> getWorstPeriodicExpenses(long initial, long finalDate) {

        PeriodicExpensesProvider provider = new PeriodicExpensesProvider();
        int dias = (int) ((finalDate-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<PeriodicExpenses> peorPorDia = new ArrayList<PeriodicExpenses>();
        for(int j = 0; j < dias; j++){
            ArrayList<PeriodicExpenses> ref = provider.periodicExpensesInTheRange(diaSiguiente, diaSiguiente + 86400000);
            PeriodicExpenses bestIndebtedness = ref.get(0);
            for(int i=0;i<ref.size();i++){
                if(ref.get(i).getValue()<bestIndebtedness.getValue()){
                    bestIndebtedness = ref.get(i);
                }
            }
            peorPorDia.add(bestIndebtedness);
            diaSiguiente += 86400000;
        }
        return peorPorDia;
    }

    public ArrayList<PeriodicExpenses> getAveragePeriodicExpenses(long initial, long finalDate) {

        PeriodicExpensesProvider provider = new PeriodicExpensesProvider();
        int dias = (int) ((finalDate-initial)/86400000);
        long diaSiguiente = initial;
        ArrayList<PeriodicExpenses> promedioPorDia = new ArrayList<PeriodicExpenses>();
        for(int j = 0; j < dias; j++){
            ArrayList<PeriodicExpenses> ref = provider.periodicExpensesInTheRange(diaSiguiente, diaSiguiente + 86400000);
            int valor = 0;
            for(int i=0;i<ref.size();i++){
                valor += ref.get(i).getValue();
            }
            valor /= ref.size();
            PeriodicExpenses s = new PeriodicExpenses();
            s.setValue(valor);
            s.setDate(diaSiguiente);
            promedioPorDia.add(s);
            diaSiguiente += 86400000;
        }
        return promedioPorDia;

    }
    public boolean createCompany(Companies c){
        SectorProvider provider = new SectorProvider();
        boolean could = false;
        if(provider.existSector(c.getSectorID())){
            could = true;
            String sql = "INSERT into companies(id,name,sector) values ($id, $name, $sector)";
            sql.replace("$id", c.getId()+"");
            sql.replace("$name", c.getName());
            sql.replace("$sector",c.getSectorID()+"");
            pool.getConexion().executeSQL(sql);
        }
        return could;
    }
    public CompaniesDTO mapToDTO(Companies c){
        CompaniesDTO dto = new CompaniesDTO();
        dto.setId(c.getId());
        dto.setName(c.getName());
        dto.setSectorID(c.getSectorID());
        return dto;
    }
}
