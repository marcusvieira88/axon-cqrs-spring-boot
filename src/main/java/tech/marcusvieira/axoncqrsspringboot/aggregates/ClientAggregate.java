package tech.marcusvieira.axoncqrsspringboot.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import tech.marcusvieira.axoncqrsspringboot.commands.ActivateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.commands.CreateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.commands.DeactivateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.enums.Status;
import tech.marcusvieira.axoncqrsspringboot.events.ClientActivatedEvent;
import tech.marcusvieira.axoncqrsspringboot.events.ClientCreatedEvent;
import tech.marcusvieira.axoncqrsspringboot.events.ClientDeactivatedEvent;

@Aggregate
public class ClientAggregate {

    @AggregateIdentifier
    private String id;

    private String bankId;

    private String name;

    private Status status;

    public ClientAggregate() {
    }

    public ClientAggregate(String id, String bankId, String name, Status status) {
        this.id = id;
        this.bankId = bankId;
        this.name = name;
        this.status = status;
    }

    @CommandHandler
    public ClientAggregate(CreateClientCommand createClientCommand) {
        AggregateLifecycle
            .apply(new ClientCreatedEvent(createClientCommand.getId(), createClientCommand.getBankId(),
                createClientCommand.getName(), Status.CREATED));
    }

    @EventSourcingHandler
    protected void on(ClientCreatedEvent clientCreatedEvent) {
        this.id = clientCreatedEvent.getId();
        this.bankId = clientCreatedEvent.getBankId();
        this.name = clientCreatedEvent.getName();
        this.status = clientCreatedEvent.getStatus();
    }

    @CommandHandler
    public void on(ActivateClientCommand activateClientCommand) {
        AggregateLifecycle
            .apply(new ClientActivatedEvent(activateClientCommand.getId(), Status.ACTIVATED));
    }

    @EventSourcingHandler
    protected void on(ClientActivatedEvent clientActivatedEvent) {
        this.id = clientActivatedEvent.getId();
        this.status = clientActivatedEvent.getStatus();
    }

    @CommandHandler
    public void on(DeactivateClientCommand deactivateClientCommand) {
        AggregateLifecycle
            .apply(new ClientDeactivatedEvent(deactivateClientCommand.getId(), Status.DEACTIVATED));
    }

    @EventSourcingHandler
    protected void on(ClientDeactivatedEvent deactivatedEvent) {
        this.id = deactivatedEvent.getId();
        this.status = deactivatedEvent.getStatus();
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
