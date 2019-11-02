package tech.marcusvieira.axoncqrsspringboot.dtos;

public class ClientDTO {

    private String bankId;

    private String name;

    public ClientDTO(String bankId, String name) {
        this.bankId = bankId;
        this.name = name;
    }

    public String getBankId() {
        return bankId;
    }

    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
