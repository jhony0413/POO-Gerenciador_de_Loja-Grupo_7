package telas;
import java.text.SimpleDateFormat;
import metodos.Tela;
import metodos.BancodeDados;
import classes.Produto;
import classes.Cliente;
import classes.Pedido;
import java.text.DecimalFormat;
import java.util.ArrayList;
public class Menu {
    public static void main(String[] args) {
        String opcoes = "Selecione uma das opções abaixo"+'\n'+
                "----------------------------------------\n"
                + "1 - Opções de Cliente \n"
                + "2 - Opções de Produto \n"
                + "3 - Opções de Pedido \n"
                + "0 - Sair";
        
        String opcoesCliente = "Selecione uma das opções abaixo"+'\n'+
                "----------------------------------------\n"
                + "1 - Cadrastrar Cliente \n"
                + "2 - Listar Cliente \n"
                + "3 - Atualizar Cliente \n"
                + "4 - Desativar Cliente \n"
                + "5 - Reativar Cliente \n"
                + "0 - Sair";
        
        String opcoesProduto = "Selecione uma das opções abaixo"+'\n'+
                "----------------------------------------\n"
                + "1 - Cadrastrar Produto \n"
                + "2 - Listar Produto \n"
                + "3 - Atualizar Produto \n"
                + "4 - Excluir Produto \n"
                + "0 - Sair";
        
        String opcoesPedido = "Selecione uma das opções abaixo"+'\n'+
                "----------------------------------------\n"
                + "1 - Cadrastrar Pedido \n"
                + "2 - Listar Pedido \n"
                + "3 - Atualizar Pedido \n"
                + "4 - Cancelar Pedido \n"
                + "5 - Finalizar Pedido (Venda)\n"
                + "0 - Sair";
        
        int opcaoSelecionada;
        do{
            opcaoSelecionada = Tela.nextInt(opcoes);
            switch(opcaoSelecionada){
                case 1: 
                        int opcaoSelecionadaCliente;
                        do{
                            opcaoSelecionadaCliente = Tela.nextInt(opcoesCliente);
                            switch(opcaoSelecionadaCliente){
                                case 1: CadastrarCliente();break;
                                case 2: ListarCliente();break;
                                case 3: AtualizarCliente();break;
                                case 4: DesativarCliente();break;
                                case 5: ReativarCliente();break;
                                case  0: Tela.exibirMensagem("Voltando...");break;
                                default : Tela.exibirMensagem("Opção Inválida!");
                            }
                        }while(opcaoSelecionadaCliente != 0);
                        break;
                case 2: 
                        int opcaoSelecionadaProduto;
                        do{
                            opcaoSelecionadaProduto = Tela.nextInt(opcoesProduto);
                            switch(opcaoSelecionadaProduto){
                                case 1: CadastrarProduto();break;
                                case 2: ListarProduto();break;
                                case 3: AtualizarProduto();break;
                                case 4: ExcluirProduto();break;
                                case  0: Tela.exibirMensagem("Voltando...");break;
                                default : Tela.exibirMensagem("Opção Inválida!");
                            }
                        }while(opcaoSelecionadaProduto != 0);
                        break;
                case 3: 
                        int opcaoSelecionadaPedido;
                           do{
                               opcaoSelecionadaPedido = Tela.nextInt(opcoesPedido);
                               switch(opcaoSelecionadaPedido){
                                   case 1: CadastrarPedido();break;
                                   case 2: ListarPedido();break;
                                   case 3: AtualizarPedido();break;
                                   case 4: CancelarPedido();break;
                                   case 5: FinalizarPedido(); break;
                                   case  0: Tela.exibirMensagem("Voltando...");break;
                                   default : Tela.exibirMensagem("Opção Inválida!");
                               }
                           }while(opcaoSelecionadaPedido != 0);
                           break;
                case  0: Tela.exibirMensagem("Volte sempre!!!");break;
                default : Tela.exibirMensagem("Opção Inválida!");
            }
        }while(opcaoSelecionada != 0);
        
        
    }    
    //Funções de Crud do Cliente
    public static void CadastrarCliente(){
        Cliente c = new Cliente();
        c.setIdCliente(BancodeDados.gerarNovoIdCliente());
        c.setNomeCliente(Tela.nextString("Digite o nome do Cliente"));
        c.setCpf(Tela.nextString("Digite o CPF"));
        BancodeDados.adicionarCliente(c);
        Tela.exibirMensagem("Cliente inserido com sucesso!");
    }
    public static void ListarCliente(){
        if (BancodeDados.getClientes().isEmpty()){
            Tela.exibirMensagem("Nenhum Cliente cadrastado!");
            return;
        }

        String menuFiltro = "Deseja listar quais clientes?\n" +
                            "1 - Apenas Ativos no sistema\n" +
                            "2 - Apenas Inativos no sistema\n" +
                            "3 - Todos os Clientes";
        
        int filtro = Tela.nextInt(menuFiltro);
        String lista = "";
            for (Cliente c : BancodeDados.getClientes()) {
                if (filtro == 3 || (filtro == 1 && c.isAtivo()) || (filtro == 2 && !c.isAtivo())) {
                    lista += c.toString() + "\n";
                }
            }
            
        if (lista.equals("")) {
            Tela.exibirMensagem("Nenhum cliente encontrado com este status.");
        } else {
            Tela.exibirMensagem("--- RESULTADO DA BUSCA ---\n\n" + lista);
        }
    }
    public static void AtualizarCliente(){
        ArrayList<Cliente> listaClientes = BancodeDados.getClientes();
        if (listaClientes.isEmpty()){
            Tela.exibirMensagem("Nenhum cliente cadrastado!");
            return;
        }

        String lista= "Informe o código do Cliente para atualizar: \n";
        boolean encontrouAtivo = false;
        
        for (int i = 0; i < listaClientes.size(); i++) {
            if (listaClientes.get(i).isAtivo()) {
                lista += (i + 1) + " - " + listaClientes.get(i).getNomeCliente() + "\n";
                encontrouAtivo = true;
            }
        }
        
        if (!encontrouAtivo) {
            Tela.exibirMensagem("Não há clientes ativos para atualizar!");
            return;
        }
        
        int codigo = Tela.nextInt(lista);
        int indice = codigo - 1;
            if (indice >= 0 && indice < listaClientes.size() && listaClientes.get(indice).isAtivo()) {
                Cliente c = listaClientes.get(indice);
                c.setNomeCliente(Tela.nextString("Digite o novo nome do Cliente (Atual: " + c.getNomeCliente() + ")"));
                c.setCpf(Tela.nextString("Digite o novo CPF (Atual: " + c.getCpf() + ")"));
                Tela.exibirMensagem("Cliente atualizado com sucesso!");
            } else {
                Tela.exibirMensagem("Código inválido ou cliente desativado!"); 
            }
    }
    public static void DesativarCliente() {
        ArrayList<Cliente> listaClientes = BancodeDados.getClientes();
        ArrayList<Pedido> listaPedidos = BancodeDados.getPedidos();

        if (listaClientes.isEmpty()) {
            Tela.exibirMensagem("Nenhum cliente cadastrado!");
            return;
        }

        String lista = "Selecione o Cliente que deseja DESATIVAR: \n";
        for (int i = 0; i < listaClientes.size(); i++) {
            Cliente c = listaClientes.get(i);
            String status = c.isAtivo() ? "[Ativo]" : "[Inativo]";
            lista += (i + 1) + " - " + c.getNomeCliente() + " " + status + "\n";
        }

        int codigo = Tela.nextInt(lista);
        int indice = codigo - 1;

        if (indice >= 0 && indice < listaClientes.size()) {
            Cliente clienteSelecionado = listaClientes.get(indice);

            // 1. Verifica se já está inativo
            if (!clienteSelecionado.isAtivo()) {
                Tela.exibirMensagem("Este cliente já está desativado!");
                return;
            }

            // 2. Verifica pedidos pendentes
            boolean temPendencia = false;
            for (Pedido p : listaPedidos) {
                if (p.getCliente().getCpf().equals(clienteSelecionado.getCpf()) && p.getStatus() == 1) {
                    temPendencia = true;
                    break;
                }
            }

            if (temPendencia) {
                Tela.exibirMensagem("Não é possível desativar: Cliente possui Pedidos PENDENTES!");
            } else {
                BancodeDados.desativarClientes(indice);
                Tela.exibirMensagem("Cliente " + clienteSelecionado.getNomeCliente() + " foi desativado com sucesso!");
            }

        } else if (codigo != 0) {
            Tela.exibirMensagem("Código Inválido!");
        }
    }
    public static void ReativarCliente(){
        ArrayList<Cliente> listaClientes = BancodeDados.getClientes();

        if (listaClientes.isEmpty()) {
            Tela.exibirMensagem("Nenhum cliente cadastrado!");
            return;
        }
        String cpfBusca = Tela.nextString("Digite o CPF do cliente que deseja reativar:");

        Cliente clienteEncontrado = null;
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpfBusca)) {
                clienteEncontrado = c;
                break;
            }
        }
        

        if (clienteEncontrado == null) {
            Tela.exibirMensagem("Cliente com CPF " + cpfBusca + " não encontrado.");
        } else if (clienteEncontrado.isAtivo()) {
            Tela.exibirMensagem("O cliente " + clienteEncontrado.getNomeCliente() + " já está ATIVO.");
        } else {
            clienteEncontrado.setAtivo(true);
            Tela.exibirMensagem("Cliente " + clienteEncontrado.getNomeCliente() + " reativado com sucesso!");
        }
    }
    
    //Funções de Crud do Produto
    public static void CadastrarProduto(){
        Produto p = new Produto();
        p.setIdProduto(BancodeDados.gerarNovoIdProduto());
        p.setNomeProduto(Tela.nextString("Digite o nome do Produto"));
        p.setPrecoUnitario(Tela.nextDouble("Digite o preço unitário do Produto"));
        p.setCategoria(Tela.nextString("Digite a categoria do Produto"));
        p.setDataValid(Tela.nextDate("Digite a data de validade - ex(05/03/2026)"));
        p.setQuantidade(Tela.nextInt("Digite a quantidade"));
        BancodeDados.adicionarProduto(p);
        Tela.exibirMensagem("Produto inserido com sucesso");
    }
    public static void ListarProduto(){
        if(BancodeDados.getProdutos().isEmpty()){
            Tela.exibirMensagem("Nenhum Produto cadastrado");
        }else{
            String lista="";
            for(Produto p : BancodeDados.getProdutos()){
                lista += p.toString() + "\n";
            }
            Tela.exibirMensagem(lista);
        }
    }
    public static void AtualizarProduto(){
        ArrayList<Produto> listaProdutos = BancodeDados.getProdutos();
        if (listaProdutos.isEmpty()) {
            Tela.exibirMensagem("Nenhum produto cadastrado!");
        }else{
            String lista= "Informe o código do Produto para atualizar: \n";
            for (int i = 0; i < listaProdutos.size(); i++) {
                lista +=  (i+1) +" - "+ listaProdutos.get(i).getNomeProduto()+"\n";
            }
            int codigo = Tela.nextInt(lista);
            int indice = codigo - 1;
            if(BancodeDados.atualizarProdutos(indice)){
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                DecimalFormat dfm = new DecimalFormat(",##0.00");
                Produto p = listaProdutos.get(indice);
                p.setNomeProduto(Tela.nextString("Digite o novo nome do Produto (Atual: " + p.getNomeProduto() + ")"));
                p.setPrecoUnitario(Tela.nextDouble("Digite o novo Preço Unitário (Atual: " + dfm.format(p.getPrecoUnitario()) + ")"));
                p.setCategoria(Tela.nextString("Digite a nova categoria do Produto (Atual: " + p.getCategoria() + ")"));
                p.setDataValid(Tela.nextDate("Digite a nova data de validade (Atual: " + df.format(p.getDataValid()) + ")"));
                p.setQuantidade(Tela.nextInt("Digite a nova quantidade (Atual: " + p.getQuantidade() + ")"));
            
                Tela.exibirMensagem("Produto atualizado com sucesso!");
            }else{
                Tela.exibirMensagem("Código inválido!");
            }
        }
    }
    public static void ExcluirProduto(){ 
        ArrayList<Produto> produto = BancodeDados.getProdutos();
        if(produto.isEmpty()){
            Tela.exibirMensagem("Nenhum Produto Cadastrado!");
        }else{
            String lista = "Informe o código do Produto para excluir: \n";
            for(int i =0; i< produto.size(); i++){
                lista+= (i+1) + "-" + produto.get(i).getNomeProduto()+"\n";
            }
            int codigo= Tela.nextInt(lista);
            if(BancodeDados.excluirProdutos(codigo-1)){
                Tela.exibirMensagem("Produto excluido com sucesso!");
            }else if(codigo!=0){
                Tela.exibirMensagem("Código Inválido");
            }
        }
    }

    //Funções de Crud do Pedido
    public static void CadastrarPedido() {
        if (BancodeDados.getClientes().isEmpty() || BancodeDados.getProdutos().isEmpty()) {
            Tela.exibirMensagem("Para criar um pedido, é necessário ter clientes e produtos cadastrados!");
            return;
        }

        Pedido p = new Pedido();
        p.setIdPedido(BancodeDados.gerarNovoIdPedido());

        //Selecionar o Cliente
        String listaClientes = "Selecione o Cliente:\n";
        for(int i = 0; i <BancodeDados.getClientes().size(); i++) {
            listaClientes += (i+1) + " - " + BancodeDados.getClientes().get(i).getNomeCliente() + "\n";
        }
        int idCliente = Tela.nextInt(listaClientes) - 1;
        p.setCliente(BancodeDados.getClientes().get(idCliente));

        //Adicionar os Produtos (Loop)
        int opcao;
        DecimalFormat dfm = new DecimalFormat(",##0.00");
        do {
            String listaProdutos = "Selecione um produto (0 para finalizar):\n";
            for(int i=0; i<BancodeDados.getProdutos().size(); i++) {
                Produto prod = BancodeDados.getProdutos().get(i);
                listaProdutos += (i+1) + " - " + prod.getNomeProduto() + 
                                 " | Estoque: " + prod.getQuantidade() + 
                                 " | R$" + dfm.format(prod.getPrecoUnitario()) + "\n";
            }
            opcao = Tela.nextInt(listaProdutos);

            if (opcao > 0 && opcao <= BancodeDados.getProdutos().size()) {
                Produto pSelecionado = BancodeDados.getProdutos().get(opcao-1);
            
                // LÓGICA DE VALIDAÇÃO: Verifica se tem estoque
                if (pSelecionado.getQuantidade() > 0) {
                    p.adicionarProduto(pSelecionado);

                    // Realiza a baixa no estoque
                    pSelecionado.setQuantidade(pSelecionado.getQuantidade() - 1);

                    //Tela.exibirMensagem("Produto adicionado! Estoque atualizado.");
                } else {
                    Tela.exibirMensagem("Produto esgotado! Selecione outro.");
                }
            }
        } while (opcao != 0);
        BancodeDados.adicionarPedido(p);
        Tela.exibirMensagem("Pedido criado com sucesso! Total: R$" + dfm.format(p.getValorTotal()));
    }
    public static void ListarPedido() {
        if (BancodeDados.getPedidos().isEmpty()) {
            Tela.exibirMensagem("Nenhum pedido no sistema.");
            return;
        }

        String menuFiltro = "Deseja listar quais pedidos?\n" +
                            "1 - Apenas Pendentes\n" +
                            "2 - Apenas Finalizados\n" +
                            "3 - Apenas Cancelados\n" +
                            "4 - Todos os Pedidos";

        int filtro = Tela.nextInt(menuFiltro);
        String lista = "";

        for (Pedido p : BancodeDados.getPedidos()) {
            // Se filtro for 4, mostra tudo. Se não, verifica se o status coincide.
            if (filtro == 4 || p.getStatus() == filtro) {
                lista += p.toString() + " STATUS: " + p.getStatusExtenso() + "\n\n";
            }
        }

        if (lista.equals("")) {
            Tela.exibirMensagem("Nenhum pedido encontrado com este status.");
        } else {
            Tela.exibirMensagem(lista);
        }
    }
    public static void AtualizarPedido() {
        ArrayList<Pedido> listaPedidos = BancodeDados.getPedidos();

        if (listaPedidos.isEmpty()){
            Tela.exibirMensagem("Nenhum pedido cadastrado!");
            return;
        }
        String cpfBusca = Tela.nextString("Digite o CPF do cliente para localizar o pedido:");

        ArrayList<Pedido> pedidosDoCliente = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getCliente().getCpf().equals(cpfBusca) && p.getStatus() == 1) {
                pedidosDoCliente.add(p);
            }
        }
        if (pedidosDoCliente.isEmpty()) {
            Tela.exibirMensagem("Nenhum pedido pendente encontrado para este CPF.");
            return;
        }

        Pedido pedidoSelecionado = null;

        if (pedidosDoCliente.size() > 1) {
            String menuPedidos = "O cliente possui vários pedidos. Selecione qual deseja atualizar:\n";
            for (int i = 0; i < pedidosDoCliente.size(); i++) {
                menuPedidos += (i + 1) + " - Pedido #" + pedidosDoCliente.get(i).getIdPedido() + 
                               " | Total: R$" + pedidosDoCliente.get(i).getValorTotal() + "\n";
            }
            int escolha = Tela.nextInt(menuPedidos) - 1;
            if (escolha >= 0 && escolha < pedidosDoCliente.size()) {
                pedidoSelecionado = pedidosDoCliente.get(escolha);
            }
        } else {
            pedidoSelecionado = pedidosDoCliente.get(0);
        }

       

        if (pedidoSelecionado != null) {
             if (pedidoSelecionado.getStatus() != 1) {
                Tela.exibirMensagem("Erro: Só é possível atualizar pedidos PENDENTES.\n" +
                                   "Este pedido está " + pedidoSelecionado.getStatusExtenso());
                return;
            }
            pedidoSelecionado.resetarProdutos();
            Tela.exibirMensagem("Produtos antigos devolvidos ao estoque. Vamos selecionar os novos.");

            int opcao;
            DecimalFormat dfm = new DecimalFormat(",##0.00");
            do {
                String listaProdutos = "Selecione os NOVOS produtos (0 para finalizar):\n";
                for (int i = 0; i < BancodeDados.getProdutos().size(); i++) {
                    Produto prod = BancodeDados.getProdutos().get(i);
                    listaProdutos += (i + 1) + " - " + prod.getNomeProduto() + 
                                     " | Estq: " + prod.getQuantidade() + 
                                     " | R$" + dfm.format(prod.getPrecoUnitario()) + "\n";
                }
                opcao = Tela.nextInt(listaProdutos);

                if (opcao > 0 && opcao <= BancodeDados.getProdutos().size()) {
                    Produto pSelecionado = BancodeDados.getProdutos().get(opcao - 1);

                    if (pSelecionado.getQuantidade() > 0) {
                        pedidoSelecionado.adicionarProduto(pSelecionado);
                        pSelecionado.setQuantidade(pSelecionado.getQuantidade() - 1);
                    } else {
                        Tela.exibirMensagem("Produto sem estoque!");
                    }
                }
            } while (opcao != 0);

            Tela.exibirMensagem("Pedido #" + pedidoSelecionado.getIdPedido() + " atualizado com sucesso!");
        } else {
            Tela.exibirMensagem("Nenhum pedido encontrado para o CPF: " + cpfBusca);
        }
    }
    public static void CancelarPedido(){
         ArrayList<Pedido> listaPedidos = BancodeDados.getPedidos();

        if (listaPedidos.isEmpty()){
            Tela.exibirMensagem("Nenhum pedido cadastrado!");
            return;
        }
        String cpfBusca = Tela.nextString("Digite o CPF para localizar o pedido que deseja cancelar:");

        ArrayList<Pedido> pedidosDoCliente = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getCliente().getCpf().equals(cpfBusca) && p.getStatus() == 1) {
                pedidosDoCliente.add(p);
            }
        }
        
        if (pedidosDoCliente.isEmpty()) {
            Tela.exibirMensagem("Nenhum pedido pendente encontrado para este CPF.");
            return;
        }
        
        Pedido pedidoSelecionado = null;

        if (pedidosDoCliente.size() > 1) {
            String menuPedidos = "O cliente possui vários pedidos. Selecione qual deseja cancelar:\n";
            for (int i = 0; i < pedidosDoCliente.size(); i++) {
                menuPedidos += (i + 1) + " - Pedido #" + pedidosDoCliente.get(i).getIdPedido() + 
                               " | Total: R$" + pedidosDoCliente.get(i).getValorTotal() + "\n";
            }
            int escolha = Tela.nextInt(menuPedidos) - 1;
            if (escolha >= 0 && escolha < pedidosDoCliente.size()) {
                pedidoSelecionado = pedidosDoCliente.get(escolha);
            }
        } else {
            pedidoSelecionado = pedidosDoCliente.get(0);
        }
        
        if (pedidoSelecionado != null) {
            if (pedidoSelecionado.getStatus() == 2) {
                Tela.exibirMensagem("ERRO: Este pedido já foi FINALIZADO e não pode mais ser cancelado.");
                return; 
            }
            
            pedidoSelecionado.resetarProdutos();
            pedidoSelecionado.setStatus(3);  
            Tela.exibirMensagem("Pedido #" + pedidoSelecionado.getIdPedido() + " CANCELADO e estoque devolvido.");
        }    
    }
    public static void FinalizarPedido() {
        ArrayList<Pedido> listaPedidos = BancodeDados.getPedidos();
        if (listaPedidos.isEmpty()) {
            Tela.exibirMensagem("Nenhum pedido cadastrado!");
            return;
        }

        String cpfBusca = Tela.nextString("Digite o CPF do cliente para FINALIZAR a venda:");

        // Filtra: Pedidos do Cliente que estejam PENDENTES (status 1)
        ArrayList<Pedido> pendentesDoCliente = new ArrayList<>();
        for (Pedido p : listaPedidos) {
            if (p.getCliente().getCpf().equals(cpfBusca) && p.getStatus() == 1) {
                pendentesDoCliente.add(p);
            }
        }

        if (pendentesDoCliente.isEmpty()) {
            Tela.exibirMensagem("Nenhum pedido PENDENTE encontrado para este CPF.");
            return;
        }

        Pedido pedidoSelecionado = null;
        if (pendentesDoCliente.size() > 1) {
            String menu = "O cliente possui vários pedidos pendentes. Selecione qual deseja FINALIZAR:\n";
            for (int i = 0; i < pendentesDoCliente.size(); i++) {
                menu += (i + 1) + " - Pedido #" + pendentesDoCliente.get(i).getIdPedido() + 
                        " | Total: R$" + pendentesDoCliente.get(i).getValorTotal() + "\n";
            }
            int escolha = Tela.nextInt(menu) - 1;
            if (escolha >= 0 && escolha < pendentesDoCliente.size()) {
                pedidoSelecionado = pendentesDoCliente.get(escolha);
            }
        } else {
            pedidoSelecionado = pendentesDoCliente.get(0);
        }

        if (pedidoSelecionado != null) {
            pedidoSelecionado.setStatus(2);
            Tela.exibirMensagem("Venda Finalizada! Pedido #" + pedidoSelecionado.getIdPedido() + " concluído.");
        }
    }
}