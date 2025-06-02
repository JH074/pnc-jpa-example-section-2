package com.ldar01.demoemployees.dto.request.vacation;

import com.ldar01.demoemployees.entities.Vacation;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class VacationUpdateRequest {
    @NotNull (message = "You must provide a vacation ID")
    private Integer vacationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private String reason;
    @Enumerated(EnumType.STRING)
    private Vacation.Status status;
    private Integer employeeId;

}
