package com.gymmaster.machine_management_ms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gymmaster.machine_management_ms.dot.request.MachineRequestDot;
import com.gymmaster.machine_management_ms.dot.response.MachineResponseAdminDot;
import com.gymmaster.machine_management_ms.dot.response.MachineResponseUserDot;
import com.gymmaster.machine_management_ms.dot.response.ResponseDot;
import com.gymmaster.machine_management_ms.model.Machine;
import com.gymmaster.machine_management_ms.service.IMachineService;

@RestController
@RequestMapping("/api/machines")
public class MachineController {

    @Autowired
    private IMachineService machineService;

    @GetMapping("/{id}")
    public ResponseEntity<MachineResponseUserDot> getMachineById(@PathVariable Long id) {
        return new ResponseEntity<MachineResponseUserDot>(machineService.getMachineByIdUser(id) ,HttpStatusCode.valueOf(201));
    }

    @PostMapping
    public ResponseEntity<ResponseDot> createMachine(@RequestBody MachineRequestDot machine) {
        return new ResponseEntity<ResponseDot>(machineService.createMachine(machine) ,HttpStatusCode.valueOf(201));
    }

    @GetMapping
    public ResponseEntity<List<MachineResponseAdminDot>> getAllMachines() {
        return new ResponseEntity<List<MachineResponseAdminDot>>(machineService.getAllMachines() ,HttpStatusCode.valueOf(201));
    }

    @GetMapping("/{id}/occupancy")
    public ResponseEntity<Double> getMachineOccupancy(@PathVariable Long id) {
        return new ResponseEntity<Double>(machineService.calculateOccupancyLevel(1,1,1,1), HttpStatusCode.valueOf(201));
    }
}
