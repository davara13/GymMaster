package com.gymmaster.machine_management_ms.dto.request;

import com.gymmaster.machine_management_ms.entity.Machine;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineServicesDTO{
    private Long id;
    private LocalDate date;
    private String description;
    private Long machineId;
}
