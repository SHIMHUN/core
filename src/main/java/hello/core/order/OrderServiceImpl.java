package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    /*주문이 오면*/
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        /*회원 조회*/
        Member member = memberRepository.findById(memberId);

        /*할인 정책에 처리과정 넘김*/
        int discountPrice = discountPolicy.discount(member, itemPrice);

        /*최종 생성된 주문 반환*/
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
