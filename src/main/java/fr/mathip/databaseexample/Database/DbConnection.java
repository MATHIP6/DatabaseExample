package fr.mathip.databaseexample.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private DbAccount dbAccount;
    private Connection connection;
    public DbConnection(DbAccount dbAccount){
        this.dbAccount = dbAccount;
    }
    public void Connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(this.dbAccount.toUrl(), this.dbAccount.getUsername(), this.dbAccount.getPassword());
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void close() throws SQLException {
        if (this.connection != null){
            if (!this.connection.isClosed()){
                this.connection.close();
            }
        }
    }
    public Connection getConnection() throws SQLException {
        if (this.connection != null){
            if (!this.connection.isClosed()){
                return this.connection;
            }
        }
        Connect();
        return this.connection;
    }

}

