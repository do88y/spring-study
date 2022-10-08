package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    // 구현체에 뭐가 들어갈지 생성자를 통해 정함
    private final MemberRepository memberRepository;

    // @Autowired-> 자동 의존관계 주입 애너테이션 생성자에 붙여주면 스프링이 MemberRepository에 맞는 타입을 찾아와서 자동연결 해 줌
    @Autowired  // ac.getBean(MemberRepository.class)와 같은 역할
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
