package com.erlanggariansyah.mahasiswamanagementspringdynamodb.repository;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.model.Mahasiswa;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface MahasiswaRepository extends CrudRepository<Mahasiswa, String> {
    @Override
    Optional<Mahasiswa> findById(String s);
}
