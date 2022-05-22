package com.example.vplab14;

import java.awt.Dimension;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import com.example.vplab14.conn.ConnectionUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Hans Kristanto
 */
public class ShowReportBySwing {

    Connection conn = null;

    public void initConnection() throws SQLException, ClassNotFoundException {
        conn = ConnectionUtils.getConnection();
    }

    public void showReport() throws FileNotFoundException {

        //Path to your .jasper file in your package
        String reportName = "src/main/resources/reports/EmployeeAdapter.jasper";

        //Get a stream to read the file
        InputStream is = new FileInputStream(reportName);

        try {
            //Fill the report with parameter, connection and the stream reader
            JasperPrint jp = JasperFillManager.fillReport(is, null, conn);

            //Viewer for JasperReport
            JRViewer jv = new JRViewer(jp);

            //Insert viewer to a JFrame to make it showable
            JFrame jf = new JFrame();
            jf.getContentPane().add(jv);
            jf.validate();
            jf.setVisible(true);
            jf.setSize(new Dimension(800,600));
            jf.setLocation(300,100);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException, FileNotFoundException {

        ShowReportBySwing showReportBYSwing = new ShowReportBySwing();
        showReportBYSwing.initConnection();
        showReportBYSwing.showReport();
    }

}
