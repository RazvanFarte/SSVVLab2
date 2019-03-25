package Repository.MemoryRepository;

import domain.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import repository.StudentRepository;
import validation.StudentValidator;

public class StudentRepoTest {

    StudentRepository studentRepository;

    @Before
    public void setUp() {
        studentRepository = new StudentRepository(new StudentValidator());

        studentRepository.save(new Student("1", "1", 1));
    }

    @Test
    public void testGet() {
        Student student = studentRepository.findOne("1");

    }

}


