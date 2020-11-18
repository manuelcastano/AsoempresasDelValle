package db;

import java.sql.*;

public class MySQLConnection {

    private Connection connection;
    private boolean inUse;

    public MySQLConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Importacion
            inUse = false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void connect(){
        String url = "jdbc:mysql://200.3.193.22:3306/P09728_1_11";
        try {
            connection = DriverManager.getConnection(url,"P09728_1_11","ZCSaQGZU");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void disconnect(){

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public boolean createDatabase(){
        boolean succes = false;
        try {
            connect();
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS reports(id INT PRIMARY KEY AUTO_INCREMENT,start_date VARCHAR(100),purchase VARCHAR(100), companyID INT, FOREIGN  KEY  (companyID) REFERENCES  companies(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS employees(id INT PRIMARY KEY AUTO_INCREMENT,user VARCHAR(100),password VARCHAR(100), companyID INT, FOREIGN  KEY  (companyID) REFERENCES  companies(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS companies(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(100),password VARCHAR(100), sectorID INT, FOREIGN  KEY  (sectorID) REFERENCES  sectors(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS sectors(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(100)");
            succes = true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            succes = false;
        }finally {
            disconnect();
        }
        return succes;
    }

    //Acciones: insertar, hacer update, crear o eliminar.
    public void executeSQL(String sql){
        connect();

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
            inUse = false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            disconnect();
        }

    }

    //Esto es solamente para los resultsSets
    public ResultSet Query(String sql) {
        ResultSet output = null;
        try {
            connect();
            Statement statement = connection.createStatement();
            output = statement.executeQuery(sql);
            inUse = false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            // disconnect();
        }
        return output;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }




}