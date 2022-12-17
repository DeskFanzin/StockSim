public class ExemploEstoque {

  public static void main(String[] args) {
    System.out.print("entre o nome da empresa:");
    String nome = System.console().readLine();
    System.out.print("entre com a capacidade dos vetores:");
    int capacidade = Integer.parseInt(System.console().readLine());

    Estoque estoque = new Estoque(nome, capacidade);

    int opcao = 0;
    while (opcao != 9) {
      System.out.println("escolha uma opção:");
      System.out.println("9 - sair");
      System.out.println("1 - insere produto");
      System.out.println("2 - imprime produtos");
      System.out.println("3 - insere venda");
      System.out.println("4 - imprime vendas");
      System.out.println("5 - adiciona item a venda");
      System.out.println("6 - remove item a venda");
      System.out.println("7 - verifica preco de produto");

      opcao = Integer.parseInt(System.console().readLine());

      switch (opcao) {
        case 1:
          System.out.println("entre com o código do produto:");
          int codigoProduto = Integer.parseInt(System.console().readLine());
          System.out.print("entre com o nome do produto:");
          String nomeProduto = System.console().readLine();
          System.out.print("entre com o preco da unidade do produto:");
          Double precoUnProduto = Double.parseDouble(System.console().readLine());
          System.out.print("entre com a quantidade do produto:");
          int quantidadeProduto = Integer.parseInt(System.console().readLine());
          System.out.print("entre com a data e hora, respectivamente, da adicao do produto:");
          int data = Integer.parseInt(System.console().readLine());
          int hora = Integer.parseInt(System.console().readLine());
          Produto produto = new Produto(codigoProduto, nomeProduto, precoUnProduto, quantidadeProduto, capacidade);
          estoque.adicionaProduto(produto);
          produto.adicionaPreco(new Preco(data, hora, produto, precoUnProduto));
          break;
        case 2:
          estoque.imprimeProdutos();
          break;
        case 3:
          System.out.print("entre com o codigo da venda:");
          int codigoVenda = Integer.parseInt(System.console().readLine());
          System.out.print("entre com a data da venda:");
          int dataVenda = Integer.parseInt(System.console().readLine());
          System.out.print("entre com o horário da venda:");
          int horaVenda = Integer.parseInt(System.console().readLine());
          Venda venda = new Venda(codigoVenda, dataVenda, horaVenda, capacidade);
          estoque.adicionaVenda(venda);
          break;
        case 4:
          estoque.imprimeVendas();
          break;
        case 5:
          System.out.print("entre com o codigo da venda:");
          codigoVenda = Integer.parseInt(System.console().readLine());
          venda = estoque.consultaVenda(codigoVenda);
          if (venda != null) {
            System.out.print("entre com o codigo do produto:");
            codigoProduto = Integer.parseInt(System.console().readLine());
            produto = estoque.consultaProduto(codigoProduto);
            if (produto != null) {
              System.out.print("entre com a quantidade do produto a ser vendida:");
              quantidadeProduto = Integer.parseInt(System.console().readLine());
              System.out.print("entre com a data da venda:");
              dataVenda = Integer.parseInt(System.console().readLine());
              itensVenda itemVenda = new itensVenda(dataVenda, produto, quantidadeProduto, codigoVenda);
              venda.adicionaItem(itemVenda);
            } else {
              System.out.println("produto não encontrado");
            }
          } else {
            System.out.println("venda não encontrada");
          }
          break;

        case 6:
          System.out.print("entre com o codigo da venda:");
          codigoVenda = Integer.parseInt(System.console().readLine());
          venda = estoque.consultaVenda(codigoVenda);
          if (venda != null) {
            System.out.print("entre com o codigo do produto:");
            codigoProduto = Integer.parseInt(System.console().readLine());
            produto = estoque.consultaProduto(codigoProduto);
            if (produto != null) {
              System.out.print("entre com a quantidade do produto a ser removida:");
              quantidadeProduto = Integer.parseInt(System.console().readLine());
              // achar o itensvenda com o codigo da venda e o codigo do produto
              itensVenda itemVenda = venda.retornaItensVenda(codigoProduto);

              venda.removeItemVenda(itemVenda);
            } else {
              System.out.println("produto não encontrado");
            }
          } else {
            System.out.println("venda não encontrada");
          }
          break;
        case 7:
          System.out.print("entre com o codigo do produto:");
          codigoProduto = Integer.parseInt(System.console().readLine());
          produto = estoque.consultaProduto(codigoProduto);
          if (produto != null) {
            System.out.println("preço do produto: " + produto.verificaPreco());
          } else {
            System.out.println("produto não encontrado");
          }
          break;
        case 9:
          System.out.println("saindo...");
          break;
        default:
          System.out.println("opção inválida");
      }
    }
  }
}
