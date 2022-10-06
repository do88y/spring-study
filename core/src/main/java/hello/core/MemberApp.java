package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        // 순수한 자바 코드로 검증 한 것. 한계가 있어서 junit으로 검증-> MemberServiceTest
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        // 이 코드를 넣으면 AppConfig의 환경설정 정보를 가지고 스프링이 스프링컨테이너에 등록하고 관리함
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);// 이름, 반환타입

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
