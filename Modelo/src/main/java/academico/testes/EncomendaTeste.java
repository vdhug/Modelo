package academico.testes;

import academico.entidades.Destino;
import academico.entidades.Encomenda;
import academico.repositorios.EncomendaRepositorio;

public class EncomendaTeste {

	public static void main(String[] args) {
		EncomendaRepositorio er = new EncomendaRepositorio(); 
		
		Encomenda e1 = new Encomenda();
		e1.setId(111L);
		e1.setDescricao("Carrinho de mão");
		
		Encomenda e2 = new Encomenda();
		e2.setId(222L);
		e2.setDescricao("Boca de lobo");
		
		Destino d1 = new Destino();
		d1.setId(11L);
		d1.setCep("1234");
		d1.setCidade("Rio Branco");
		
		Destino d2 = new Destino();
		d2.setId(22L);
		d2.setCep("5678");
		d2.setCidade("Bujari");
		
		e1.setDestino(d1);
		e2.setDestino(d2);

		er.adicionar(e1);
		er.adicionar(e2);
		
		er.encerrar();

	}

}
