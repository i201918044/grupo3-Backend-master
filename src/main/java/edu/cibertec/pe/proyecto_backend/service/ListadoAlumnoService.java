package edu.cibertec.pe.proyecto_backend.service;

import edu.cibertec.pe.proyecto_backend.dto.AlumnoResponse;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ListadoAlumnoService {

    List<AlumnoResponse> obtenerAlumnos() throws IOException;

}
