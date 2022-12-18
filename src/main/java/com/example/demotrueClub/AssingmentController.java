package com.example.demotrueClub;

import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

@RestController
public class AssingmentController {

@RequestMapping(value = "/createTable" , method = RequestMethod.POST)
    public void createTable(@RequestParam(value = "name")String name) throws SQLException {
    DBoperations.createTable(name);
}

@RequestMapping(value = "/insertRecord" , method = RequestMethod.POST)
    public void insertRecord(@RequestBody CreateRequest request) throws SQLException {
    DBoperations.insertRecord(request);
}

@RequestMapping(value = "/recordList" , method = RequestMethod.GET)
    public List<Assignment> recordList() throws SQLException {
     return DBoperations.getRecords();
}
@PostMapping("/deleteRecord/{id}")
    public void deleteRecord(@RequestParam int id) throws SQLException {
    DBoperations.deleteRecord(id);
}

@PostMapping("/getRecord/{id}")
    public Assignment getRecord(@RequestParam int id) throws SQLException {
    return DBoperations.getRecord(id);
}

}
