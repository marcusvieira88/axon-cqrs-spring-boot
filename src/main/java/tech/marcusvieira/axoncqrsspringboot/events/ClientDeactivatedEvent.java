package tech.marcusvieira.axoncqrsspringboot.events;

import tech.marcusvieira.axoncqrsspringboot.enums.Status;

public class ClientDeactivatedEvent extends BaseEvent<String> {

    private final Status status;

    public ClientDeactivatedEvent(String id, Status status) {
        super(id);
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }
}
