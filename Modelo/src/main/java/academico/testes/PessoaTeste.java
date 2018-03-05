package academico.testes;

import academico.entidades.Pessoa;
import academico.repositorios.PessoaRepositorio;

public class PessoaTeste {

	public static void main(String[] args) {

		PessoaRepositorio pr = new PessoaRepositorio();

		Pessoa p;
		
//		PessoaFisica pf1 = new PessoaFisica();
//		PessoaFisica pf2 = new PessoaFisica();
//		
//		PessoaJuridica pj = new PessoaJuridica();

//		//pf1.setId(11);
//		pf1.setNome("Macilon");
//		pf1.setCpf(123);
//
//		//pf2.setId(22);
//		pf2.setNome("José Maria");
//		pf2.setCpf(456);
//
//		//pj.setId(33);
//		pj.setNome("Casa do Sogro");
//		pj.setCnpj(789);
//		
//		pr.adicionar(pf1);
//		pr.adicionar(pf2);
//		
//		pr.adicionar(pj);

		p = pr.recuperar(1);
		System.out.println(p);

		p = pr.recuperar(3);
		System.out.println(p);

		p = pr.recuperar(2);
		System.out.println(p);

		pr.encerrar();
	}

}
