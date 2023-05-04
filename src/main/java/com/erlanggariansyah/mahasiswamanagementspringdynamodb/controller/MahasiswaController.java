package com.erlanggariansyah.mahasiswamanagementspringdynamodb.controller;

import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.BadRequestException;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable.NotFoundException;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.model.Mahasiswa;
import com.erlanggariansyah.mahasiswamanagementspringdynamodb.service.MahasiswaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class MahasiswaController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MahasiswaController.class);

    @Autowired
    MahasiswaService mahasiswaService;

    @GetMapping("/mahasiswa")
    public ResponseEntity<Map<String, ?>> get(@RequestParam(name = "q") @Nullable String q) {
        LOGGER.info("start executing get mahasiswa controller method");

        Map<String, Object> responseBody = new LinkedHashMap<>();
        List<Mahasiswa> mahasiswaList = mahasiswaService.get(q);

        responseBody.put("title", "OK");
        responseBody.put("status", 200);
        responseBody.put("data", mahasiswaList);

        LOGGER.info("finish executing get mahasiswa controller method");
        return ResponseEntity.ok(responseBody);
    }

    @PostMapping("/mahasiswa")
    public ResponseEntity<Map<String, ?>> post(
            @RequestParam(name = "nama") @NotNull String nama,
            @RequestParam(name = "jurusan") @NotNull String jurusan,
            @RequestParam(name = "ipk") @NotNull Integer ipk
    ) throws BadRequestException {
        LOGGER.info("start executing post mahasiswa controller method");

        Map<String, Object> responseBody = new LinkedHashMap<>();
        Mahasiswa mahasiswa = mahasiswaService.post(nama, jurusan, ipk);

        responseBody.put("title", "OK");
        responseBody.put("status", 200);
        responseBody.put("data", mahasiswa);

        LOGGER.info("finish executing post mahasiswa controller method");
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/mahasiswa/{id}")
    public ResponseEntity<Map<String, ?>> getById(@PathVariable(name = "id") String id) throws NotFoundException {
        LOGGER.info("start executing get mahasiswa by id controller method");

        Map<String, Object> responseBody = new LinkedHashMap<>();
        Mahasiswa mahasiswa = mahasiswaService.getById(id);

        responseBody.put("title", "OK");
        responseBody.put("status", 200);
        responseBody.put("data", mahasiswa);

        LOGGER.info("finish executing get mahasiswa by id controller method");
        return ResponseEntity.ok(responseBody);
    }

    @DeleteMapping("/mahasiswa/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") String id) throws NotFoundException {
        LOGGER.info("start executing delete mahasiswa controller method");

        mahasiswaService.delete(id);

        LOGGER.info("finish executing delete mahasiswa controller method");
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/mahasiswa/{id}")
    public ResponseEntity<Map<String, ?>> put(
            @PathVariable(name = "id") String id,
            @RequestParam(name = "nama") @NotNull String nama,
            @RequestParam(name = "jurusan") @NotNull String jurusan,
            @RequestParam(name = "ipk") @NotNull Integer ipk
    ) throws BadRequestException, NotFoundException {
        LOGGER.info("start executing update mahasiswa controller method");

        Map<String, Object> responseBody = new LinkedHashMap<>();
        Mahasiswa updateMahasiswa = new Mahasiswa();
        updateMahasiswa.setNama(nama);
        updateMahasiswa.setJurusan(jurusan);
        updateMahasiswa.setIpk(ipk);

        Mahasiswa mahasiswa = mahasiswaService.update(id, updateMahasiswa);

        responseBody.put("title", "OK");
        responseBody.put("status", 200);
        responseBody.put("data", mahasiswa);

        LOGGER.info("finish executing update mahasiswa controller method");
        return ResponseEntity.ok(responseBody);
    }

    @GetMapping("/mahasiswa/ipk")
    public ResponseEntity<Map<String, ?>> getByJurusanGreaterIPK(
            @RequestParam(name = "jurusan") @NotNull String jurusan,
            @RequestParam(name = "ipk") @NotNull Integer ipk
    ) {
        LOGGER.info("start executing get by jurusan greater ipk controller method");

        Map<String, Object> responseBody = new LinkedHashMap<>();
        List<Mahasiswa> mahasiswaList = mahasiswaService.getByJurusanWithGreaterIPK(jurusan, ipk);

        responseBody.put("title", "OK");
        responseBody.put("status", 200);
        responseBody.put("data", mahasiswaList);

        LOGGER.info("finish executing get by jurusan greater ipk controller method");
        return ResponseEntity.ok(responseBody);
    }
}
