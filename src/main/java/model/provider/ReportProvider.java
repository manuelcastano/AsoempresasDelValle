package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Report;
import model.dto.ReportsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public Report map(ReportsDTO reportDTO) {
        Report report = new Report();
        report.setPurchase(reportDTO.getPurchaseDate());
        report.setStartDate(reportDTO.getStartDate());
        report.setCompanyID(reportDTO.getCompanies().getId());
        return report;
    }

    public void insertReport(Report report) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO reports (start_date,purchase, companyID) VALUES ('$start_date','$purchase','$companyID') ";
        sql = sql.replace("$start_date", report.getStartDate());
        sql = sql.replace("$purchase", report.getPurchase());
        sql = sql.replace("$companyID", ""+report.getCompanyID());
        connection.executeSQL(sql);
    }

    public ArrayList<ReportsDTO> getAllReportsByCompany(int id) {
            ArrayList<ReportsDTO> reportsDTOS = new ArrayList<>();
            MySQLConnection connection = pool.getConexion();
              try {
                  String sql = "SELECT start_date,purchase,companyID  FROM reports WHERE companyID=" + id;
                  ResultSet resultSet = connection.Query(sql);

                  while (resultSet.next()) {
                      ReportsDTO reportDTO = new ReportsDTO();
                      reportDTO.setStartDate(resultSet.getString(1));
                      reportDTO.setPurchaseDate(resultSet.getString(2));
                      //modificar en el futuro
                      reportDTO.setCompanies(null);
                      reportsDTOS.add(reportDTO);
                  }

              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
              connection.disconnect();
              return reportsDTOS;

    }


}
