package academico.testes;

import academico.entidades.Curso;
import academico.repositorios.CursoRepositorio;

public class CursoTeste {

	public static void main(String[] args) {

		CursoRepositorio cr = new CursoRepositorio();
		
		Curso c1 = new Curso();
		Curso c2 = new Curso();
		Curso c30 = new Curso();
		
		// c1.setCodigo(1);
		c1.setNome("Direito");
		
		//c2.setCodigo(2);
		c2.setNome("Economia");

		//c30.setCodigo(30);
		c30.setNome("Sistemas de Informação");
		
		cr.adicionar(c1);
		cr.adicionar(c2);
		cr.adicionar(c30);
		
		cr.encerrar();
	}

}
