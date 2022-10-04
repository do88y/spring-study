package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 메모리에 회원이 저장되는 클래스
    private static Map<Long, Member> store = new HashMap<>();  // 실무에서는 ConcurrentHashMap을 써야함

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
