package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercicios");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Usuario usuario = em.find(Usuario.class, 2L);
		System.out.println(usuario.getEmail());

		usuario.setNome("Belchior Junior");
		em.detach(usuario);	
		
		// em.merge(usuario);		
		usuario.setEmail("belchiorjr@gmail.com");
		
		// em.merge(usuario);
		em.getTransaction().commit();

		em.close();
		emf.close();
	}
}
