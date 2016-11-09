/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sias.util;

import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.Local;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

/**
 *
 * @author Fernando Laranjo
 */
@Component
public class JDBCBaseDAO {

    @Autowired
    @Qualifier("mainDataSource")
    private DataSource dataSource;

    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void initialize() {
        Locale.setDefault(new Locale("pt", "BR"));
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getTemplate() throws Exception {
        return jdbcTemplate;
    }

}
