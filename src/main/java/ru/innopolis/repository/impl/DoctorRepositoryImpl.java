package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.config.JDBCTamplaeBuild;
import ru.innopolis.entity.Doctor;
import ru.innopolis.repository.DoctorRepository;
import java.util.List;

public class DoctorRepositoryImpl implements DoctorRepository {

    private final JdbcTemplate jdbcTamplaeBuild = JDBCTamplaeBuild.jdbcTamplate();

    private static final String GET_ALL =  "SELECT * FROM doctor";
    private static final String GET_POSITION_DOCTOR =  "SELECT * FROM doctor WHERE position=";

    @Override
    public List<Doctor> getAll() {
        return jdbcTamplaeBuild.query(GET_ALL, doctorRowMapper);
    }

    @Override
    public List<Doctor> getPositionDoctor(String s){
        var str = GET_POSITION_DOCTOR + "\'" + s + "\'";
        return jdbcTamplaeBuild.query(str, doctorRowMapper);
    }

    private static final RowMapper<Doctor> doctorRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String fio_doc = row.getString("fio_doctor");
        String position_doc = row.getString("position");
        String tel_doc = row.getString("tel_doctor");

        return new Doctor(id, fio_doc, position_doc, tel_doc);

    };

}
