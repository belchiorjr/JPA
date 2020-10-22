package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercicios");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Ana Laura", "analaura@lanche.com.br");
		
		//novoUsuario.setId(1L);
		
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();

		System.out.println("O Id gerado foi: " + novoUsuario.getId());
		emf.close();
	}
	
}
