package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class deleteProductStatementStrategy implements StatementStrategy {
    private Product product;
    public deleteProductStatementStrategy(Product product) {
        this.product = product;
    }

    @Override
    public PreparedStatement makeConnection(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM product WHERE id=?");
        preparedStatement.setLong(1, product.getId());
        return preparedStatement;
    }
}
