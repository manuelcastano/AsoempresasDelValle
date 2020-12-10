package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Employee;
import model.dto.EmployeesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeProvider {

    private PoolConnection pool = PoolConnection.getInstance();
    private static final String ADMINPASS = "admin";

    public static void insertEmployee(Employee employee) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO employees (user,password) VALUES ('$user','$password') ";
        sql = sql.replace("$user", employee.getUser());
        sql = sql.replace("$password", employee.getPassword());
        connection.executeSQL(sql);
    }

    public Employee map(EmployeesDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setUser(employeeDTO.getUserName());
        employee.setPassword(employeeDTO.getPassword());
        return employee;
    }

    public boolean login(String user, String password) {
        boolean result = false;
        MySQLConnection connection = pool.getConexion();
        try {
            String sql = "SELECT user FROM employees WHERE employees.user = " + user + "AND employees.password =" + password;
            ResultSet resultSet = connection.Query(sql);

            while (resultSet.next()) {
                result = true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void removeEmployee(String user) {
        String sql = "DELETE FROM employees WHERE employees.user=" + user;
        pool.getConexion().executeSQL(sql);
    }

    public ArrayList<Employee> getAllEmployees() {
        ArrayList<Employee> employees = new ArrayList<Employee>();
        MySQLConnection mySQLConnection = pool.getConexion();
        String sql = "SELECT * FROM employees ";
        ResultSet resultSet = mySQLConnection.Query(sql);

        while (true) {
            try {
                while (resultSet.next()) {
                    employees.add(new Employee(
                            resultSet.getInt(1),
                            resultSet.getString(2),
                            resultSet.getString(3))
                    );
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            mySQLConnection.disconnect();
            return employees;
        }
    }


    public boolean loginAdmin(String password) {
        boolean result = false;
        if (password.equals(ADMINPASS)) {
            result = true;
        }
        return result;
    }
}