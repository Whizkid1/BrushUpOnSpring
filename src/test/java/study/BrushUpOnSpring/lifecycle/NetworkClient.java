package study.BrushUpOnSpring.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient {
// 인터페이스 InitializingBean, DisposableBean 사용
//public class NetworkClient implements InitializingBean, DisposableBean {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        // 객체 생성과 초기화 과정을 분리
        /*connect();
        call("초기화 연결 메세지");*/

    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }
    // 연결 완료 후 메세지 전송 기능
    public void call(String message) {
        System.out.println("call: " + url + " message = " + message);
    }
    // 서비스 종료 후 호출
    public void disConnect() {
        System.out.println("close: " + url);
    }

    // 인터페이스 InitializingBean, DisposableBean 사용
    /*@Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NetworkClient.afterPropertiesSet");
        connect();
        call("초기화 연결 메세지");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NetworkClient.destroy");
        disConnect();
    }*/

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disConnect();
    }
}
