package com.gymmaster.machine_management_ms.service;

import com.gymmaster.machine_management_ms.dto.request.MachineDTO;
import com.gymmaster.machine_management_ms.dto.request.MachineServicesDTO;

import java.util.List;

public interface IMachineService {
    MachineDTO createMachine(MachineDTO machineDTO);
    MachineDTO getMachineById(Long id);
    List<MachineDTO> getAllMachines();
    MachineDTO updateMachine(Long id, MachineDTO machineDTO);
    void deleteMachine(Long id);
    MachineServicesDTO addMachineService(Long machineId, MachineServicesDTO machineServicesDTO);
}
