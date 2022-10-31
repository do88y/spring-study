package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");  //애플리케이션 로딩 시점에 DB당 하나만 만들어놔야

        EntityManager em = emf.createEntityManager();  //트랜젝션의 단위마다 EntityManager 꼭 만들어줘야 함. 고객 요청 올 때마다 만들기

        EntityTransaction tx = em.getTransaction();  //getTransaction()-> 트랜젝션 얻는 것. JPA에서 트랜젝션 단위 굉장히 중요
        tx.begin();

        try {

            //저장
            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setTeam(team);
            em.persist(member);



            em.flush();
            em.clear();


            tx.commit();  //이 시점에 쿼리 날림
        } catch (Exception e) {
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();  //애플리케이션이 완전히 끝나면 entityManagerFactory를 닫아줘야 함

    }
}
