package model.provider;

import model.dto.EmployeeDTO;
import db.MySQLConnection;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeProvider {

    public EmployeeDTO getEmployeeById(int id) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        MySQLConnection connection = new MySQLConnection();
        return null;
    }

}
