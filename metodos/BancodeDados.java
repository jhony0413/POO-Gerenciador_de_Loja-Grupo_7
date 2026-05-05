package metodos;
import java.util.ArrayList;
import classes.Produto;
import classes.Cliente;
import classes.Pedido;
public class BancodeDados {
    //Criação dos Array
    private static final ArrayList<Produto> estoque = new ArrayList();
    private static final ArrayList<Cliente> clientes = new ArrayList();
    private static final ArrayList<Pedido> pedidos = new ArrayList();
    
    // Contadores globais
    private static int ultimoIdCliente = 0;
    private static int ultimoIdProduto = 0;
    private static int ultimoIdPedido = 0;

    // Métodos para gerar novo ID
    public static int gerarNovoIdCliente() {
        return ++ultimoIdCliente;
    }
    public static int gerarNovoIdProduto() {
        return ++ultimoIdProduto;
    }
    public static int gerarNovoIdPedido() {
        return ++ultimoIdPedido;
    }
    
    //Processo de Listagem
    public static ArrayList<Produto> getProdutos(){
        return estoque;}
    public static ArrayList<Cliente> getClientes(){
        return clientes;}
    public static ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
    
    //Processo de Criação
    public static void adicionarProduto(Produto produto){
        estoque.add(produto);
    }
    public static void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public static void adicionarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
    
    //Processo de Atualização
    public static boolean atualizarProdutos(int indice){
        if(indice < 0 || indice >= estoque.size()){
            return false;
        }
        return true;
    }
    
    //Processo de Exclusão ou Desativação
    public static boolean excluirProdutos(int indice){
        if(indice < 0 || indice >= estoque.size()){
            return false;
        }
        estoque.remove(indice);
        return true;
    }
    public static boolean desativarClientes(int indice){
        if(indice < 0 ||indice >= clientes.size()){
            return false;
        }
        clientes.get(indice).setAtivo(false);
        return true;
    }  
    public static boolean excluirPedidos(int indice){
        if(indice < 0 ||indice >= pedidos.size()){
            return false;
        }
        pedidos.remove(indice);
        return true;
    }
}
