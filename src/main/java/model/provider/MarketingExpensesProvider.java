package model.provider;

import com.sun.jndi.ldap.pool.Pool;
import db.PoolConnection;
import entity.MarketingExpenses;
import entity.Sector;
import model.dto.MarketingExpensesDTO;
import model.dto.SectorsDTO;

public class MarketingExpensesProvider {


    private PoolConnection pool = PoolConnection.getInstance();

    public boolean createMarketingExtenses(MarketingExpenses mark){
        boolean t = false;
        CompaniesProvider companies = new CompaniesProvider();
        if(companies.existCompany(mark.getCompanyID())){
            t = true;
            String sql = "INSERT INTO marketingExpenses(value,date,companyID) VALUES (,'$value','$date','$companyID')";
            sql = sql.replace("$name","" + mark.getValue());
            sql = sql.replace("$date", mark.getDate());
            sql = sql.replace("$companyID", "" + mark.getCompanyID());
            pool.getConexion().executeSQL(sql);
        }


        return t;
    }

    public void updateMarketingExtenses(MarketingExpenses mark){

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
