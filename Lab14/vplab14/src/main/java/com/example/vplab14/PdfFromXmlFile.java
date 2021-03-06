package com.example.vplab14;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class PdfFromXmlFile {

    public static void main(String[] args) throws JRException, IOException {

        // Compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport("F:\\vplab14\\src\\main\\resources\\reports\\EmployeeAdapter.jrxml");

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        // This is simple example, no database.
        // then using empty datasource.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Make sure the output directory exists.
        File outDir = new File("F:\\vplab14\\src\\main\\resources\\jasperoutput");
        outDir.mkdirs();

        // Export to PDF.
        JasperExportManager.exportReportToPdfFile(jasperPrint, "F:\\vplab14\\src\\main\\resources\\jasperoutput\\EmployeeAdapter.pdf");

        System.out.println("Done!");
    }
}
