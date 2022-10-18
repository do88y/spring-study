package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository  //컴포넌트 스캔에 의해 자동으로 스프링 빈으로 등록됨
@RequiredArgsConstructor
public class MemberRepository {

//    @PersistenceContext  //jpa의 스프링이 생성 한 엔티티 매니저를 주입해 줌
    private final EntityManager em;

    public void save(Member member) {
        em.persist(member);  //em.persist(member);를 하면 영속성 컨텍스트에 member 객체를 올림
    }

    public Member findOne(Long id) {
        return em.find(Member.class, id);  // jpa가 제공하는 find()메서드-> 첫 번째 타입, 두 번째 pk
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)  //JPQL-> 엔티티 객체를 대상으로 쿼리를 함
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)  //파라미터를 바인딩 하는 것
                .setParameter("name", name)
                .getResultList();
    }

}
