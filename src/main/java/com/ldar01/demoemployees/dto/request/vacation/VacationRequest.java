package com.ldar01.demoemployees.dto.request.vacation;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class VacationRequest {
    @NotNull(message = "You must provide a start date")
    private LocalDate startDate;

    @NotNull(message = "You must provide an end date")
    private LocalDate endDate;

    @NotNull(message = "You must provide a reason for the vacation")
    private String reason;

    @NotNull(message = "You must provide an employee ID")
    private Integer employeeId;

    @AssertTrue(message = "The start date must be before the end date")
    public boolean isValidDateRange() {
        if (startDate == null || endDate == null) return true;
        return startDate.isBefore(endDate);
    }

}
