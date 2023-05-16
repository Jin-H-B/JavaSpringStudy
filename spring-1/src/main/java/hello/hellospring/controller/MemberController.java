package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //데코 -> 주입된 서비스를 자동으로 가져다가 연결, 해당 서비스에 @Service 데코 해야함
    public MemberController(MemberService memberService) {

        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);
        System.out.println("member = " + member.getName());

        return "redirect:/"; //redirect 시킴
    }

    @GetMapping("/members") //Model model을 통해 db에 저장된 데이터를 controller를 통해 view로 넘기게 됨
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members); // "members"라는 이름으로 멤버 목록을 모델에 추가. 뷰에서 해당 데이터를 참조할 수 있게 됨.
        return "members/memberList";
    }
}
