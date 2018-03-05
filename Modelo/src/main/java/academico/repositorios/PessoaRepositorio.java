package academico.repositorios;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import academico.entidades.Pessoa;
import academico.entidades.PessoaFisica;
import academico.entidades.PessoaJuridica;

public class PessoaRepositorio {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public PessoaRepositorio (){
		emf = Persistence.createEntityManagerFactory("AcademicJPA");
		em = emf.createEntityManager();
	}
	public void adicionar(PessoaFisica pf){
		em.getTransaction().begin();
		em.persist(pf);
		em.getTransaction().commit();
	}
	public void adicionar(PessoaJuridica pj){
		em.getTransaction().begin();
		em.persist(pj);		
		em.getTransaction().commit();
	}
	public Pessoa recuperar(int id){
		return em.find(Pessoa.class, id);
	}
	public void atualizar(PessoaFisica pf){
		em.getTransaction().begin();
		em.merge(pf);		
		em.getTransaction().commit();
	}
	public void atualizar(PessoaJuridica pj){
		em.getTransaction().begin();
		em.merge(pj);		
		em.getTransaction().commit();
	}
	public void remover(PessoaFisica pf){
		em.getTransaction().begin();
		em.remove(pf);		
		em.getTransaction().commit();
	}
	public void remover(PessoaJuridica pj){
		em.getTransaction().begin();
		em.remove(pj);		
		em.getTransaction().commit();
	}	
	public void encerrar(){
		em.close();
		emf.close();
	}
}

