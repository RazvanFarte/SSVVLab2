package repository;

import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import validation.TemaValidator;

import static org.junit.Assert.*;

public class TemaRepositoryTest {

    TemaRepository temaRepository;

    @Before
    public void setUp() throws Exception {
        temaRepository = new TemaRepository(new TemaValidator());
    }

    @Test
    public void addAssignment() {
        temaRepository.save(new Tema("1", "Description", 3, 2));
    }

    @Test
    public void addAssignmentInvalid() {
        temaRepository.save(new Tema("1", "Description", 0, 2));

        assertNull(temaRepository.findOne("1"));
    }

    @Test
    public void addAssignmentExistent() {
        temaRepository.save(new Tema("1", "Description", 3, 2));
        temaRepository.save(new Tema("1", "Description2", 3, 2));

        assertEquals(temaRepository.findOne("1").getDescriere(), "Description");
    }

}