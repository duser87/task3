package ru.innopolis;

import ru.innopolis.repository.ClientRepository;
import ru.innopolis.repository.DoctorRepository;
import ru.innopolis.repository.impl.ClientRepositoryImpl;
import ru.innopolis.repository.impl.DoctorRepositoryImpl;

public class Main {

    private static final ClientRepository clientRepository = new ClientRepositoryImpl();

    private static final DoctorRepository doctorRepository = new DoctorRepositoryImpl();

    public static void main(String[] args) {

        var doctor = doctorRepository.getAll();
        var pos_doctor_1 = doctorRepository.getPositionDoctor("Врач-УЗИ");
        var pos_doctor_2 = doctorRepository.getPositionDoctor("Врач-кардиолог");

        // Общий список
        System.out.println(doctor);

        // Список специалистов
        System.out.println(pos_doctor_1);
        System.out.println(pos_doctor_2);

        var client = clientRepository.getAll();

        // Сведения о клиентах до обновления
        System.out.println(client);

        clientRepository.updateClient("1234567", "ул.Старая, д.3", "Иванов Иван Иванович");
        clientRepository.updateClient("9876543", "ул.Старая, д.7", "Сидоров Сидор Сидорович");

        client = clientRepository.getAll();

        // Сведения о клиентах после обновления
        System.out.println(client);

    };

}