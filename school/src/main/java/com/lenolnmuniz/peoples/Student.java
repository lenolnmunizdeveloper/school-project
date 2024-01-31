package com.lenolnmuniz.peoples;

public class Student extends People {

    final int UNIT = 4;
    private double[] grades = new double[UNIT];
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
        grades[unit-1] = grade;
    }

    public double calculateFinalAverage(){
        double sumGrades = 0.0;
        for (double grade : grades){
            sumGrades += grade;
        }
        return sumGrades / UNIT;
    }

    private int defineUnitFromMonth(int month){
        if (month >= 1 && month <= 3) {
            return 1;
        } else if (month > 3 && month <= 6) {
            return 2;
        } else if (month > 6 && month <= 9) {
            return 3;
        } else if (month > 9 && month <= 12) {
            return 4;
        } else {
            return 0;
        }
    }

    @Override
    public String seeSituation(int month) {
        int unit = defineUnitFromMonth(month);
        if(getGrades()[unit-1] >= 7.0){
            return "O aluno está na média na unidade " + unit + " e obteve a nota " + getGrades()[unit-1];
        } else {
            return "O aluno não está na média na unidade " + unit + " e obteve a nota " + getGrades()[unit-1];
        }
    }

    @Override
    public String report() {
        return "O estudante " + getName() + " , " + " obteve a média final de " + calculateFinalAverage();
    }


}
