package ru.innopolis.repository.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.innopolis.config.JDBCTamplaeBuild;
import ru.innopolis.entity.Client;
import ru.innopolis.repository.ClientRepository;

import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

    private final JdbcTemplate jdbcTamplaeBuild = JDBCTamplaeBuild.jdbcTamplate();

    private static final String GET_ALL =  "SELECT * FROM client";
    private static final String UPDATE_TEL_CLIENT =  "UPDATE client SET tel = ?, address = ? WHERE fio = ?";

    @Override
    public List<Client> getAll() {
        return jdbcTamplaeBuild.query(GET_ALL, clientRowMapper);
    }

    @Override
    public void updateClient(String tel, String address, String fio) {

        var result = UPDATE_TEL_CLIENT;

        jdbcTamplaeBuild.update(result, tel, address, fio);
    }


    private static final RowMapper<Client> clientRowMapper = (row, rowNumber) -> {

        Long id = row.getLong("id");
        String fio_client = row.getString("fio");
        String tel_client = row.getString("tel");
        String address_client = row.getString("address");

        return new Client(id, fio_client, tel_client, address_client);

    };

}
