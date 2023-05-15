package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //데코 -> 주입된 서비스를 자동으로 가져다가 연결, 해당 서비스에 @Service 데코 해야함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
