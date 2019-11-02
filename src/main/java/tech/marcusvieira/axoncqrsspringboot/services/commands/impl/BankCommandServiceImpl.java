package tech.marcusvieira.axoncqrsspringboot.services.commands.impl;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import tech.marcusvieira.axoncqrsspringboot.commands.CreateBankCommand;
import tech.marcusvieira.axoncqrsspringboot.dtos.BankDTO;
import tech.marcusvieira.axoncqrsspringboot.services.commands.BankCommandService;

@Service
public class BankCommandServiceImpl implements BankCommandService {

    private final CommandGateway commandGateway;

    public BankCommandServiceImpl(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public CompletableFuture<String> createBank(BankDTO bankDTO) {
        return commandGateway.send(new CreateBankCommand(UUID.randomUUID().toString(),
            bankDTO.getName()));
    }
}
