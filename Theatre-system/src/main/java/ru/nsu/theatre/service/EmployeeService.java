//package ru.nsu.theatre.service;
//
//import lombok.AllArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//import ru.nsu.theatre.entities.Employee;
//import ru.nsu.theatre.repository.EmployeeRepository;
//
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//@AllArgsConstructor
//public class EmployeeService {
//
//    private JdbcTemplate jdbcTemplate;
//
//    public void insertData(String data) {
//        jdbcTemplate.update("INSERT INTO my_table (my_column) VALUES (?)", data);
//        jdbcTemplate.update("CALL my_trigger()"); // вызываем триггер после вставки данных
//    }
//}