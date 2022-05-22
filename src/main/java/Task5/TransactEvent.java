package Task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
@Profile("transact")
public class TransactEvent extends CustomEvent {
    public Logger logger = LoggerFactory.getLogger(TransactEvent.class);
    @Value("${event.is_valid}")
    public boolean isValid;
    
    public TransactEvent(@Value("none") Object source, @Value("${event.content}") String content) {
        super(source, content);
        logger.info(getType() + " event was created");
    }
    
    @Override
    public String getType() {
        return "Transactional";
    }
}
