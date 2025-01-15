package com.gymmaster.machine_management_ms.service;

import java.util.List;
import java.util.stream.Collectors;

import com.gymmaster.machine_management_ms.exception.NotFoundException;
import org.springframework.stereotype.Service;

import com.gymmaster.machine_management_ms.dto.request.MachineDTO;
import com.gymmaster.machine_management_ms.dto.request.MachineServicesDTO;
import com.gymmaster.machine_management_ms.entity.Machine;
import com.gymmaster.machine_management_ms.entity.MachineServices;
import com.gymmaster.machine_management_ms.repository.MachineRepository;
import com.gymmaster.machine_management_ms.repository.MachineServicesRepository;
import com.gymmaster.machine_management_ms.utils.MachineMapper;

@Service
public class MachineServiceImpl implements IMachineService{
    private final MachineRepository machineRepository;
    private final MachineServicesRepository machineServicesRepository;

    public MachineServiceImpl(MachineRepository machineRepository, MachineServicesRepository machineServicesRepository) {
        this.machineRepository = machineRepository;
        this.machineServicesRepository = machineServicesRepository;
    }

    @Override
    public MachineDTO createMachine(MachineDTO machineDTO) {
        Machine machine = new Machine();
        machine.setName(machineDTO.getName());
        machine.setDescription(machineDTO.getDescription());
        machine.setState(machineDTO.getState());
        machine.setLastService(machineDTO.getLastService());
        machine.setServiceInterval(machineDTO.getServiceInterval());
        machine = machineRepository.save(machine);
        return MachineMapper.toDTO(machine);
    }

    @Override
    public MachineDTO getMachineById(Long id) {
        Machine machine = machineRepository.findById(id).orElseThrow(() -> new NotFoundException("Machine not found with ID: " + id));
        return MachineMapper.toDTO(machine);
    }

    @Override
    public List<MachineDTO> getAllMachines() {
        return machineRepository.findAll().stream().map(MachineMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public MachineDTO updateMachine(Long id, MachineDTO machineDTO) {
        Machine machine = machineRepository.findById(id).orElseThrow(() -> new NotFoundException("Machine not found with ID: " + id));
        machine.setName(machineDTO.getName());
        machine.setDescription(machineDTO.getDescription());
        machine.setState(machineDTO.getState());
        machine.setLastService(machineDTO.getLastService());
        machine.setServiceInterval(machineDTO.getServiceInterval());
        machine = machineRepository.save(machine);
        return MachineMapper.toDTO(machine);
    }

    @Override
    public void deleteMachine(Long id) {
        if (!machineRepository.existsById(id)) {
            throw new NotFoundException("Machine not found with ID: " + id);
        }
        machineRepository.deleteById(id);
    }

    @Override
    public MachineServicesDTO addMachineService(Long machineId, MachineServicesDTO machineServicesDTO) {
        Machine machine = machineRepository.findById(machineId)
                .orElseThrow(() -> new NotFoundException("Machine not found with ID: " + machineId));

        MachineServices machineService = new MachineServices();
        machineService.setDate(machineServicesDTO.getDate());
        machineService.setDescription(machineServicesDTO.getDescription());
        machineService.setMachineId(machine.getId());

        machineService = machineServicesRepository.save(machineService);

        machine.setLastService(machineService.getDate());
        machineRepository.save(machine);

        return MachineMapper.toServiceDTO(machineService);
    }

    @Override
    public List<MachineServicesDTO> getServicesByMachineId(Long machineId) {
        Machine machine = machineRepository.findById(machineId)
                .orElseThrow(() -> new NotFoundException("Machine not found with ID: " + machineId));

        return machine.getMachineServices().stream()
                .map(MachineMapper::toServiceDTO)
                .toList();
    }


}
