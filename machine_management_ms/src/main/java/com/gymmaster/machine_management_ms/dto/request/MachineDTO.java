package com.gymmaster.machine_management_ms.dto.request;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineDTO{
    private Long id;
    private String name;
    private String description;
    private String state;
    private LocalDate lastService;
    private Integer serviceInterval;
    private List<MachineServicesDTO> machineServices;
}
