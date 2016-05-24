package pl.spring.demo.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.spring.demo.entity.LibraryEntity;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "CommonDaoTest-context.xml")
public class LibraryDaoImplTest {

    @Autowired
    private LibraryDao libraryDao;

    @Test
    @Sql(scripts = "import.sql")
    @DirtiesContext
    public void testShouldFindLibraryByName() {
        // given
    	String name = "libr";
        // when
        List<LibraryEntity> libraryEntities = libraryDao.findLibraryByName(name);
        // then
        assertFalse(libraryEntities.isEmpty());
        assertEquals(6, libraryEntities.size());
    }
    
    @Test
    @Sql(scripts = "import.sql")
    @DirtiesContext
    public void testShouldFindLibraryByName2() {
        // given
    	String name = "library 3";
        // when
        List<LibraryEntity> libraryEntities = libraryDao.findLibraryByName(name);
        // then
        assertFalse(libraryEntities.isEmpty());
        assertEquals(1, libraryEntities.size());
    }

}
