package pl.spring.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import pl.spring.demo.entity.BookEntity;
import pl.spring.demo.repository.BookRepository;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonServiceTest-context.xml")

public class OptimisticLockTest {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Test
	@Sql(scripts = "import.sql")
	@DirtiesContext
	public void tesOptimisticLockException() {
		// given
		Long id = 1L;
		EntityManager em1 = entityManagerFactory.createEntityManager();
		EntityManager em2 = entityManagerFactory.createEntityManager();

		try {
			em1.getTransaction().begin();
			BookEntity book1 = em1.find(BookEntity.class, id);
			em1.lock(book1, LockModeType.OPTIMISTIC);

			em2.getTransaction().begin();
			BookEntity book2 = em2.find(BookEntity.class, id);
			// when
			book1.setTitle("Nowy tytuł");
			book2.setTitle("Inny tytuł");

			bookRepository.save(book1);
			bookRepository.save(book2);

			em1.getTransaction().commit();
			em2.getTransaction().commit();
			//then
			assertTrue(false);
		} catch (ObjectOptimisticLockingFailureException e) {
			assertTrue(true);
		} finally {
			em1.close();
			em2.close();
		}
	}
}
