package com.codewithflash.restapi.repository;

import com.codewithflash.restapi.model.Purchase;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate; //Jdbc template injected
    public PurchaseRepository( JdbcTemplate template) {
        this.jdbcTemplate = template;
    }

    public void storePurchase(Purchase purchase) {
        String sql = "INSERT INTO purchase (product, price) VALUES (?, ?)";
        jdbcTemplate.update(sql, purchase.getProduct(), purchase.getPrice());

    }

    public List<Purchase> findAllPurchases() {
        String sql = "SELECT * FROM purchase";

        // Row mapper to tell jdbc template to map the result into a purchase object
        RowMapper<Purchase> purchaseRowMapper = (rs, rowNum) -> {
                Purchase  rowObject = new Purchase();
                rowObject.setId(rs.getInt("id"));
                rowObject.setProduct(rs.getString("product"));
                rowObject.setPrice(rs.getBigDecimal("price"));
                return  rowObject;
        };
        return  jdbcTemplate.query(sql, purchaseRowMapper );
    }


}
