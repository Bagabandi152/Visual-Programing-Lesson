package com.example.vplab14;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.vplab14.DataBean.DataBean;
import com.example.vplab14.DataBean.DataBeanList;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperReportFill {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws SQLException, ClassNotFoundException, JRException {
        String sourceFileName = "F:\\vplab14\\src\\main\\resources\\reports\\EmployeeAdapter.jasper";
//        JasperCompileManager.compileReportToFile(sourceFileName);
        DataBeanList DataBeanList = new DataBeanList();
        ArrayList<DataBean> dataList = DataBeanList.getDataBeanList();

        JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataList);

        Map parameters = new HashMap();
        try {
            JasperFillManager.fillReportToFile(sourceFileName, parameters, beanColDataSource);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}