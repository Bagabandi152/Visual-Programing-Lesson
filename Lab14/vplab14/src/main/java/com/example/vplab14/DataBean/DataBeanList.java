package com.example.vplab14.DataBean;

import com.example.vplab14.conn.ConnectionUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DataBeanList {
    private Connection conn = ConnectionUtils.getConnection();

    public DataBeanList() throws SQLException, ClassNotFoundException {
    }

    public ArrayList<DataBean> getDataBeanList() throws SQLException {
        ArrayList<DataBean> dataBeanList = new ArrayList<DataBean>();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from employees");
        //Retrieving values
        while(rs.next()) {
            dataBeanList.add(produce(rs.getString("employee_id"), rs.getString("employee_name"), rs.getInt("salary")));
        }
        return dataBeanList;
    }

    /**
     * This method returns a DataBean object,
     * with name and country set in it.
     */
    private DataBean produce(String employee_id, String employee_name, int salary) {

        DataBean dataBean = new DataBean();
        dataBean.setE_ID(employee_id);
        dataBean.setE_NAME(employee_name);
        dataBean.setE_SALARY(salary);

        return dataBean;
    }
}