package repository;

import domain.Nota;
import domain.Pair;
import domain.Student;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IncrementalTest {

    TemaRepository temaRepository;
    StudentRepository studentRepository;
    NotaRepository notaRepository;
    private Student mockStudent = new Student("1", "1", 112);
    private Nota mockNota = new Nota(new Pair<>("1", "1"), 1d, 1, "1");
    private Tema mockTema = new Tema("1", "Description", 3, 2);

    @Before
    public void setUp() throws Exception {
        temaRepository = new TemaRepository(new TemaValidator());
        notaRepository = new NotaRepository(new NotaValidator());
        studentRepository = new StudentRepository(new StudentValidator());
    }


    @Test
    public void addTema()
    {
        temaRepository.save(mockTema);

        assertNotNull(temaRepository.findOne("1"));
        assertEquals(temaRepository.findOne("1").getDescriere(), "Description");
    }

    @Test
    public void addTemaAndNota()
    {
        addTema();

        notaRepository.save(mockNota);

        assertNotNull(notaRepository.findOne(new Pair<>("1", "1")));
    }

    @Test
    public void addTemaAndNotaStudent()
    {

        addTemaAndNota();

        studentRepository.save(mockStudent);

        assertNotNull(temaRepository.findOne("1"));
    }

}
