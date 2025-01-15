package com.gymmaster.machine_management_ms.repository;

import com.gymmaster.machine_management_ms.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
    List<Machine> findByState(String state);

    @Query("SELECT m FROM Machine m WHERE m.lastService <= :date")
    List<Machine> findMachinesDueForService(@Param("date") LocalDate date);
}
