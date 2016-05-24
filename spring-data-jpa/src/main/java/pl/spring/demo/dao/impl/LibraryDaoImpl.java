package pl.spring.demo.dao.impl;

import pl.spring.demo.dao.LibraryDao;
import pl.spring.demo.entity.LibraryEntity;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class LibraryDaoImpl extends AbstractDao<LibraryEntity, Long> implements LibraryDao {

	@Override
	public List<LibraryEntity> findLibraryByName(String name) {
		TypedQuery<LibraryEntity> query = entityManager.createQuery(
                "select library from LibraryEntity library where upper(library.name) like concat(upper(:name), '%')", LibraryEntity.class);
        query.setParameter("name", name);
        return query.getResultList();
	}
}
