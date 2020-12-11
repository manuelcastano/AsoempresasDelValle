package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Indebtedness;
import entity.MarketingExpenses;
import model.dto.IndebtednessDTO;
import model.dto.MarketingExpensesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class IndebtednessProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public void delateIndebtednessProvider(int id){
        String sql = "DELETE FROM indebtedness WHERE indebtedness.id = $INDEBTEDNESSID";
        sql = sql.replace("$INDEBTEDNESSID", "" + id);
        pool.getConexion().executeSQL(sql);
    }

    public boolean createIndebtedness(Indebtedness indeb){
        boolean t = false;
        CompaniesProvider provider = new CompaniesProvider();
        if(provider.existCompany(indeb.getCompanyID())){
            t = true;
            String sql = "INSERT INTO indebtedness(value,date,companyID) VALUES ('$value','$date','$companyID')";
            sql = sql.replace("$value","" + indeb.getValue());
            sql = sql.replace("$date", "" + indeb.getDate());
            sql = sql.replace("$companyID", "" + indeb.getCompanyID());
            pool.getConexion().executeSQL(sql);
        }
        return t;
    }

    public ArrayList<Indebtedness> getAllIndebtedness(){
        ArrayList<Indebtedness> indebtedness = new ArrayList<Indebtedness>();
        MySQLConnection mysql = pool.getConexion();
        try {
            String sql = "SELECT * FROM indebtedness";

            ResultSet resultset = mysql.Query(sql);

            while(resultset.next()){
                indebtedness.add(new Indebtedness(
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
        return indebtedness;
    }

    public boolean updateIndebtedness(int id,Indebtedness indeb){
        ArrayList<Indebtedness> ine = getAllIndebtedness();
        boolean t = false;
        for(int i = 0; i < ine.size() && !t;i++){
            if(ine.get(i).getId() == id){
                String sql = "UPDATE indebtedness SET indebtedness.value = $VALUE, indebtedness.date = '$DATE' WHERE indebtedness.id = $ID";
                sql = sql.replace("$ID","" + id);
                sql = sql.replace("$VALUE","" + indeb.getValue());
                sql = sql.replace("$DATE", "" + indeb.getDate());
                pool.getConexion().executeSQL(sql);
                t = true;
            }
        }
        return t;
    }


    public Indebtedness mapFromDTO(IndebtednessDTO indeb){
        Indebtedness in = new Indebtedness();

        try{
            in.setValue(indeb.getValue());
            String msj = indeb.getDate();
            SimpleDateFormat f = new SimpleDateFormat("MM-DD-yyyy");
            Date d = (Date)f.parse(msj);
            long milliseconds = d.getTime();
            in.setDate(milliseconds);
            in.setCompanyID(indeb.getCompanies().getId());
        }catch(ParseException e){
            e.printStackTrace();
        }

        return in;
    }

    public ArrayList<Indebtedness> indebtednessInTheRange(long initial, long finald){
        ArrayList<Indebtedness> all = getAllIndebtedness();
        ArrayList<Indebtedness> out = new ArrayList<Indebtedness>();
        for(int i=0;i<all.size();i++){
            if(initial >= all.get(i).getDate() && all.get(i).getDate() <= finald){
                out.add(all.get(i));
            }
        }
        return out;
    }


    public ArrayList<Indebtedness> indebtednessInTheRangeByID(long initial, long finald, int id){
        ArrayList<Indebtedness> all = getAllIndebtedness();
        ArrayList<Indebtedness> out = new ArrayList<Indebtedness>();
        for(int i=0;i<all.size();i++){
            if(initial >= all.get(i).getDate() && all.get(i).getDate() <= finald){
                if(all.get(i).getCompanyID() == id) {
                    out.add(all.get(i));
                }
            }
        }
        return out;
    }

}
