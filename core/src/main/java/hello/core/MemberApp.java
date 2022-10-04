package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {

        // 순수한 자바 코드로 검증 한 것. 한계가 있어서 junit으로 검증-> MemberServiceTest
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());

    }
}
