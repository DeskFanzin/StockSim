public class Preco {
  private int datainicial;
  private int datafinal;
  private Produto item;
  private Double preco;

  public Preco(int datainicial, int datafinal, Produto item, Double preco) {
    this.datainicial = datainicial;
    this.datafinal = datafinal;
    this.item = item;
    this.preco = preco;
  }

  public void alocaItem(Produto item, Double preco, int datainicial, int datafinal) {
    this.item = item;
    this.preco = preco;
    this.datainicial = datainicial;
    this.datafinal = datafinal;
  }

  public void ImprimePreco() {
    System.out.println("Preco: " + preco);
  }

  public Double retornaPreco() {
    return preco;
  }

  public Double localizaPreco(Produto item) {
    if (this.item == item) {
      return preco;
    }
    return 0.00;
  }

  public void removePreco(Produto item) {
    this.preco = 0.00;
  }
}
