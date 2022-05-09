package com.example.vplab13;

import javafx.application.Application;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class HtmlFromXmlFile {

    public static void main(String[] args) throws JRException, IOException {

        // Compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport("D:\\Github\\Visual-Programing-Lesson\\Lab13\\StyledTextReport\\StyledTextReport.jrxml");

        // Parameters for report
        Map<String, Object> parameters = new HashMap<String, Object>();

        // DataSource
        // This is simple example, no database.
        // then using empty datasource.
        JRDataSource dataSource = new JREmptyDataSource();

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        // Make sure the output directory exists.
        File outDir = new File("D:\\Github\\Visual-Programing-Lesson\\Lab13\\jasperoutput");
        outDir.mkdirs();

        // Export to HTML.
        JasperExportManager.exportReportToHtmlFile(jasperPrint, "D:\\Github\\Visual-Programing-Lesson\\Lab13\\jasperoutput\\StyledTextReport.html");

        System.out.println("Done!");
    }
}
