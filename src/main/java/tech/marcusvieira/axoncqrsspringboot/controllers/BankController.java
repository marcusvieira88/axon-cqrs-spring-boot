package tech.marcusvieira.axoncqrsspringboot.controllers;

import io.swagger.annotations.Api;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.marcusvieira.axoncqrsspringboot.dtos.BankDTO;
import tech.marcusvieira.axoncqrsspringboot.services.commands.BankCommandService;
import tech.marcusvieira.axoncqrsspringboot.services.queries.BankQueryService;

@RestController
@RequestMapping(value = "/banks")
@Api(value = "Bank Queries")
public class BankController {

    private final BankCommandService bankCommandService;
    private final BankQueryService bankQueryService;

    public BankController(BankCommandService bankCommandService, BankQueryService bankQueryService) {
        this.bankCommandService = bankCommandService;
        this.bankQueryService = bankQueryService;
    }

    @PostMapping
    public CompletableFuture<String> createBank(@RequestBody BankDTO bankDTO) {
        return bankCommandService.createBank(bankDTO);
    }

    @GetMapping("/{bankId}/events")
    public List<Object> listEventsForBank(@PathVariable(value = "bankId") String bankId){
        return bankQueryService.listEventsForBank(bankId);
    }
}
