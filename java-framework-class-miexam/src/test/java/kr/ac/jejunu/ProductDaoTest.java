package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ProductDaoTest {
    ProductDao productDao;

    @Before
    public void setup() {
        ApplicationContext applicationContext =new AnnotationConfigApplicationContext( DaoFactory.class );
        productDao = applicationContext.getBean( "productDao",ProductDao.class );
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
    @Test
    public void update() throws SQLException {
        Product product=new Product();
        product.setTitle( "오메기떡" );
        product.setPrice( 10000 );
        Long id = productDao.insert(product);

        product.setId( id );
        product.setTitle( "돌하르방" );
        product.setPrice( 89990 );
        productDao.update(product);

        Product updatedproduct = productDao.get(id);
        assertEquals(id, updatedproduct.getId());
        assertEquals(product.getTitle(), updatedproduct.getTitle());
        assertEquals(product.getPrice(), updatedproduct.getPrice());
    }

    @Test
    public void delete() throws SQLException {
        Product product=new Product();
        product.setTitle( "오메기떡" );
        product.setPrice( 10000 );
        Long id = productDao.insert(product);

        product.setId( id );

        productDao.delete(product);

        Product deletedProduct = productDao.get(id);
        assertThat( deletedProduct,nullValue() );
    }
}
