package com.example.vplab14;

import net.sf.jasperreports.engine.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HtmlFromXmlFile {

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

        // Export to HTML.
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "F:\\vplab14\\src\\main\\resources\\jasperoutput\\EmployeeAdapter.html");

        System.out.println("Done!");
    }
}
