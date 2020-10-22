package infra;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Entidade;

public class DAO<E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;

	static {
		try {
			emf = Persistence.createEntityManagerFactory("jpa-exercicios");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		super();
		this.classe = classe;
		this.em = emf.createEntityManager();
	}

	public DAO<E> abrirTransaction() {
		this.em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransaction() {
		this.em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade) {
		this.em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirTransaction().incluir(entidade).fecharTransaction();
	}
	
	public List<E> obterTodos() {
		return this.obterTodos(10,0);
	}
	
	public E obterPorID(Object id) {
		return em.find(classe, id);
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento) {
		
		if (classe == null) {
			throw new UnsupportedOperationException("Classe nula");
		}
		
		String jpql = "select e from "+  classe.getName() + " e";
		TypedQuery<E> query = em.createQuery(jpql, classe);
		
		query.setMaxResults(quantidade);
		query.setFirstResult(deslocamento);
		
		return query.getResultList();
	}
	
	public DAO<E> atualizar(E entidade) {
		this.em.merge(entidade);
		return this;
	}
	
	public DAO<E> remover(E entidade) {
		this.em.remove(entidade);
		return this;
	}

	
	public List<E> consulta(String nomeConsulta, Object...params) {
		
		TypedQuery<E> query = em.createNamedQuery(nomeConsulta, classe);
		
		for (int i = 0; i < params.length; i += 2) {
			query.setParameter(params[i].toString(), params[i+1]);
		}
		
		return query.getResultList();
	}
	
	public E consultaUm(String nomeConsulta, Object...params) {
		List<E> lista = consulta(nomeConsulta, params);
		return lista.isEmpty() ? null : lista.get(0);
	}
	
	
	
	
	
	public void fechar() {
		em.close();
	}
	
}
