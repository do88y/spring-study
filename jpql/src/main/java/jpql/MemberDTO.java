package jpql;

public class MemberDTO {

    private String username;
    private int age;

    public String getUsername() {
        return username;
    }

    public MemberDTO(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
