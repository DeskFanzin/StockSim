import java.util.Vector;

class Estoque {
  private String empresa;
  private Vector listaDeProdutos;
  private Vector listaDeVendas;

  public Estoque(String empresa, int n) {
    this.empresa = empresa;
    listaDeProdutos = new Vector(n);
    listaDeVendas = new Vector(n);
  }

  public void adicionaProduto(Produto p) {
    listaDeProdutos.addElement(p);
  }

  public void adicionaVenda(Venda v) {
    listaDeVendas.addElement(v);
  }

  public Produto consultaProduto(int codigo) {
    for (int i = 0; i < listaDeProdutos.size(); i++) {
      Produto p = (Produto) listaDeProdutos.elementAt(i);
      if (p.retornaCodigo() == codigo) {
        return p;
      }
    }
    System.out.println("Produto " + codigo + " nao encontrado");
    return null;
  }

  public Venda consultaVenda(int codigo) {
    for (int i = 0; i < listaDeVendas.size(); i++) {
      Venda v = (Venda) listaDeVendas.elementAt(i);
      if (v.retornaCodigo() == codigo) {
        return v;
      }
    }
    System.out.println("Venda de codigo" + codigo + " nao encontrada");
    return null;
  }

  public void imprimeProdutos() {
    System.out.println("Produtos da empresa " + empresa);
    for (int i = 0; i < listaDeProdutos.size(); i++) {
      Produto p = (Produto) listaDeProdutos.elementAt(i);
      System.out.println(p.retornaCodigo());
    }
  }

  public void imprimeVendas() {
    System.out.println("Vendas da empresa " + empresa);
    for (int i = 0; i < listaDeVendas.size(); i++) {
      Venda v = (Venda) listaDeVendas.elementAt(i);
      v.imprimeVenda();
    }
  }

  public void inicializa() {
  }

  public void removeProduto(int codigo) {
    for (int i = 0; i < listaDeProdutos.size(); i++) {
      Produto p = (Produto) listaDeProdutos.elementAt(i);
      if (p.retornaCodigo() == codigo) {
        listaDeProdutos.removeElementAt(i);
        System.out.println("Produto " + codigo + " removido");
        return;
      }
    }
    System.out.println("Produto " + codigo + " nao encontrado");
  }

  public void removeVenda(int codigo) {
    for (int i = 0; i < listaDeVendas.size(); i++) {
      Venda v = (Venda) listaDeVendas.elementAt(i);
      if (v.retornaCodigo() == codigo) {
        listaDeVendas.removeElementAt(i);
        System.out.println("Venda de codigo " + codigo + " removida");
        return;
      }
    }
    System.out.println("Venda de codigo " + codigo + " nao encontrada");
  }

}
