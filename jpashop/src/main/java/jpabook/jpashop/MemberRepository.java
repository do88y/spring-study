package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

// Entity같은 걸 찾아주는,,
@Repository
public class MemberRepository {

    @PersistenceContext  // entity manager 주입해줌
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();  // command와 query를 분리
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
