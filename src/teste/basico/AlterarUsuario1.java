package teste.basico;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import modelo.basico.Usuario;

public class AlterarUsuario1 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-exercicios");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		Usuario usuario = em.find(Usuario.class,  2L);
		System.out.println(usuario.getEmail());
		
		usuario.setNome("Belchior Junior");
		usuario.setEmail("belchiorjr@gmail.com");

		em.merge(usuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
