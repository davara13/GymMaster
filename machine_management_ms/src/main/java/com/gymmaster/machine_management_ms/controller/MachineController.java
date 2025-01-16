package com.gymmaster.machine_management_ms.controller;

import java.util.List;

import com.gymmaster.machine_management_ms.dto.request.MachineServicesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.gymmaster.machine_management_ms.dto.request.MachineDTO;
import com.gymmaster.machine_management_ms.service.IMachineService;

@RestController
@RequestMapping("/api/machines")
public class MachineController {
    private final IMachineService machineService;

    public MachineController(IMachineService machineService) {
        this.machineService = machineService;
    }

    @PostMapping
    public ResponseEntity<MachineDTO> createMachine(@RequestBody MachineDTO machineDTO) {
        MachineDTO createdMachine = machineService.createMachine(machineDTO);
        return new ResponseEntity<>(createdMachine, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MachineDTO> getMachineById(@PathVariable Long id) {
        MachineDTO machineDTO = machineService.getMachineById(id);
        return ResponseEntity.ok(machineDTO);
    }

    @GetMapping
    public ResponseEntity<List<MachineDTO>> getAllMachines() {
        return ResponseEntity.ok(machineService.getAllMachines());
    }

    @PutMapping("/{id}")
    public ResponseEntity<MachineDTO> updateMachine(@PathVariable Long id, @RequestBody MachineDTO machineDTO) {
        MachineDTO updatedMachine = machineService.updateMachine(id, machineDTO);
        return ResponseEntity.ok(updatedMachine);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMachine(@PathVariable Long id) {
        machineService.deleteMachine(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{machineId}/services")
    public ResponseEntity<MachineServicesDTO> addMachineService(
            @PathVariable Long machineId,
            @RequestBody MachineServicesDTO machineServicesDTO) {
        MachineServicesDTO createdService = machineService.addMachineService(machineId, machineServicesDTO);
        return new ResponseEntity<>(createdService, HttpStatus.CREATED);
    }

    @GetMapping("/{machineId}/services")
    public ResponseEntity<List<MachineServicesDTO>> getMachineServices(@PathVariable Long machineId) {
        List<MachineServicesDTO> services = machineService.getServicesByMachineId(machineId);
        return ResponseEntity.ok(services);
    }

    @GetMapping("/avalability")
    public ResponseEntity<List<MachineDTO>> getAvalableMachines(@RequestParam String state) {
        List<MachineDTO> machines = machineService.getAvalableMachines(state);
        return new ResponseEntity<>(machines,HttpStatus.OK);
    }
}
