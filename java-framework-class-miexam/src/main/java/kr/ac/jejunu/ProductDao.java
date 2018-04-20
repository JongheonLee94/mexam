package kr.ac.jejunu;

import java.sql.*;

public class ProductDao {
    private final JdbcContext jdbcContext;

    public ProductDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }
    public Product get(Long id) throws SQLException {
        StatementStrategy statementStrategy = new GetProductStatementStrategy( id );
        return jdbcContext.get( statementStrategy );
    }

    public Long insert(Product product) throws SQLException {
        StatementStrategy statementStrategy = new InsertProductStatementStrategy( product );
        return jdbcContext.insert( statementStrategy );
    }

    public void update(Product product) throws SQLException {
        StatementStrategy statementStrategy = new UpdateProductStatementStrategy( product );
        jdbcContext.update( statementStrategy );
    }

    public void delete(Product product) throws SQLException {
        StatementStrategy statementStrategy = new deleteProductStatementStrategy( product );
        jdbcContext.update( statementStrategy );
    }
}
