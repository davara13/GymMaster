package com.gymmaster.machine_management_ms.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.gymmaster.machine_management_ms.dot.request.MachineRequestDot;
import com.gymmaster.machine_management_ms.dot.response.MachineResponseAdminDot;
import com.gymmaster.machine_management_ms.dot.response.MachineResponseUserDot;
import com.gymmaster.machine_management_ms.dot.response.ResponseDot;
import com.gymmaster.machine_management_ms.model.Machine;

@Service
public class MachineServiceImpl implements IMachineService{
    @Override
    public double calculateOccupancyLevel(int activeUsers, int totalUnits, double averageUsageDuration, int timeSlotMinutes) {
        
        double demand = activeUsers * averageUsageDuration;
        double totalCapacity = totalUnits * timeSlotMinutes;
        return Math.min(100.0, (demand / totalCapacity) * 100.0);
    }

    @Override
    public ResponseDot createMachine(MachineRequestDot newMachine) {
        Machine machine = new Machine();

        machine.setName(newMachine.getName());
        machine.setDescription(newMachine.getDescription());
        machine.setExerciseTypes(newMachine.getExerciseTypes());
        machine.setCurrentStatus(newMachine.getCurrentStatus());
        machine.setTotalUnits(newMachine.getTotalUnits());
        machine.setEstimatedOccupancyLevel(newMachine.getEstimatedOccupancyLevel());
        machine.setAverageUsageDuration(newMachine.getAverageUsageDuration());
        machine.setLastMaintenanceDate(newMachine.getLastMaintenanceDate());
        machine.setMaintenanceInterval(newMachine.getMaintenanceInterval());

        //TO DO PERSISTENCE
        
        return new ResponseDot("Machine created successfully",HttpStatusCode.valueOf(201));
    }

    @Override
    public MachineResponseUserDot getMachineByIdUser(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMachineByIdUser'");
    }

    @Override
    public MachineResponseAdminDot getMachineByIdAdmin(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMachineByIdAdmin'");
    }

    @Override
    public List<MachineResponseAdminDot> getAllMachines() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllMachines'");
    }

    @Override
    public ResponseDot updateMachineById(Long Id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateMachineById'");
    }

    @Override
    public ResponseDot deleteMachine(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteMachine'");
    }
    
}
