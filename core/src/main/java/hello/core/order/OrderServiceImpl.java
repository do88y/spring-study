package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

import javax.sql.DataSource;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();  // 회원 찾기 위해
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  // 할인 정책 참고 위해
    
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 할인 정책은 discountPolicy한테 맡김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
