package fr.mathip.databaseexample;

import fr.mathip.databaseexample.Database.DbConnection;
import fr.mathip.databaseexample.Database.DbManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Main extends JavaPlugin {
    private static Main instance;
    public DbManager dbManager;
    @Override
    public void onEnable() {
        instance = this;
        this.dbManager = new DbManager();
    }

    @Override
    public void onDisable() {
        try {
            this.dbManager.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Main getInstance() {
        return instance;
    }
}
