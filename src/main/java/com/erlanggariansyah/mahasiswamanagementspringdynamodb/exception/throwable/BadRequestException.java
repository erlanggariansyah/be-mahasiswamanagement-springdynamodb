package com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BadRequestException extends Throwable {
    private String field;
    private String message;
}
