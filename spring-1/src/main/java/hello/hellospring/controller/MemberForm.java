package hello.hellospring.controller;

public class MemberForm {

    private String name; // members/createMemberForm의 name="name"과 매칭  / form 제출하면 Spring에서 setName 자동 호출

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
