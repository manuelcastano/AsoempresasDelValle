package db;

import javax.ejb.Stateless;
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
            statement.execute("CREATE TABLE IF NOT EXISTS profesores(id INT PRIMARY  KEY AUTO_INCREMENT,nombre VARCHAR(100), facultad VARCHAR(100) )");
            statement.execute("CREATE TABLE IF NOT EXISTS cursos(id INT PRIMARY  KEY AUTO_INCREMENT,nombre VARCHAR(100), programa VARCHAR(100), profesorID INT, " + "FOREIGN  KEY (profesorID) REFERENCES profesores(id))");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiante(id INT PRIMARY  KEY AUTO_INCREMENT,nombre VARCHAR(100), codigo VARCHAR(100) )");
            statement.execute("CREATE TABLE IF NOT EXISTS estudiantes_cursos(id INT PRIMARY KEY AUTO_INCREMENT, estudianteID INT, cursoID INT, " +
                    "FOREIGN KEY (estudianteID) REFERENCES estudiantes(id), " +
                    "FOREIGN KEY (cursoID) REFERENCES cursos(id))");
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