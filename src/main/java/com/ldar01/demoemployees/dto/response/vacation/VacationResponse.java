package com.ldar01.demoemployees.dto.response.vacation;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class VacationResponse {
    @NotNull(message = "Vacation ID cannot be null")
    private Integer vacationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    private String status;
    private Integer employeeId;
}
