package com.erlanggariansyah.mahasiswamanagementspringdynamodb.repository;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.model.Mahasiswa;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

@EnableScan
public interface MahasiswaRepository extends CrudRepository<Mahasiswa, String> {
    @Override
    Optional<Mahasiswa> findById(String s);

    @Query(value = "SELECT * FROM Mahasiswa WHERE jurusan = :jurusan AND ipk >= :minIpk")
    List<Mahasiswa> findByJurusanAndIpkGreaterThan(
            @Param("jurusan") String jurusan,
            @Param("minIpk") Integer minIpk
    );
}
