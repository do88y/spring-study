package hello.hellospring;

//import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//  JPA 관련 코드
/*
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
*/

    private final MemberRepository memberRepository;

    // 인젝션 받으면 스프링 데이터 JPA가 구현체를 만들어놓은게 등록됨
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }



//     스프링 데이터 JPA 쓰면 스프링이 알아서 bean에 등록 해 줘서 필요 X
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();  // DB 연결 안 한 파일
//        return new JdbcMemberRepository(dataSource);  // 순수 JDBC 실행
//        return new JdbcTemplateMemberRepository(dataSource);  // JDBC 템플릿
//        return new JpaMemberRepository(em);
//    }

}


