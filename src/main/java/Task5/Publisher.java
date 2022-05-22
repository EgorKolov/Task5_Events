package Task5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Publisher  {
    @Autowired
    private ApplicationEventPublisher publisher;
    
    private final Logger logger = LoggerFactory.getLogger(Publisher.class);
    
    public Publisher() {
        logger.info("Publisher is created");
    }
    
    @Transactional
    public void publishEvent(CustomEvent event) {
        logger.info(event.getType() + " event was published");
        publisher.publishEvent(event);
    }
}
