package tech.marcusvieira.axoncqrsspringboot.services.commands.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import tech.marcusvieira.axoncqrsspringboot.commands.ActivateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.commands.CreateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.commands.DeactivateClientCommand;
import tech.marcusvieira.axoncqrsspringboot.dtos.ClientDTO;
import tech.marcusvieira.axoncqrsspringboot.services.commands.ClientCommandService;

@Service
public class ClientCommandServiceImpl implements ClientCommandService {

    private final CommandGateway commandGateway;

    public ClientCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createClient(ClientDTO clientDTO) {
        return commandGateway.send(new CreateClientCommand(UUID.randomUUID().toString(),
            clientDTO.getBankId(), clientDTO.getName()));
    }

    @Override
    public CompletableFuture<String> activateClient(String clientId) {
        return commandGateway.send(new ActivateClientCommand(clientId));
    }

    @Override
    public CompletableFuture<String> deactivateClient(String clientId) {
        return commandGateway.send(new DeactivateClientCommand(clientId));
    }
}
