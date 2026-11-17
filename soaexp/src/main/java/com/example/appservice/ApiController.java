package com.example.appservice;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {
    private final JdbcTemplate jdbcTemplate;

    public ApiController(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @GetMapping("/api")
    public ApiResponse api() {
        jdbcTemplate.queryForObject("SELECT 1", Integer.class);
        return new ApiResponse("ok", "connected");
    }

    public record ApiResponse(String status, String database) {
    }
}
