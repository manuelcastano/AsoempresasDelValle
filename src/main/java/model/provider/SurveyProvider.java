package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Surveys;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SurveyProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public ArrayList<Surveys> getAllSurveys(){
        ArrayList<Surveys> surveys = new ArrayList<Surveys>();
        MySQLConnection mySQLConnection = pool.getConexion();
        String sql = "SELECT * FROM surveys ";
        ResultSet resultSet = mySQLConnection.Query(sql);

        while(true){
            try {
                while (resultSet.next()){
                    surveys.add(new Surveys(
                            resultSet.getInt(1),
                            resultSet.getInt(2),
                            resultSet.getLong(3),
                            resultSet.getInt(4)
                    ));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            mySQLConnection.disconnect();
            return surveys;
        }
    }


    public ArrayList<Surveys> surveysInTheRange(long initial, long finald){
        ArrayList<Surveys> all = getAllSurveys();
        ArrayList<Surveys> out = new ArrayList<Surveys>();
        for(int i=0;i<all.size();i++){
            if(initial >= all.get(i).getDate() && all.get(i).getDate() <= finald){
                out.add(all.get(i));
            }
        }
        return out;
    }


}
