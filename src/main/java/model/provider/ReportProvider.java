package model.provider;

import db.MySQLConnection;
import db.PoolConnection;
import entity.Report;
import model.dto.ReportsDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReportProvider {

    private PoolConnection pool = PoolConnection.getInstance();

    public Report map(ReportsDTO reportDTO) {
        Report report = new Report();
        try {
            String msj = reportDTO.getPurchaseDate();
            SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
            Date d = (Date) f.parse(msj);
            long milliseconds = d.getTime();
            report.setPurchase(milliseconds);
            String msj2 = reportDTO.getStartDate();
            SimpleDateFormat f2 = new SimpleDateFormat("dd-MM-yyyy");
            Date d2 = (Date) f.parse(msj);
            long millisecond2 = d.getTime();
            report.setStartDate(millisecond2);
            report.setCompanyID(reportDTO.getCompanies().getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return report;
    }

    public void insertReport(Report report) {
        MySQLConnection connection = new MySQLConnection();
        String sql = "INSERT INTO reports (start_date,purchase, companyID) VALUES ('$start_date','$purchase','$companyID') ";
        sql = sql.replace("$start_date", ""+report.getStartDate());
        sql = sql.replace("$purchase", ""+report.getPurchase());
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
