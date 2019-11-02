package tech.marcusvieira.axoncqrsspringboot.services.queries.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;
import tech.marcusvieira.axoncqrsspringboot.services.queries.ClientQueryService;

@Service
public class ClientQueryServiceImpl implements ClientQueryService {

    private final EventStore eventStore;

    public ClientQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public List<Object> listEventsForClient(String clientId) {
        return eventStore.readEvents(clientId).asStream()
            .map(Message::getPayload)
            .collect(Collectors.toList());
    }
}
