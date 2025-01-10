package com.gymmaster.machine_management_ms.utils;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

import com.gymmaster.machine_management_ms.dto.request.MachineDTO;
import com.gymmaster.machine_management_ms.dto.request.MachineServicesDTO;
import com.gymmaster.machine_management_ms.entity.Machine;
import com.gymmaster.machine_management_ms.entity.MachineServices;

public class MachineMapper {

    public static MachineDTO toDTO(Machine machine) {
        MachineDTO dto = new MachineDTO();
        dto.setId(machine.getId());
        dto.setName(machine.getName());
        dto.setDescription(machine.getDescription());
        dto.setState(machine.getState());
        dto.setLastService(machine.getLastService());
        dto.setServiceInterval(machine.getServiceInterval());

        dto.setMachineServices(Optional.ofNullable(machine.getMachineServices())
                .orElse(Collections.emptyList())
                .stream()
                .map(MachineMapper::toServiceDTO)
                .collect(Collectors.toList()));

        return dto;
    }

    public static MachineServicesDTO toServiceDTO(MachineServices service) {
        MachineServicesDTO dto = new MachineServicesDTO();
        dto.setId(service.getId());
        dto.setDate(service.getDate());
        dto.setDescription(service.getDescription());
        dto.setMachineId(service.getMachineId());
        return dto;
    }

    public static Machine toEntity(MachineDTO dto) {
        Machine machine = new Machine();
        machine.setId(dto.getId());
        machine.setName(dto.getName());
        machine.setDescription(dto.getDescription());
        machine.setState(dto.getState());
        machine.setLastService(dto.getLastService());
        machine.setServiceInterval(dto.getServiceInterval());

        machine.setMachineServices(Optional.ofNullable(dto.getMachineServices())
                .orElse(Collections.emptyList())
                .stream()
                .map(MachineMapper::toEntity)
                .collect(Collectors.toList()));

        return machine;
    }

    public static MachineServices toEntity(MachineServicesDTO dto) {
        MachineServices service = new MachineServices();
        service.setId(dto.getId());
        service.setDate(dto.getDate());
        service.setDescription(dto.getDescription());
        service.setMachineId(dto.getMachineId());
        return service;
    }
}


