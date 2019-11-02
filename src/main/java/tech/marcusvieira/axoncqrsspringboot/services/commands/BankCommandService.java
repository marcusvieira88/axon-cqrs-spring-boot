package tech.marcusvieira.axoncqrsspringboot.services.commands;

import java.util.concurrent.CompletableFuture;
import tech.marcusvieira.axoncqrsspringboot.dtos.BankDTO;

public interface BankCommandService {

    CompletableFuture<String> createBank(BankDTO bankDTO);
}
