package fr.mathip.databaseexample.Database;

import fr.mathip.databaseexample.Main;
import org.bukkit.entity.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private DbConnection dbConnection;

    public DbManager(){
        Main main = Main.getInstance();
        this.dbConnection = new DbConnection(new DbAccount(
                main.getConfig().getString("host"),
                main.getConfig().getString("username"),
                main.getConfig().getString("password"),
                main.getConfig().getString("database"),
                main.getConfig().getInt("port")));
    }

    public DbConnection getDbConnection() {
        return dbConnection;
    }

    public void close() throws SQLException {
        this.dbConnection.close();
    }

}

