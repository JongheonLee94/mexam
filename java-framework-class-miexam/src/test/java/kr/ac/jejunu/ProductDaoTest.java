package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ProductDaoTest {
    ProductDao productDao;
    @Before
    public void setup() {
        productDao = new ProductDao();
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {

        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        Product product = productDao.get(id);
        assertEquals(id, product.getId());
        assertEquals(title, product.getTitle());
        assertEquals(price, product.getPrice());
    }
    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product=new Product();
        product.setTitle( "오메기떡" );
        product.setPrice( 10000 );
        Long id = productDao.insert(product);

        Product insertedproduct = productDao.get(id);
        assertEquals(id, insertedproduct.getId());
        assertEquals(product.getTitle(), insertedproduct.getTitle());
        assertEquals(product.getPrice(), insertedproduct.getPrice());
    }
}