package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import server.dto.cabinetAndHousing.CabinetWithEmployeesDto;
import server.dto.cabinetAndHousing.CabinetWithIdHousing;
import server.dto.cabinetAndHousing.CabinetWithIdHousingDto;
import server.entity.Cabinet;
import server.entity.Housing;
import server.entity.Log;
import server.service.CabinetService;
import server.service.LogService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class LogController {

    @Autowired
    LogService logService;

    @RequestMapping(value = "/lastVersionDB" , method = RequestMethod.GET)
    @ResponseBody
    public int getLastVersionDB() {
        Log result=new Log();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/csu", "root", "root");
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM log WHERE id=(SELECT MAX(id) FROM log)");
            while (rs.next())
            {
                result.setId(rs.getInt("id"));
                result.setTime(rs.getDate("time"));
            }
        }
        catch (SQLException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result.getId();
    }
}
