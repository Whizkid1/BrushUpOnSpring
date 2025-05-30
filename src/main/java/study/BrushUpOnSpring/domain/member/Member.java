package study.BrushUpOnSpring.domain.member;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Member {

    private Long id; // 내부 ID
    @NotEmpty
    private String loginId; // 사용자가 로그인 시 입력하는 ID
    @NotEmpty
    private String name;
    @NotEmpty
    private String password;
}
