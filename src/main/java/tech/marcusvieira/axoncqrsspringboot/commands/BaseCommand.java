package tech.marcusvieira.axoncqrsspringboot.commands;


import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseCommand<T> {

    @TargetAggregateIdentifier
    private final T id;

    protected BaseCommand(T id) {
        this.id = id;
    }

    public T getId() {
        return id;
    }
}

