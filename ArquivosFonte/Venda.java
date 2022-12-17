import java.util.Vector;

public class Venda {
  private int codigo;
  private int data;
  private int hora;
  private Vector itensVenda;

  public Venda(int codigo, int data, int hora, int n) {
    this.codigo = codigo;
    this.data = data;
    this.hora = hora;
    itensVenda = new Vector(n);
  }

  public void adicionaItem(itensVenda item) {
    itensVenda.addElement(item);
  }

  public int retornaCodigo() {
    return codigo;
  }

  public itensVenda retornaItensVenda(int codigoProduto) {
    for (int j = 0; j < itensVenda.size(); j++) {
      itensVenda item = (itensVenda) itensVenda.elementAt(j);
      if (item.localizaCodigoProduto() == codigoProduto) {
        return item;
      }
    }
    return null;
  }

  public void imprimeVenda() {
    System.out.println("Codigo: " + codigo);
    System.out.println("Data: " + data);
    System.out.println("Hora: " + hora);
    System.out.println("Itens da venda:");
    for (int i = 0; i < itensVenda.size(); i++) {
      itensVenda item = (itensVenda) itensVenda.elementAt(i);
      item.imprimeItemVenda();
    }
  }

  public void removeItemVenda(itensVenda item) {
    itensVenda.removeElement(item);
  }

}
