package jpabook.jpashop.domain.item;

import jpabook.jpashop.domain.Category;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")  // 싱글테이블이기 때문에 저장 할 때 DB 입장에서 구분이 필요
@Getter @Setter
public abstract class Item {  // 구현체를 가지고 할 거기 때문에 추상클래스로

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private  Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

}
