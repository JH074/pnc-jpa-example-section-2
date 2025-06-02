package com.ldar01.demoemployees.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "vacations")

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vacation {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "reason")
    private String reason;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    public enum Status {
        PENDING,
        APPROVED,
        REJECTED;

        @JsonCreator
        public static Status from(String value) {
            return Status.valueOf(value.trim().toUpperCase());
        }

        @JsonValue
        public String toValue() {
            return this.name();
        }
    }
}
