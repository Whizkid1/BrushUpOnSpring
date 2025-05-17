package study.BrushUpOnSpring.web;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import study.BrushUpOnSpring.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

        private final MyLogger myLogger;
//    private final ObjectProvider<MyLogger> myLoggerProvider; //provider 기능 -> 프록시 방법 사용으로 주석
    public void logic(String id) {
//        MyLogger myLogger = myLoggerProvider.getObject(); // provider 추가로 코드 추가 -> 프록시 방법 사용으로 주석
        myLogger.log("service id = " + id);
    }
}
