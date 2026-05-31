package banco.model;

public class Cliente {
    private String nome;
    private String cpf;
    private String telefone;

    public Cliente(String nome, String cpf, String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String setNome(String nome) {
        this.nome = nome;
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String setCpf(String cpf) {
        this.cpf = cpf;
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String setTelefone(String telefone) {
        this.telefone = telefone;
        return telefone;
    }
    
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", telefone='" + telefone + '\'' +
                '}';
    }
}
