package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 구현체에 뭐가 들어갈지 생성자를 통해 정함
    private final MemberRepository memberRepository;

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
}
