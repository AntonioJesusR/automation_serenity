package com.automationtest.service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDto {
    private String nombre;
    private String apellido;
    @Email
    private String email;
    @Value("#{9}")
    private int movil;
    private String dolencia;
    private String foto;
    private Boolean existeCliente;
    @Value("/^[0-9]{8}[TRWAGMYFPDXBNJZSQVHLCKET]$")
    private String dni;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd")
    private String edad;

}
