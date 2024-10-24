package edu.cibertec.pe.proyecto_backend.controller;

import edu.cibertec.pe.proyecto_backend.dto.AlumnoResponse;
import edu.cibertec.pe.proyecto_backend.dto.ListadoResponseDTO;
import edu.cibertec.pe.proyecto_backend.service.ListadoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/listado")
public class ListadoAlumnoController {

    @Autowired
    ListadoAlumnoService listadoAlumnoService;

    @GetMapping("/alumnos")
    public ListadoResponseDTO obtenerListadoAlumno() {

        try {
            List<AlumnoResponse> listadoAlumno = listadoAlumnoService.obtenerAlumnos();
            ListadoResponseDTO listadoResponseDTO = new ListadoResponseDTO(listadoAlumno);
            if (listadoAlumno != null) {
                return listadoResponseDTO;
            } else {
                return null;
            }

        } catch (Exception e){
            return null;
        }
    }
}
