public class ConnectionParameters {
    private String database;
    private String port;
    private String host;
    private String user;
    private String table;
    private String password;

    public String getDatabase() { return database; }

    public String getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getUser() {
        return user;
    }

    public String getTable() {
        return table;
    }

    public String getPassword() {
        return password;
    }

    public String geturl() {
        return String.format("jdbc:postgresql://%s:%s/%s", this.host, this.port, this.database);
    }
}