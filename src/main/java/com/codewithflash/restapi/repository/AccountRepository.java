package com.codewithflash.restapi.repository;

import com.codewithflash.restapi.model.Account;
import com.codewithflash.restapi.model.Purchase;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//---------------SIMPLE JDBC DATA SOURCE METHOD---------------//
//@Repository
//public class AccountRepository {
//    private final JdbcTemplate jdbc;
//
//    public AccountRepository(JdbcTemplate jdbc) {
//        this.jdbc = jdbc;
//    }
//
//    public Account findAccountById (long Id) {
//        String sql = "SELECT * FROM account WHERE id = ? ";
//        return jdbc.queryForObject(sql , new AccountRowMapper(), Id);
//    }
//
//    public List<Account> findAllAccounts() {
//        String sql = "SELECT * FROM account";
//        return jdbc.query(sql, new AccountRowMapper());
//    }
//    public void setNewAmount(long id , BigDecimal amount) {
//        String sql = "UPDATE account SET amount = ? WHERE id = ?" ;
//        jdbc.update(sql,amount,id);
//    }
//}
//
//
//
//
//
//
//class AccountRowMapper implements  RowMapper<Account>{
//
//    @Override
//    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
//        Account  rowObject = new Account();
//        rowObject.setId(rs.getInt("id"));
//        rowObject.setName(rs.getString("name"));
//        rowObject.setAmount(rs.getBigDecimal("amount"));
//        return  rowObject;
//    }
//}

//--------------USING SPRING DATA METHOD---------------//
public  interface AccountRepository
        extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account WHERE name = :name")  // no space between : and name variable
    List<Account> findAccountsByName(String name);

    //@Query("SELECT * FROM account WHERE id = :id")  //Spring can interpret the name convention to sql statement
    Optional<Account> findAccountById (long Id);

    //---For modifying data like UPDATE, INSERT,DELETE use the modify annotation---//

    @Modifying
    @Query("UPDATE account SET amount = :amount WHERE id = :id")
    void setNewAmount(long id, BigDecimal amount);

}