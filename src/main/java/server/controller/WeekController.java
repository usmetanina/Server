package server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import server.dto.CabinetWithEmployeesDto;
import server.dto.CabinetWithIdHousing;
import server.entity.Cabinet;
import server.entity.Housing;
import server.entity.Week;
import server.service.WeekService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/")
public class WeekController {

}
