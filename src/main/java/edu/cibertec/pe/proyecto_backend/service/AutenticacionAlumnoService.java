package edu.cibertec.pe.proyecto_backend.service;
import edu.cibertec.pe.proyecto_backend.dto.LoginRequestDTO;
import java.io.IOException;

public interface AutenticacionAlumnoService {
    String[] validarIntegrantes(LoginRequestDTO loginRequestDTO) throws IOException;
}
