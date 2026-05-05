package classes;
public class Cliente{
    private int idCliente;
    private String nomeCliente;
    private String cpf;
    private boolean ativo = true; // Por padrão, todo cliente nasce ativo

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean isAtivo() { 
        return ativo;
    }
    
    public void setAtivo(boolean ativo) { 
        this.ativo = ativo;
    }

    //Exibição
    @Override
    public String toString() {
        String status = this.ativo ? "[ATIVO]" : "[INATIVO]";
        return String.format("Cliente: \n " + 
                "ID Cliente: "+ idCliente + " | Status: "+ status + "\n" +
                "Nome: "+ nomeCliente+ "\n"+
                "CPF: "+ cpf + "\n"+
                "-------------------------------");
    }
}
