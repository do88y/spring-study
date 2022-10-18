package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service  //컴포넌트 스캔 대상이 됨
//jpa의 모든 변경이나 로직들은 트랜젝션 안에서 되어야 함
@Transactional(readOnly = true)  //읽기 전용에 이걸 붙이면 성능 향상 됨
@RequiredArgsConstructor  //final 붙은 필드를 가지고 생성자 만들어 줌
public class MemberService {

    //final 붙이면 생성자 통해서 값이 설정 안 되었을 시 에러 뜨기 때문에 final 붙이는게 좋다
    private final MemberRepository memberRepository;

    //생성자인젝션 사용하는 것이 좋음(AUtowired 자동 붙음)
/*    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }*/

    /**
     * 회원 가입
     */
    @Transactional  //readOnly=false가 디폴트
    public Long join(Member member) {
        validateDuplicateMember(member);  //중복 회원 검증
        memberRepository.save(member);
        return member.getId();  //em.persist()로 영속성 컨텍스트에 등록되어 있기 때문에 항상 값이 있다는 것이 보장 됨
    }

    private void validateDuplicateMember(Member member) {  //동시에 가입하면 통과되는 경우가 있기 때문에 실무에서는 db에서 name을 unique로 잡기
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {  //멤버 수를 세서 비교한다던지 실제로는 좀 더 최적화 된 코드 고민
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
    //회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
