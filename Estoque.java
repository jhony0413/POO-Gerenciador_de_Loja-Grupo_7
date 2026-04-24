public class Estoque {
    private final int max_produto = 1000;
    private ProdutoEstoque[] listaprodutos = new ProdutoEstoque[max_produto];
    private int total = 0;

    public void adicionarProdutoEstoque(String nome, double preco) {
        if (total < max_produto) {
            Produto p = new Produto();
            p.setNome(nome);
            p.setPreco(preco);
            p.setId(total);

            ProdutoEstoque pe = new ProdutoEstoque();
            pe.setProduto(p);
            pe.setQuantidade(0);

            listaprodutos[total] = pe;
            total++;

            System.out.println("Produto adicionado com sucesso!");
            return;
        }
        System.out.println("Estoque cheio!");
    }

    public void adicionarQuantidadeProduto(int id, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Digite um valor positivo e maior que zero.");
            return;
        }

        int indice = buscarPorId(id);

        if (indice != -1) {
            listaprodutos[indice].setQuantidade(listaprodutos[indice].getQuantidade() + quantidade);

            System.out.printf("Quantidade adicionada!");
            return;
        }
        System.out.printf("Produto não encontrado.");
    }

    public void removerQuantidadeProduto(int id, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida! Digite um valor positivo maior que zero.");
            return;
        }

        int indice = buscarPorId(id);

        if (indice != -1) {
            listaprodutos[indice].setQuantidade(listaprodutos[indice].getQuantidade() - quantidade);
            if (listaprodutos[indice].getQuantidade() < 0) {
                listaprodutos[indice].setQuantidade(0);
            }
            System.out.printf("Quantidade removida!");
            return;
        }
        System.out.printf("Produto não encontrado.");
    }

    public void listarProdutos() {
        if (total == 0) {
            System.out.printf("Estoque vazio.");
            return;
        }

        for (int i = 0; i < total; i++) {
            System.out.printf("ID: %d | Nome: %s | Preço: %f | Quantidade: %d\n", listaprodutos[i].getProduto().getId(),
                    listaprodutos[i].getProduto().getNome(), listaprodutos[i].getProduto().getPreco(),
                    listaprodutos[i].getQuantidade());
        }
    }

    public int buscarPorId(int id) {
        for (int i = 0; i < total; i++) {
            if (listaprodutos[i].getProduto().getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void atualizarProduto(int id, String nome, double preco, int quantidade) {
        int indice = buscarPorId(id);

        if (indice != -1) {
            if (!nome.equals("-1"))
                listaprodutos[indice].getProduto().setNome(nome);
            if (preco != -1)
                listaprodutos[indice].getProduto().setPreco(preco);
            if (quantidade != -1)
                listaprodutos[indice].setQuantidade(quantidade);

            System.out.printf("Produto atualizado!");
            return;
        }
        System.out.printf("Produto não encontrado.");
    }

    public void removerProdutoEstoque(int id) {
        int indice = buscarPorId(id);

        if (indice != -1) {

            for (int j = indice; j < total - 1; j++) {
                listaprodutos[j] = listaprodutos[j + 1];
                listaprodutos[j].getProduto().setId(j);
            }

            listaprodutos[total - 1] = null;
            total--;

            System.out.printf("Produto removido!");
            return;
        }
        System.out.printf("Produto não encontrado.");
    }
}