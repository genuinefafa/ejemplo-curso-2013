package foo.curso.account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import foo.curso.entities.Alumno;

@Repository
@Transactional(readOnly = true)
public class AlumnoRepository {
	private static final Logger LOG = LoggerFactory.getLogger(AccountController.class);

	@PersistenceContext
	private EntityManager entityManager;

	public List<Alumno> findAll() {
		TypedQuery<Alumno> q = entityManager.createQuery("select a from Alumno a", Alumno.class);
		List<Alumno> alumnos = q.getResultList();
		LOG.info("Se obtuvieron {} alumnos", alumnos.size());

		return alumnos;
	}
	
	public void create(Alumno alumno) {
		entityManager.persist(alumno);
	}

}
