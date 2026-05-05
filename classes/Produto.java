package classes;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Produto {
    private int idProduto;
    private String nomeProduto;
    private double precoUnitario;
    private String categoria;
    private Date dataValid;
    private int quantidade;

    //Getters e Setters
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
      
    public String getNomeProduto() {
        return nomeProduto; 
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataValid() {
        return dataValid;
    }

    public void setDataValid(Date dataValid) {
        this.dataValid = dataValid;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    //Exibição
    @Override
    public String toString() {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            DecimalFormat dfm = new DecimalFormat(",##0.00");
        return "Produto: \n" +
                "Id do Produto: "+ idProduto+ "\n"+
                "Nome: "+ nomeProduto+ "\n"+
                "Preço Unitario: "+ dfm.format(getPrecoUnitario())+ "\n"+
                "Categoria: "+categoria+ "\n"+
                "Data de Validade:"+ df.format(getDataValid())+"\n"+
                "Quantidade : "+quantidade+" \n"+
                "-------------------------------";
    }
    
}
