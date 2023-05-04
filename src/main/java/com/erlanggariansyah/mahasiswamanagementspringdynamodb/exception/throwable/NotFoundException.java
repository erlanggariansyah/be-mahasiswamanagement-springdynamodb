package com.erlanggariansyah.mahasiswamanagementspringdynamodb.exception.throwable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NotFoundException extends Throwable {
    private String field;
    private String message;
}
