package aop.aspect_oriented_programing.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("aop.aspect_oriented_programing.demo")
@EnableAspectJAutoProxy
public class BeanConfig {
}
