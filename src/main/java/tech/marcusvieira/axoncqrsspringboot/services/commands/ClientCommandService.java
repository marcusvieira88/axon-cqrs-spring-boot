package tech.marcusvieira.axoncqrsspringboot.services.commands;

import java.util.concurrent.CompletableFuture;
import tech.marcusvieira.axoncqrsspringboot.dtos.ClientDTO;

public interface ClientCommandService {

    CompletableFuture<String> createClient(ClientDTO clientDTO);

    CompletableFuture<String> activateClient(String clientId);

    CompletableFuture<String> deactivateClient(String clientId);
}
