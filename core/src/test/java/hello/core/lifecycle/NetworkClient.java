package hello.core.lifecycle;

import javax.annotation.PostConstruct;  // javax-> 자바에서 공식 지원
import javax.annotation.PreDestroy;

public class NetworkClient {

    private String url;  // 접속해야할 서버의 url

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connct: " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("close: " + url);
    }

    @PostConstruct
    public void init() throws Exception {  // 의존관계 주입 끝나면 실행
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
        
    }
    @PreDestroy
    public void close() throws Exception {  // 빈이 종료되기 전에 실행
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
