package tech.marcusvieira.axoncqrsspringboot.dtos;

public class BankDTO {

    private String name;

    public BankDTO() {
    }

    public BankDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
