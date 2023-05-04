package com.erlanggariansyah.mahasiswamanagementspringdynamodb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseList {
    private String field;
    private String message;
}
