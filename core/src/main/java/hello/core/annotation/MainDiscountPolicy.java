package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

// Qualifier등록 시 문자열에 오타가 날 수 있는데 애너테이션을 만들어서 사용하면 옹타 시 컴파일 오류가 나기 때문에 오류를 잡기 쉬움
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {


}