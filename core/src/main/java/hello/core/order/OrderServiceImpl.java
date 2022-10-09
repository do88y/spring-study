package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor  // 필드를 final이 붙은 필드를 파라미터로 받는 생성자를 자동으로 만들어 줌
public class OrderServiceImpl implements OrderService {

    // final은 무조건 생성자를 통해 할당되어야 함
    private final MemberRepository memberRepository;  // 회원 찾기 위해
    private final DiscountPolicy discountPolicy;  // 구체에 의존하지 않고 추상에만 의존-> NullPointerExeption

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
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
