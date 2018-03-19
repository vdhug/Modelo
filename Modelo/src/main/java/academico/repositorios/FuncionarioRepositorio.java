package academico.repositorios;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import academico.entidades.Funcionario;


public class FuncionarioRepositorio {
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("AcademicoJPA");
	    EntityManager em = emf.createEntityManager();
	    
	    public void adicionar(Funcionario funcionario) {
	        em.getTransaction().begin();
	        em.persist(funcionario);
	        em.getTransaction().commit();
	    }
	    
	    public void atualizar(Funcionario funcionario) {
	    em.getTransaction().begin();
	    em.merge(funcionario);
	    em.getTransaction().commit();
	    }
	    
	    public void remover(Funcionario funcionario) {
	        em.getTransaction().begin();
	        em.remove(funcionario);
	        em.getTransaction().commit();
	    }
	    public List<Funcionario> listar(){
	        Query qr = em.createQuery("from funcionario f");
	        return qr.getResultList();
	    }
	    
	    public Funcionario recuperar(int id){
	    	return em.find(Funcionario.class, id);
	    }
	    public void encerrar() {
	        em.close();
	        emf.close();
	    }
}
