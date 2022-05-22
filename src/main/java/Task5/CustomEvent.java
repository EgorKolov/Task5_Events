package Task5;

import org.slf4j.Logger;
import org.springframework.context.ApplicationEvent;

public abstract class CustomEvent extends ApplicationEvent {
    private final String content;
    
    public CustomEvent(Object source, String content) {
        super(source);
        this.content = content;
    }
    
    public String getContent() {
        return content;
    }
    abstract public String getType();
}
