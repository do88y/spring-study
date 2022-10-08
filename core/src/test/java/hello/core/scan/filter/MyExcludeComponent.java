package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
// 이 애너테이션이 붙은 건 컴포넌트 스캔에 제외 할 거라는 뜻
public @interface MyExcludeComponent {

}
