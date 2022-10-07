package com.kratonsolution.belian.security.access.role.impl.application;

import com.kratonsolution.belian.integration.api.Event;
import com.kratonsolution.belian.integration.api.EventHandler;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional(rollbackFor = Exception.class)
public class RoleModuleEventListener implements EventHandler {
    @Override
    public boolean canHandle(@NonNull String topic) {
        return topic.equalsIgnoreCase("access-module");
    }

    @Override
    public Mono<Void> handle(Event event) {

        switch (event.getType()) {
            case READ:
                event.getPayload().subscribe(s->log.info("handle create event {}", s));
                break;
        }

        return Mono.empty();
    }
}
