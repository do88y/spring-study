package jpabook.jpashop.repository;

import jpabook.jpashop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {  //update와 비슷
        if (item.getId() == null) {  //jpa에 저장하기 전까지 id값이 없음(새로 생성 한 객체)
            em.persist(item);  //신규등록
        } else {
            em.merge(item);  //d에서 값을 가져온 것
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);

    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
