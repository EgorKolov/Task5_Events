package Task5;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    @SneakyThrows
    public static void main(String[] args) {
        // Logged in info
        ConfigurableApplicationContext context = SpringApplication.run(Config.class, args);
    
        Publisher publisher = context.getBean(Publisher.class);
        // Type of event is specified in properties
        CustomEvent event = context.getBean(CustomEvent.class);
        publisher.publishEvent(event);
        
        // Waiting for a keypress
        System.in.read();
        context.close();
    }
}
