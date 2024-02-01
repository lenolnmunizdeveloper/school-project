package com.lenolnmuniz.peoples;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class StudentTest  {
    private Student student1;
    private Student student2;
    private Student student3;

    @Before
    public void setUp() {
        student1 = new Student("Paulo Sacomani");
        student2 = new Student("Noah de Freitas");
        student3 = new Student("Sabrina Cabral");

        student1.setCpf("126.126.126-16");
        student2.setCpf("127.127.127-17");
        student3.setCpf(null);

        student1.setEmail("paulo.sacomani@paulo.com");
        student2.setEmail(null);
        student3.setEmail("sabrina.cabral@sabrina.com");

        student1.setPhone("(11) 11111-1111");
        student2.setPhone("(22) 22222-2222");
        student3.setPhone("(33) 33333-3333");
    }

    @Test
    public void testGetRegister() {
        student1.setRegister("1");
        assertEquals("1", student1.getRegister());
        assertEquals("126.126.126-16", student1.getCpf());
        assertEquals("paulo.sacomani@paulo.com", student1.getEmail());
        assertEquals("(11) 11111-1111", student1.getPhone());

        student2.setRegister("2");
        assertEquals("2", student2.getRegister());
        assertEquals("127.127.127-17", student2.getCpf());
        assertNull(student2.getEmail());
        assertEquals("(22) 22222-2222", student2.getPhone());

        student3.setRegister("3");
        assertEquals("3", student3.getRegister());
        assertNull(student3.getCpf());
        assertEquals("sabrina.cabral@sabrina.com", student3.getEmail());
        assertEquals("(33) 33333-3333", student3.getPhone());
    }

    @Test
    public void testSetRegister() {
        student1.setRegister("12345");
        assertEquals("12345", student1.getRegister());
    }

    @Test
    public void testGetGrades() {
        double[] grades1 = {7.0, 8.0, 9.0, 10.0};
        student1.setGrades(grades1);
        assertArrayEquals(grades1, student1.getGrades(), 0.0);

        double[] grades2 = {5.0, 9.0, 5.0, 6.0};
        student1.setGrades(grades2);
        assertArrayEquals(grades2, student1.getGrades(), 0.0);

        double[] grades3 = {9.0, 8.0, 7.0, 6.0};
        student1.setGrades(grades3);
        assertArrayEquals(grades3, student1.getGrades(), 0.0);
    }

    @Test
    public void testSetGrades() {
        double[] grades1 = {7.0, 8.0, 9.0, 10.0};
        student1.setGrades(grades1);
        assertArrayEquals(grades1, student1.getGrades(), 0.0);
    }

    @Test
    public void testConsolidateGrade() {
        student1.consolidateGrade(1, 7.0);
        assertEquals(7.0, student1.getGrades()[0], 0.0);
    }

    @Test
    public void testCalculateFinalAverage() {
        double[] grades = {7.0, 8.0, 9.0, 10.0};
        student1.setGrades(grades);
        assertEquals(8.5, student1.calculateFinalAverage(), 0.0);
    }

    @Test
    public void testSeeSituation() {
        double[] grades1 = {7.0, 8.0, 9.0, 10.0};
        student1.setGrades(grades1);
        assertEquals("O aluno está na média na unidade 1 e obteve a nota 7.0", student1.seeSituation(1));

        double[] grades2 = {7.0, 8.0, 9.0, 10.0};
        student2.setGrades(grades2);
        assertEquals("O aluno está na média na unidade 2 e obteve a nota 8.0", student2.seeSituation(5));

        double[] grades3 = {7.0, 8.0, 9.0, 10.0};
        student3.setGrades(grades3);
        assertEquals("O aluno está na média na unidade 4 e obteve a nota 10.0", student3.seeSituation(10));
    }

    @Test
    public void testReport() {
        student1.setRegister("12345");
        double[] grades1 = {7.0, 8.0, 9.0, 10.0};
        student1.setGrades(grades1);
        assertEquals("O estudante Paulo Sacomani, obteve a média final de 8.5", student1.report());
    }

    @After
    public void tearDown() {
        student1 = null;
        student2 = null;
        student3 = null;
    }
}
