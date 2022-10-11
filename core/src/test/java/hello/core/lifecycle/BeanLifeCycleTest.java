package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close();  // 닫는 메서드-> 기본 ApplicationContext가 제공하지 않고 그 하위로 내려가야 됨

    }

    @Configuration
    static class LifeCycleConfig {

        @Bean  //(initMethod = "init", destroyMethod = "close")  // destroyMethod는 기본 값이 (inferred)로 되어있어서 종료 메서드를 적지 않아도 자동 동작 됨
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }

}
