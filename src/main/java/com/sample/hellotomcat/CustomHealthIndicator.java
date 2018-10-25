package com.sample.hellotomcat;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

    private boolean isShutDownTriggered=false;

    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        
        if(isShutDownTriggered) {
            builder.down();
        } else {
            builder.up();
        }
    }

    public void setIsShutDownTriggered(boolean isShutDownTriggered) {
        this.isShutDownTriggered = isShutDownTriggered;
    }

    public boolean getIsShutDownTriggered() {
        return isShutDownTriggered;
    }
}