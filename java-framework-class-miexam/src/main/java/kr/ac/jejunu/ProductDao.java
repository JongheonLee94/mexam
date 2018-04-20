package kr.ac.jejunu;

import java.sql.*;

public class ProductDao {
    private final JdbcContext jdbcContext;

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
    public Product get(Long id) throws SQLException {
        Long id1 = id;
        StatementStrategy statementStrategy = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?");
            preparedStatement.setLong(1, id);
            return preparedStatement;
        };
        return jdbcContext.get( statementStrategy );
    }

    public Long insert(Product product) throws SQLException {
        Product product1 = product;
        StatementStrategy statementStrategy =connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(title,price) values (?,?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            return preparedStatement;
        };
        return jdbcContext.insert( statementStrategy );
    }

    public void update(Product product) throws SQLException {
        Product product1 = product;
        StatementStrategy statementStrategy = connection -> {

            PreparedStatement preparedStatement = connection.prepareStatement("update product set title = ?, price = ? where id= ?");
            preparedStatement.setString(1, product.getTitle());
            preparedStatement.setInt(2, product.getPrice());
            preparedStatement.setLong(3, product.getId());
            return preparedStatement;
        };

        jdbcContext.update( statementStrategy );
    }

    public void delete(Product product) throws SQLException {
        Product product1 = product;
        StatementStrategy statementStrategy =connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id=?");
            preparedStatement.setLong(1, product.getId());
            return preparedStatement;
        };
                
        jdbcContext.update( statementStrategy );
    }
}
