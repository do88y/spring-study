package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity  //@Entity 꼭 써줘야 jpa를 사용하는 거라고 인식
public class Member {

    @Id  //이게 pk라는걸 알려줌
    private Long id;
    private String name;

    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
