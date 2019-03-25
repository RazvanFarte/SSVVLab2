package repository;

import domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import validation.StudentValidator;

public class AbstractCRUDRepositoryTest {

    AbstractCRUDRepository<String, Student> studentRepository;

    @Before
    public void setUp() throws Exception {
        studentRepository = new StudentRepository(new StudentValidator());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void save() {
        studentRepository.save(new Student("123", "Student123", 123));

        Assert.assertEquals(1, studentRepository.entities.size());
    }
}