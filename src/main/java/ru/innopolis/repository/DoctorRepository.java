package ru.innopolis.repository;

import ru.innopolis.entity.Doctor;

import java.util.List;

public interface DoctorRepository {

    public List<Doctor> getAll();

    public List<Doctor> getPositionDoctor(String s);

}
