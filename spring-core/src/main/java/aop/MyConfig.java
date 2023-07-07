package aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("aop")
@EnableAspectJAutoProxy //allow to use Spring AOP Aspect Proxy (middle-man)
public class MyConfig {
}
