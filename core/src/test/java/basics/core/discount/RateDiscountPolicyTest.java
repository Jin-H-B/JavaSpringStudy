package basics.core.discount;

import basics.core.member.Grade;
import basics.core.member.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 10% 할인 적용")
    void vip_o() {
        //given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 가 아닐 때")
    void vip_x() {
        //given
        Member member = new Member(2L, "memberBasic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);
        //then
        org.assertj.core.api.Assertions.assertThat(discount).isEqualTo(0);
    }
}