package com.codewithflash.restapi.repository;

import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AccountRepository {
    private final JdbcTemplate jdbc;

    public AccountRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Account findAccountById (long Id) {
        String sql = "SELECT * FROM account WHERE id = ? ";
        return jdbc.queryForObject(sql , new AccountRowMapper(), Id);
    }

    public List<Account> findAllAccounts() {
        String sql = "SELECT * FROM account";
        return jdbc.query(sql, new AccountRowMapper());
    }
    public void setNewAmount(long id , BigDecimal amount) {
        String sql = "UPDATE account SET amount = ? WHERE id = ?" ;
        jdbc.update(sql,amount,id);
    }
}








class AccountRowMapper implements  RowMapper<Account>{

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account  rowObject = new Account();
        rowObject.setId(rs.getInt("id"));
        rowObject.setName(rs.getString("name"));
        rowObject.setAmount(rs.getBigDecimal("amount"));
        return  rowObject;
    }
}