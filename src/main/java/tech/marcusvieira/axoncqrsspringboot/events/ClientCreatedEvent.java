package tech.marcusvieira.axoncqrsspringboot.events;

import tech.marcusvieira.axoncqrsspringboot.enums.Status;

public class ClientCreatedEvent extends BaseEvent<String> {

    private String bankId;
    private String name;
    private final Status status;

    public ClientCreatedEvent(String id, String bankId, String name, Status status) {
        super(id);
        this.bankId = bankId;
        this.name = name;
        this.status = status;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }
}
