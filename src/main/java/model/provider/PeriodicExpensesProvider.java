package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.PeriodicExpenses;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PeriodicExpensesProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public PeriodicExpensesProvider(){

    }

    public ArrayList<PeriodicExpenses> getAllPeriodicExpenses(){
        ArrayList<PeriodicExpenses> expenses = new ArrayList<PeriodicExpenses>();
        MySQLConnection mysql = pool.getConexion();
        try {
            String sql = "SELECT id,value,date,companyID FROM periodicexpenses";

            ResultSet resultset = mysql.Query(sql);

            while(resultset.next()){
                expenses.add(new PeriodicExpenses(
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
        return expenses;
    }


    public ArrayList<PeriodicExpenses> periodicExpensesInTheRange(long initial, long finald){
        ArrayList<PeriodicExpenses> all = getAllPeriodicExpenses();
        ArrayList<PeriodicExpenses> out = new ArrayList<PeriodicExpenses>();
        for(int i=0;i<all.size();i++){
            if(initial >= all.get(i).getDate() && all.get(i).getDate() <= finald){
                out.add(all.get(i));
            }
        }
        return out;
    }
}
