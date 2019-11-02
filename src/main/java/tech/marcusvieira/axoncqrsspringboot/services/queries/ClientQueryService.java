package tech.marcusvieira.axoncqrsspringboot.services.queries;

import java.util.List;

public interface ClientQueryService {

    List<Object> listEventsForClient(String client);
}
