package com.gymmaster.machine_management_ms.dot.response;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineResponseAdminDot{
    private Long id; // Identificador único de la máquina
    private String name; // Nombre de la máquina (e.g., "Caminadora")
    private String description; // Breve descripción de la máquina
    private List<String> exerciseTypes; // Tipos de ejercicios soportados (e.g., "Cardio")
    private String currentStatus; // Estado actual (e.g., "Disponible", "Ocupada", "En Mantenimiento")
    private Integer totalUnits; // Número total de máquinas de este tipo en el gimnasio
    private Double estimatedOccupancyLevel; // Nivel estimado de ocupación (0.0 a 100.0)
    private Double averageUsageDuration; // Tiempo promedio de uso por usuario (en minutos)
    //private List<UsageLog> usageLogs; // Historial de uso de la máquina (No sé si se relaciona acá o en los informes) 
    private LocalDate lastMaintenanceDate; // Fecha del último mantenimiento
    private Integer maintenanceInterval; // Intervalo de mantenimiento recomendado (en días)
} 
