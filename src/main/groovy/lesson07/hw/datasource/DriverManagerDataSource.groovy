package lesson07.hw.datasource

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource

import javax.sql.DataSource
import java.sql.Connection
import java.sql.SQLException
import java.util.logging.Logger

class DriverManagerDataSource implements DataSource {
    private DataSource dataSourcePool;

    DriverManagerDataSource(String url, String user, String pwd) {
        createConnectionPool(url, user, pwd);
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSourcePool.getConnection();
    }

    @Override
    Connection getConnection(String username, String password) {
        throw new UnsupportedOperationException();
    }

    @Override
    PrintWriter getLogWriter() {
        throw new UnsupportedOperationException();
    }

    @Override
    void setLogWriter(PrintWriter out) {
        throw new UnsupportedOperationException();

    }

    @Override
    int getLoginTimeout() {
        throw new UnsupportedOperationException();
    }

    @Override
    void setLoginTimeout(int seconds) {
        throw new UnsupportedOperationException();
    }

    @Override
    Logger getParentLogger() {
        throw new UnsupportedOperationException();
    }

    @Override
    <T> T unwrap(Class<T> iface) {
        throw new UnsupportedOperationException();
    }

    @Override
    boolean isWrapperFor(Class<?> iface) {
        throw new UnsupportedOperationException();
    }

    private void createConnectionPool(String url, String user, String pwd) {
        def config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setConnectionTimeout(3000); //ms
        config.setIdleTimeout(60000); //ms
        config.setMaxLifetime(600000);//ms
        config.setAutoCommit(false);
        config.setMinimumIdle(5);
        config.setMaximumPoolSize(10);
        config.setPoolName("DemoHiPool");
        config.setRegisterMbeans(true);

        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        config.setUsername(user);
        config.setPassword(pwd);

        dataSourcePool = new HikariDataSource(config);
    }
}
