package com.gymmaster.machine_management_ms.service;

import com.gymmaster.machine_management_ms.dot.response.MachineResponseUserDot;

import java.util.List;

import com.gymmaster.machine_management_ms.dot.request.MachineRequestDot;
import com.gymmaster.machine_management_ms.dot.response.MachineResponseAdminDot;
import com.gymmaster.machine_management_ms.dot.response.ResponseDot;

public interface IMachineService {

    // <<<CRUD OPERATION
    //==========CREATE=============//
    public ResponseDot createMachine(MachineRequestDot newMachine);

    //==========READ=============//
    public MachineResponseUserDot getMachineByIdUser(Long Id); //to do
    public MachineResponseAdminDot  getMachineByIdAdmin(Long Id); //to do
    public List<MachineResponseAdminDot> getAllMachines();

    //==========UPDATE=============//
    public ResponseDot updateMachineById(Long Id); 

    //==========DELATE=============//
    public ResponseDot deleteMachine(Long id);
    // >>>CRUD OPERATION



    // <<<CORE OPERATION
    public double calculateOccupancyLevel(int activeUsers, int totalUnits, double averageUsageDuration, int timeSlotMinutes);
    // >>>CORE OPERATION
}
