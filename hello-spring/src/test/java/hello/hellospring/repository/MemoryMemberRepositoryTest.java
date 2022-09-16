package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 동작 끝날 떄 마다 수행하는 메서드-> 테스트는 의존관계 없이(순서 상관 없이) 설계 되어야 함.
    // 저장소나 공용데이터를 비워주지 않으면 작업 순서에 따라 에러 생길 가능성 있음
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        // findById메서드를 통해 id값을 가져오고 result 변수에 넣어 준 결과를 member와 같은지 비교
//        Assertions.assertEquals(member, result);  // (기대하는 값, 실제 값)
        assertThat(member).isEqualTo(result);  // Assertions는 alt + enter-> static import 하면 다음부터 안 써도 된다
    }

    @Test
    public void findByName() {

        // 정확성을 위해 객체 두 개를 만들어서 테스트
        Member member1 = new Member();
        member1.setName("spring1");  // member1에 spring1을 넣는다
        repository.save(member1);  // 저장

        Member member2 = new Member();
        member2.setName("spring2");  // member2에 spring2를 넣는다
        repository.save(member2);  // 저장

        Member result = repository.findByName("spring2").get();  // result에 findByName을 이용해서 spring1을 찾는다.

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
