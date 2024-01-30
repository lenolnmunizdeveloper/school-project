package com.lenolnmuniz.peoples;

import java.lang.reflect.Array;

public class Student extends People {

    private double[] grades = new double[4];
    private String matricula;

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public double[] getGrades() {
        return grades;
    }

    public void setGrades(double[] grades) {
        this.grades = grades;
    }

    public Student(String name) {
        super(name);
    }

    public void consolidateGrade(int unit, double grade){
        //TODO implementar
    }

    public double calculateFinalAverage(){
        //TODO implementar
        return 0.0;
    }

    @Override
    public String seeSituation(int mes) {
        //TODO implementar
        return null;
    }

    @Override
    public String report() {
        //TODO implementar
        return null;
    }


}
