package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();  // 하나라도 찾으면 그 값을 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());  // values가 Map에 있는 Member들임
    }

    public void clearStore() {  // 작업 수행한 뒤 비워주는 메서드
        store.clear();
    }

}
