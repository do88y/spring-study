package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")  // 연관관계의 주인이 아님을 알려주는 것. order 테이블의 member 필드에 의해 매핑 된 것이라는 표현. 값을 넣어도 테이블이 변경되지 않음
    private List<Order> orders = new ArrayList<>();  // 컬렉션은 필드에서 초기화 하는 것이 안전.


}
