package com.lenolnmuniz;

import com.lenolnmuniz.peoples.Responsible;
import com.lenolnmuniz.peoples.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Student student = new Student("Lenoln Muniz");
        student.consolidateGrade(1, 6.0);
        student.consolidateGrade(2, 9.0);
        student.consolidateGrade(3, 7.0);
        student.consolidateGrade(4, 8.0);

        System.out.println(student.report());
        System.out.println(student.seeSituation(5));

        Responsible responsible = new Responsible("Rosiana Muniz");
        responsible.payMensality(1, true);
        responsible.payMensality(2, true);
        responsible.payMensality(3, false);
        responsible.payMensality(4, true);
        responsible.payMensality(5, false);

        System.out.println(responsible.report());
        System.out.println(responsible.seeSituation(1));
        System.out.println(responsible.seeSituation(2));
    }
}
