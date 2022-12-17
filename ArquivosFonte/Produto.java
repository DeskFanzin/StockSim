import java.util.Vector;

public class Produto {
  private int codigo;
  private Vector listaDePrecos;
  private String nome;
  private int quantidade;
  private Double unidade;

  public Produto(int codigo, String nome, Double unidade, int quantidade, int n) {
    this.codigo = codigo;
    this.nome = nome;
    this.quantidade = quantidade;
    this.unidade = unidade;
    listaDePrecos = new Vector(n);
  }

  public void adicionaPreco(Preco p) {
    listaDePrecos.addElement(p);
    this.unidade = p.retornaPreco();
  }

  public void devolucao(int quantidade) {
    this.quantidade += quantidade;
  }

  public void executaBaixa(int quantidade) {
    this.quantidade -= quantidade;
  }

  public void imprimeItem() {
    System.out.println("Produto: " + nome);
    System.out.println("Codigo: " + codigo);
    System.out.println("Unidade: " + unidade);
    System.out.println("Quantidade: " + quantidade);
    System.out.println("Precos:");
    for (int i = 0; i < listaDePrecos.size(); i++) {
      Preco p = (Preco) listaDePrecos.elementAt(i);
      p.ImprimePreco();
    }
  }

  public void imprimeProduto() {
    System.out.println("Produto: " + nome);
    System.out.println("Codigo: " + codigo);
    System.out.println("Unidade: " + unidade);
    System.out.println("Quantidade: " + quantidade);
  }

  public void removePreco(Preco p) {
    listaDePrecos.removeElement(p);
    p.removePreco(this);
  }

  public int retornaCodigo() {
    return codigo;
  }

  public double verificaPreco() {
    double preco = 0.00;
    for (int i = 0; i < listaDePrecos.size(); i++) {
      Preco p = (Preco) listaDePrecos.elementAt(i);
      preco = p.localizaPreco(this);
    }
    return preco;
  }

  public void verificaProduto(int codigo) {
    if (this.codigo == codigo) {
      imprimeProduto();
    }
  }

}
