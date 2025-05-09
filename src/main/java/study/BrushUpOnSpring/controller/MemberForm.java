package study.BrushUpOnSpring.controller;

public class MemberForm {
    private String name; // html post input tag -> name 옵션의 value: "name" 과 mapping

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
