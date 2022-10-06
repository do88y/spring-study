package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {  // Junit5부터 public 안 써도 됨
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();  // getBeanDefinitionNames()-> 스프링에 등록된 모든 빈 이름을 조회
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);  // getBean()->빈 이름으로 빈 객체(인스턴스) 조회 /타입 지정 안 해서 Object가 꺼내짐
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }
    }

    // 내가 등록한 빈만 출력해보기(스프링 자체 등록 빈 뺴고)
    @Test
    @DisplayName("모든 빈 출력하기")
    void findApplicationBean() {  // Junit5부터 public 안 써도 됨
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();  // getBeanDefinitionNames()-> 이걸로 꺼낼 수 있음
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);// getBeanDefinition()-> bean에 대한 정보

            // ROLE_APPLICATION-> 직접 등록한 애플리케이션 빈
            // ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanDefinitionName);  // 타입 지정 안 해서 Object가 꺼내짐
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }
    }
}
