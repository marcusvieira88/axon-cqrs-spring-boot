package tech.marcusvieira.axoncqrsspringboot.events;

public class BaseEvent<T> {

    private final T id;

    protected BaseEvent(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}
