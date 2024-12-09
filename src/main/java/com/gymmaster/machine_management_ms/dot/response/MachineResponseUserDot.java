package com.gymmaster.machine_management_ms.dot.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MachineResponseUser {
    private String name; // Nombre de la máquina (e.g., "Caminadora")
    private String description; // Breve descripción de la máquina
    private Double estimatedOccupancyLevel; // Nivel estimado de ocupación (0.0 a 100.0)
}
