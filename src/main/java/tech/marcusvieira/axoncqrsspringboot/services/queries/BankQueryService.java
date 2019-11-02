package tech.marcusvieira.axoncqrsspringboot.services.queries;

import java.util.List;

public interface BankQueryService {

    List<Object> listEventsForBank(String bankId);
}
