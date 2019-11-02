package tech.marcusvieira.axoncqrsspringboot.services.queries.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.Message;
import org.springframework.stereotype.Service;
import tech.marcusvieira.axoncqrsspringboot.services.queries.BankQueryService;

@Service
public class BankQueryServiceImpl implements BankQueryService {

    private final EventStore eventStore;

    public BankQueryServiceImpl(EventStore eventStore) {
        this.eventStore = eventStore;
    }

    @Override
    public List<Object> listEventsForBank(String bankId) {
        return eventStore.readEvents(bankId).asStream()
            .map(Message::getPayload)
            .collect(Collectors.toList());
    }
}
