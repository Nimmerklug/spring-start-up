package SpringAppTest.MusicExample;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Hungarian Rhapsody";
    }

    @PostConstruct
    private void init() {
        System.err.println("ClassicalMusic init(): init method");
    }

    @PreDestroy
    private void destroy() {
        System.err.println("ClassicalMusic destroy(): destroy method");
    }
}