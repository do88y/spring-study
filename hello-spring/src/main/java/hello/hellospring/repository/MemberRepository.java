package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);  // 저장하는 기능
    Optional<Member> findById(Long id);  // 아이디로 찾는 기능
    Optional<Member> findByName(String name);  // 이름으로 찾는 기능
    List<Member> findAll();  // 전체 멤버수 검색

}
