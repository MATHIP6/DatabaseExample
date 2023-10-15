package fr.mathip.databaseexample.Database;

public class DbAccount {
    private String host;
    private String username;
    private String password;
    private String name;
    private int port;
    DbAccount(String host, String username, String password, String name, int port){
        this.host = host;
        this.username = username;
        this.password = password;
        this.name = name;
        this.port = port;
    }

    public String toUrl(){
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://").append(host).append(":").append(port).append("/").append(name).append("?characterEncoding=UTF-8");
        return sb.toString();
    }

    public String getHost() {
        return host;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
