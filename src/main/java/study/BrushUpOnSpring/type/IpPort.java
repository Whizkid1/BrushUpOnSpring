package study.BrushUpOnSpring.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode // 설명 이해가... 좀 더 찾아보자 -> 아아.. equals 재정의를 @로 자동 설정 (필드 멤버 비교를 통한 객체 비교 대체)
public class IpPort {

    private String ip;
    private int port;

    public IpPort(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }
}
