package tech.marcusvieira.axoncqrsspringboot.controllers;

import io.swagger.annotations.Api;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.marcusvieira.axoncqrsspringboot.dtos.ClientDTO;
import tech.marcusvieira.axoncqrsspringboot.services.commands.ClientCommandService;
import tech.marcusvieira.axoncqrsspringboot.services.queries.ClientQueryService;

@RestController
@RequestMapping(value = "/clients")
@Api(value = "Client Queries")
public class ClientController {

    private final ClientCommandService clientCommandService;
    private final ClientQueryService clientQueryService;

    public ClientController(ClientCommandService clientCommandService,
        ClientQueryService clientQueryService) {
        this.clientCommandService = clientCommandService;
        this.clientQueryService = clientQueryService;
    }

    @PostMapping
    public CompletableFuture<String> createClient(@RequestBody ClientDTO clientDTO) {
        return clientCommandService.createClient(clientDTO);
    }

    @PutMapping(path = "/{clientId}/activate")
    public CompletableFuture<String> activateClient(@PathVariable(value = "clientId") String clientId) {
        return clientCommandService.activateClient(clientId);
    }

    @PutMapping(path = "/{clientId}/deactivate")
    public CompletableFuture<String> deactivateClient(@PathVariable(value = "clientId") String clientId) {
        return clientCommandService.deactivateClient(clientId);
    }

    @GetMapping("/{clientId}/events")
    public List<Object> listEventsForClient(@PathVariable(value = "clientId") String clientId) {
        return clientQueryService.listEventsForClient(clientId);
    }
}
