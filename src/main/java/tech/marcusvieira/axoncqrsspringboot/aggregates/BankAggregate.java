package tech.marcusvieira.axoncqrsspringboot.aggregates;

import java.util.ArrayList;
import java.util.List;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;
import tech.marcusvieira.axoncqrsspringboot.commands.CreateBankCommand;
import tech.marcusvieira.axoncqrsspringboot.commands.CreateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.enums.Status;
import tech.marcusvieira.axoncqrsspringboot.events.BankCreatedEvent;
import tech.marcusvieira.axoncqrsspringboot.events.ClientCreatedEvent;

@Aggregate
public class BankAggregate {

    @AggregateIdentifier
    private String id;

    private String name;

    @AggregateMember
    private List<ClientAggregate> clients = new ArrayList<>();

    public BankAggregate() {
    }

    @CommandHandler
    public BankAggregate(CreateBankCommand bankCommand) {
        AggregateLifecycle
            .apply(new BankCreatedEvent(bankCommand.getId(), bankCommand.getName()));
    }

    @EventSourcingHandler
    protected void on(BankCreatedEvent bankCreatedEvent) {
        this.id = bankCreatedEvent.getId();
        this.name = bankCreatedEvent.getName();
    }

    @EventSourcingHandler
    protected void on(ClientCreatedEvent clientCreatedEvent) {
        clients.add(new ClientAggregate(clientCreatedEvent.getId(), clientCreatedEvent.getBankId(),
            clientCreatedEvent.getName(), Status.CREATED));
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClientAggregate> getClients() {
        return clients;
    }

    public void setClients(List<ClientAggregate> clients) {
        this.clients = clients;
    }
}