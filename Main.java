import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Estoque estoque = new Estoque();
        Scanner entrada = new Scanner(System.in);
        int opcao;
        String nome;
        double preco;
        int quantidade;
        int id;

        while (true) {
            System.out.println("\n========== MENU ==========");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Adicionar quantidade de um produto");
            System.out.println("3 - Remover quantidade de um produto");
            System.out.println("4 - Listar produtos");
            System.out.println("5 - Atualizar produto");
            System.out.println("6 - Remover produto");
            System.out.println("0 - Sair");
            System.out.println("==========================");
            opcao = entrada.nextInt();
            entrada.nextLine(); /* limpar o buffer para a próxima leitura de String */

            switch (opcao) {

                case 1:
                    System.out.printf("Nome: ");
                    nome = entrada.nextLine();

                    System.out.printf("Preço: ");
                    preco = entrada.nextDouble();

                    estoque.adicionarProdutoEstoque(nome, preco);
                    break;

                case 2:
                    System.out.printf("Digite o ID do produto que quer somar quantidade: ");
                    id = entrada.nextInt();

                    System.out.printf("Digite a quantidade que quer somar: ");
                    quantidade = entrada.nextInt();

                    estoque.adicionarQuantidadeProduto(id, quantidade);
                    break;

                case 3:
                    System.out.printf("Digite o ID do produto que quer subtrair quantidade: ");
                    id = entrada.nextInt();

                    System.out.printf("Digite a quantidade que quer subtrair: ");
                    quantidade = entrada.nextInt();

                    estoque.removerQuantidadeProduto(id, quantidade);
                    break;

                case 4:
                    estoque.listarProdutos();
                    break;

                case 5:
                    System.out.printf("Digite o ID do produto que quer atualizar: ");
                    id = entrada.nextInt();
                    entrada.nextLine(); /* limpar o buffer para a próxima leitura de String */

                    System.out.printf("Novo nome (-1 mantém): ");
                    nome = entrada.nextLine();

                    System.out.printf("Novo preço (-1 mantém): ");
                    preco = entrada.nextDouble();

                    System.out.printf("Nova quantidade (-1 mantém): ");
                    quantidade = entrada.nextInt();

                    estoque.atualizarProduto(id, nome, preco, quantidade);
                    break;

                case 6:
                    System.out.printf("Digite o ID do produto que quer remover: ");
                    id = entrada.nextInt();

                    estoque.removerProdutoEstoque(id);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}