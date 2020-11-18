package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Employee;
import model.dto.EmployeesDTO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeProvider {

    private PoolConnection pool = PoolConnection.getInstance();


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
            String sql = "SELECT user FROM employees WHERE employees.user = " + user+ "AND employees.password ="+password;
            ResultSet resultSet = connection.Query(sql);

            while (resultSet.next()) {
                result = true;
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }
}
