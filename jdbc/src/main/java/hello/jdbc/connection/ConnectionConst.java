package hello.jdbc.connection;

public abstract class ConnectionConst { //객체 생성 막기 위해 abstract로 막음
    public static final String URL = "jdbc:h2:tcp://localhost/~/test";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "";
}
