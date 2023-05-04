package com.erlanggariansyah.mahasiswamanagementspringdynamodb.service;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.BadRequestException;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.NotFoundException;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.model.Mahasiswa;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.repository.MahasiswaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class MahasiswaServiceImplementation implements MahasiswaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaServiceImplementation.class);

    @Autowired
    MahasiswaRepository mahasiswaRepository;

    @Override
    public List<Mahasiswa> get(String q) {
        LOGGER.info("Start executing get mahasiswa method");

        List<Mahasiswa> mahasiswaList = new ArrayList<>();
        Iterable<Mahasiswa> mahasiswaIterable = mahasiswaRepository.findAll();

        mahasiswaIterable.forEach(mahasiswaList::add);

        LOGGER.info("finish executing get mahasiswa method");
        return mahasiswaList;
    }

    @Override
    public Mahasiswa getById(String id) throws NotFoundException {
        LOGGER.info("start executing get by id mahasiswa method");
        Optional<Mahasiswa> mahasiswa = mahasiswaRepository.findById(id);
        if (mahasiswa.orElse(null) == null) throw new NotFoundException("id", "id tidak ditemukan.");

        LOGGER.info("finish executing get by id mahasiswa method");
        return mahasiswa.get();
    }

    @Override
    public Mahasiswa update(String id, Mahasiswa mahasiswa) throws BadRequestException, NotFoundException {
        LOGGER.info("start executing update mahasiswa method");

        Optional<Mahasiswa> mahasiswaData = mahasiswaRepository.findById(id);
        if (mahasiswaData.orElse(null) == null) throw new NotFoundException("id", "id tidak ditemukan.");

        mahasiswaData.get().setNama(mahasiswa.getNama());
        mahasiswaData.get().setJurusan(mahasiswa.getJurusan());
        mahasiswaData.get().setIpk(mahasiswa.getIpk());

        LOGGER.info("finish executing update mahasiswa method");
        return mahasiswaData.get();
    }

    @Override
    public void delete(String id) throws NotFoundException {
        LOGGER.info("start executing delete mahasiswa method");

        Optional<Mahasiswa> mahasiswa = mahasiswaRepository.findById(id);
        if (mahasiswa.orElse(null) == null) throw new NotFoundException("id", "id tidak ditemukan.");

        LOGGER.info("finish executing delete mahasiswa method");
        mahasiswaRepository.delete(mahasiswa.get());
    }

    @Override
    public Mahasiswa post(String nama, String jurusan, Integer ipk) throws BadRequestException {
        LOGGER.info("start executing post mahasiswa method");

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNama(nama);
        mahasiswa.setJurusan(jurusan);
        mahasiswa.setIpk(ipk);

        Mahasiswa savedMahasiswa = mahasiswaRepository.save(mahasiswa);

        LOGGER.info("finish executing post mahasiswa method");
        return savedMahasiswa;
    }

    @Override
    public List<Mahasiswa> getByJurusanWithGreaterIPK(String jurusan, Integer ipk) {
        return mahasiswaRepository.findByJurusanAndIpkGreaterThan(jurusan, ipk);
    }
}
