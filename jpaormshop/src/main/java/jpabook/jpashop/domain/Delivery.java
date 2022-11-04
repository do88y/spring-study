package jpabook.jpashop.domain;

import javax.persistence.*;
import javax.print.attribute.standard.OrientationRequested;

@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery")
    private Order order;

}
