package com.example.demotrueClub;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RestController
public class AssingmentController {

@RequestMapping(value = "/createTable" , method = RequestMethod.POST)
    public static void createTable(@RequestParam(value = "name")String name) throws SQLException {
    DBoperations.createTable(name);
}



}
