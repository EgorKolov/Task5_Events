package Task5;

import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class Listener {
    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    
    public Listener() {
        logger.info("Listener is created");
    }
    
    @EventListener
    public void handleCommonEvent(CommonEvent event) {
        logger.info(event.getType() + " event was handled: " + event.getContent());
    }
    
    @SneakyThrows
    @Async
    @EventListener
    public void handleAsyncEvent(AsyncEvent event) {
        Thread.sleep(event.getDuration());
        logger.info(event.getType() + " event was handled: " + event.getContent());
    }
    
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void handleCustom(TransactEvent event) {
        if (event.isValid)
            logger.info(event.getType() + " event was handled: " + event.getContent());
    }
}
