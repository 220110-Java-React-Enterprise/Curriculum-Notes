import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public TestClass testClass(){
        return new TestClass();
    }

    @Bean
    public AspectClass aspectClass() {
        return new AspectClass();
    }


}
