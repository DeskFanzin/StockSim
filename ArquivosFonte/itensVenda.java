public class itensVenda {
  private int data;
  private Produto item;
  private int quantidade;
  private int venda;

  public itensVenda(int data, Produto item, int quantidade, int venda) {
    this.data = data;
    this.item = item;
    this.quantidade = quantidade;
    this.venda = venda;
  }

  public void alocaVenda(Produto produto, Venda venda, int quantidade) {
    produto.executaBaixa(quantidade);
    this.quantidade = quantidade;
    this.venda = venda.retornaCodigo();

  }

  public void devolveProduto(Produto produto, int quantidade) {
    produto.devolucao(quantidade);
    this.quantidade -= quantidade;
  }

  public int localizaCodigoProduto() {
    return item.retornaCodigo();
  }

  public void imprimeItemVenda() {
    System.out.println("Item: " + item.retornaCodigo());
    System.out.println("Quantidade: " + quantidade);
    System.out.println("Adicionado em: " + data);
    System.out.println("Venda: " + venda);
  }

  public void removeVenda(int venda) {
    this.venda = 0;
  }
}
