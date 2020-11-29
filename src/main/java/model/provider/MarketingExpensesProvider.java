package model.provider;

import com.sun.jndi.ldap.pool.Pool;
import db.MySQLConnection;
import db.PoolConnection;
import entity.Companies;
import entity.MarketingExpenses;
import entity.Sector;
import model.dto.MarketingExpensesDTO;
import model.dto.SectorsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarketingExpensesProvider {


    private PoolConnection pool = PoolConnection.getInstance();

    public boolean createMarketingExtenses(MarketingExpenses mark){
        boolean t = false;
        CompaniesProvider companies = new CompaniesProvider();
        if(companies.existCompany(mark.getCompanyID())){
            t = true;
            String sql = "INSERT INTO marketingExpenses(value,date,companyID) VALUES ('$value','$date','$companyID')";
            sql = sql.replace("$value","" + mark.getValue());
            sql = sql.replace("$date", "" + mark.getDate());
            sql = sql.replace("$companyID", "" + mark.getCompanyID());
            pool.getConexion().executeSQL(sql);
        }


        return t;
    }

    public ArrayList<MarketingExpenses> getAllMarketingExpenses(){
        ArrayList<MarketingExpenses> marketings = new ArrayList<MarketingExpenses>();
        MySQLConnection mysql = pool.getConexion();
        try {
            String sql = "SELECT id,value,date,companyID FROM marketingExpenses";

            ResultSet resultset = mysql.Query(sql);

            while(resultset.next()){
                marketings.add(new MarketingExpenses(
                                resultset.getInt(1),
                                resultset.getInt(2),
                                resultset.getLong(3),
                                resultset.getInt(4)
                        )
                );

            }
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        mysql.disconnect();
        return marketings;
    }


    public boolean updateMarketingExtenses(int id,MarketingExpenses mark){
        ArrayList<MarketingExpenses> marketings = getAllMarketingExpenses();
        boolean t = false;
        for(int i = 0; i < marketings.size() && !t;i++){
            if(marketings.get(i).getId() == id){
                String sql = "UPDATE marketingExpenses SET marketingExpenses.value = $VALUE, marketingExpenses.date = '$DATE' WHERE marketingExpenses.id = $ID";
                sql = sql.replace("$ID","" + id);
                sql = sql.replace("$VALUE","" + mark.getValue());
                sql = sql.replace("$DATE", "" + mark.getDate());
                pool.getConexion().executeSQL(sql);
                t = true;
            }
        }
        return t;
    }

    public void delateMarketingExtenses(int id){

        String sql = "DELETE FROM marketingExpenses WHERE marketingExpenses.id = $MARKETINGEXPENSESID";
        sql = sql.replace("$MARKETINGEXPENSESID", "" + id);
        pool.getConexion().executeSQL(sql);

    }

    public MarketingExpenses mapFromDTO(MarketingExpensesDTO marketing){
        MarketingExpenses mark = new MarketingExpenses();
        mark.setValue(marketing.getValue());
        mark.setDate(marketing.getDate());
        mark.setCompanyID(marketing.getCompanies().getId());

        return mark;
    }


}
