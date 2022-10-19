package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)  //ORDINAL이 기본인데 쓰면X(숫자로 순서를 지정해서 중간에 추가되었을 경우 DB에서 순서가 밀림)
    private DeliveryStatus status;  // READY, COMP
}
