package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    // JPA 스펙 상 기본생성자가 필요함.
    protected Address() {
    }

    // Setter를 제공 안 하고 생성자 통해서 값을 전부 초기화 해서 변경 불가능 하게
    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
