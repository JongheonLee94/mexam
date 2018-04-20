package kr.ac.jejunu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;


@Configuration
public class DaoFactory {
    @Value( "${db.classname}" )
    String className = "com.mysql.jdbc.Driver";
    @Value( "${db.url}" )
    String url = "jdbc:mysql://localhost/jeju";
    @Value( "${db.username}" )
    String userName = "jeju";
    @Value( "${db.password}" )
    String password = "jejupw";

    @Bean
    public ProductDao productDao() throws ClassNotFoundException {
        return new ProductDao(dataSource());
    }

    private DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource(  );
        dataSource.setDriverClass( (Class<? extends Driver>) Class.forName( className ) );
        dataSource.setUrl( url );
        dataSource.setUsername( userName );
        dataSource.setPassword( password );

        return dataSource;
    }


}
