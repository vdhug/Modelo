package academico.testes;

import java.util.List;

import academico.entidades.Item;
import academico.entidades.Pedido;
import academico.repositorios.PedidoRepositorio;

public class PedidoTeste {

	public static void main(String[] args) {

		PedidoRepositorio pr = new PedidoRepositorio();

		List<Pedido> pedidos;
		
		Pedido p1 = new Pedido();
		Pedido p2 = new Pedido();
		Pedido p3 = new Pedido();
		Item i11 = new Item();
		Item i12 = new Item();
		Item i21 = new Item();
		Item i22 = new Item();
		Item i31 = new Item();
		Item i32 = new Item();

		// ADICIONANDO PEDIDOS		
		p1.setId(1);
		p1.setStatus("Aguardando pagamento");
		p2.setId(2);
		p2.setStatus("Em transporte");

		p3.setId(3);
		p3.setStatus("Cancelado");
		
		i11.setId(11);
		i11.setQuantidade(3L);
		i12.setId(12);
		i12.setQuantidade(8L);
		
		i21.setId(21);
		i21.setQuantidade(15L);
		i22.setId(22);
		i22.setQuantidade(12L);

		i31.setId(31);
		i31.setQuantidade(3L);
		i32.setId(32);
		i32.setQuantidade(9L);				

		p1.addItem(i11);
		p1.addItem(i12);
		
		p2.addItem(i21);
		p2.addItem(i22);

		p3.addItem(i31);
		p3.addItem(i32);
		
		pr.adicionar(p1);
		pr.adicionar(p2);
		pr.adicionar(p3);		

		// ATUALIZANDO PEDIDOS
//		p1 = pr.recuperar(1);
//		i11 = p1.getItens().get(0);
//		p1.delItem(i11);
//
//		p2 = pr.recuperar(2);
//		i22 = p2.getItens().get(1);
//		p2.delItem(i22);
//		
//		pr.atualizar(p1);
//		pr.atualizar(p2);

		// REMOVENDO PEDIDO
//		p1 = pr.recuperar(1);
//		pr.remover(p1);

		// LISTANDO TODOS
		pedidos = pr.recuperarPorStatus("m");
		for (Pedido pedido : pedidos) {
			System.out.println(pedido);
		}
		
		pr.encerrar();

	}

}
