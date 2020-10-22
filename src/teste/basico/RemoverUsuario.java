package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class RemoverUsuario {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercicios");
		EntityManager em = emf.createEntityManager();

		Usuario usuario = em.find(Usuario.class, 3L);
		
		if (usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		}
		
		// em.merge(usuario);
		em.close();
		emf.close();
	}
}
