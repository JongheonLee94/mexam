package kr.ac.jejunu;

public class DaoFactory {
    public ProductDao productDao() {
        return new ProductDao(connectionMaker());
    }

    private ConnectionMaker connectionMaker() {
        return new JejuConnectionMaker();
    }
}
