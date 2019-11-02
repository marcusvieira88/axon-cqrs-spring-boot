package tech.marcusvieira.axoncqrsspringboot.events;

import tech.marcusvieira.axoncqrsspringboot.enums.Status;

public class ClientActivatedEvent extends BaseEvent<String> {

    private final Status status;

    public ClientActivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
