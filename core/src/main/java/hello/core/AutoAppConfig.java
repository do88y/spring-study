package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @ComponentScan-> @Component 붙은 클래스들을 찾아서 자동으로 스프링 빈으로 등록 해 줌
@ComponentScan(
        // basePackages-> 탐색 할 위치를 지정. 모든 패키지 & 라이브러리를 다 뒤지려면 시간이 오래 걸리기 때문
//        basePackages = "hello.core.member",  // 지정하지 않으면-> 설정 정보 클래스의 패키지(hello.core)가 시작위치로 하위 패키지 다 뒤짐
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)  // 자동득록 뺄 것을 지정

)
public class AutoAppConfig {

/*
    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
*/
}
