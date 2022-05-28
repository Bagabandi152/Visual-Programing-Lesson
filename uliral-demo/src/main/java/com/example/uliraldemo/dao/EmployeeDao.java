package com.example.uliraldemo.dao;

import com.example.uliraldemo.conn.DbConnectionUtils;
import com.example.uliraldemo.model.Department;
import com.example.uliraldemo.model.Employee;
import com.example.uliraldemo.model.Position;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Bagaa
 * @project uliral-demo
 * @created 28/05/2022 - 11:58 AM
 * @purpose
 * @definition
 */
public class EmployeeDao {
    public static ObservableList<Employee> getEmployeesFromDb() throws SQLException, ClassNotFoundException {
        ObservableList<Employee> employees = FXCollections.observableArrayList();

        String query = "SELECT * FROM d_db_employee";
        ResultSet rs = DbConnectionUtils.dbExecuteQuery(query);

        while (rs.next()){
            Employee newEmp = new Employee(rs.getString("fullName"),
            rs.getString("nickName"), rs.getInt("positionId"),
            rs.getInt("departmentId"), rs.getString("mobile"),
            rs.getString("phoneExt"), rs.getString("email"),
            rs.getString("facebookId"), rs.getString("lineId"), rs.getString("note"));

            employees.add(newEmp);
        }

        return employees;
    }


    public static ObservableList<Department> getDepartmentsFromDb() throws SQLException, ClassNotFoundException {
        ObservableList<Department> departments = FXCollections.observableArrayList();

        String query = "SELECT * FROM d_db_department";
        ResultSet rs = DbConnectionUtils.dbExecuteQuery(query);

        while (rs.next()){
            Department newDep = new Department(
                    rs.getInt("departmentId"),
                    rs.getString("departmentName")
            );

            departments.add(newDep);
        }

        return departments;
    }

    public static ObservableList<Position> getPositionsFromDb() throws SQLException, ClassNotFoundException {
        ObservableList<Position> positions = FXCollections.observableArrayList();

        String query = "SELECT * FROM d_db_position";
        ResultSet rs = DbConnectionUtils.dbExecuteQuery(query);

        while (rs.next()){
            Position newPos = new Position(
                    rs.getInt("positionId"),
                    rs.getString("positionName")
            );

            positions.add(newPos);
        }

        return positions;
    }
}
