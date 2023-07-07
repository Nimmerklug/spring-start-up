package SpringAppTest.MusicExample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("SpringAppTest.MusicExample")
@PropertySource("classpath:musicPlayer.properties")
public class MusicConfig {
    @Bean
    public JazzMusic jazzMusic() {
        return new JazzMusic();
    }
}
