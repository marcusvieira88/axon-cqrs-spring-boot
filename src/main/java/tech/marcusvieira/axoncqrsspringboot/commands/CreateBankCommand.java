package tech.marcusvieira.axoncqrsspringboot.commands;

public class CreateBankCommand extends BaseCommand<String> {

    private final String name;

    public CreateBankCommand(String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
