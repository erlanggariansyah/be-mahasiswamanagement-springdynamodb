package com.erlanggariansyah.mahasiswamanagementspringdynamodb.service;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.BadRequestException;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.NotFoundException;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.model.Mahasiswa;

import java.util.List;

public interface MahasiswaService {
    List<Mahasiswa> get(String q);
    Mahasiswa getById(String id) throws NotFoundException;
    Mahasiswa update(String id, Mahasiswa mahasiswa) throws BadRequestException, NotFoundException;
    void delete(String id) throws NotFoundException;
    Mahasiswa post(String nama, String jurusan, Integer ipk) throws BadRequestException;
    List<Mahasiswa> getByJurusanWithGreaterIPK(String jurusan, Integer ipk);
}
