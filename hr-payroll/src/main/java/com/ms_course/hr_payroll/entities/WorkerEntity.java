package com.ms_course.hr_payroll.entities;

import java.io.Serializable;
import java.util.Objects;

// Criando o modelo base de worker entity que está em outro projeto
public class WorkerEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Double dailyIncome;

    public WorkerEntity() {

    }

    public WorkerEntity(Long id, String name, Double dailyIncome) {
        this.id = id;
        this.name = name;
        this.dailyIncome = dailyIncome;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(Double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerEntity that = (WorkerEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(dailyIncome, that.dailyIncome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, dailyIncome);
    }
}
