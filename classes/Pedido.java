package classes;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Pedido {
    private int idPedido;
    private double quantidade;
    private double preco;
    private int status = 1;
    private Cliente cliente;
    private ArrayList<Produto> produtos = new ArrayList<>();

    //Getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
    //Métodos
    public void adicionarProduto(Produto p) {
        this.produtos.add(p);
    }
    
    public double getValorTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPrecoUnitario();
        }
        return total;
    }
    
    public void resetarProdutos() {
        for (Produto p : produtos) {
            p.setQuantidade(p.getQuantidade() + 1);
        }
        this.produtos.clear();
    }
    
    public String getStatusExtenso() {
        switch (this.status) {
            case 1: return "PENDENTE";
            case 2: return "FINALIZADO";
            case 3: return "CANCELADO";
            default: return "DESCONHECIDO";
        }
    }
    
    //Exibição
    @Override
    public String toString() {
        DecimalFormat dfm = new DecimalFormat(",##0.00");
        String texto = "--- PEDIDO #" + idPedido + " ---\n";
        texto += "Cliente: " + cliente.getNomeCliente() + "\n";
        texto += "Itens:\n";

        // Percorrendo a lista de produtos
        for (Produto p : produtos) {
            texto += " - " + p.getNomeProduto() + " | R$ " + dfm.format(p.getPrecoUnitario()) + "\n";
        }

        texto += "----------------------------\n";
        texto += "TOTAL DO PEDIDO: R$ " + getValorTotal() + "\n";

        return texto;
    }
}
