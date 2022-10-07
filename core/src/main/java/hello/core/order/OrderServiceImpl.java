package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

import javax.sql.DataSource;

public class OrderServiceImpl implements OrderService {

    // final은 무조건 생성자를 통해 할당되어야 함
    private final MemberRepository memberRepository;  // 회원 찾기 위해
    private final DiscountPolicy discountPolicy;  // 구체에 의존하지 않고 추상에만 의존-> NullPointerExeption
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();  // 할인 정책 참고 위해
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  // 바뀐 할인정책 적용-> OrderServiceImpl의 코드를 바꿔야 함-> OCP위반

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);  // 할인 정책은 discountPolicy한테 맡김

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
