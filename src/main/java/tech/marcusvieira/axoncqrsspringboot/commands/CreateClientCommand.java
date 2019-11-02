package tech.marcusvieira.axoncqrsspringboot.commands;

public class CreateClientCommand extends BaseCommand<String> {

    private final String bankId;

    private final String name;

    public CreateClientCommand(String id, String bankId, String name) {
        super(id);
        this.bankId = bankId;
        this.name = name;
    }

    public String getBankId() {
        return bankId;
    }

    public String getName() {
        return name;
    }
}
