package basics.core;

import basics.core.member.Grade;
import basics.core.member.Member;
import basics.core.member.MemberService;
import basics.core.member.MemberServiceImpl;
import basics.core.order.Order;
import basics.core.order.OrderService;
import basics.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
