package tech.marcusvieira.axoncqrsspringboot.events;

public class BankCreatedEvent extends BaseEvent<String> {

    private final String name;

    public BankCreatedEvent(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
