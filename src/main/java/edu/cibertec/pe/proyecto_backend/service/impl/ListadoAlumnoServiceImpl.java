package edu.cibertec.pe.proyecto_backend.service.impl;

import edu.cibertec.pe.proyecto_backend.dto.AlumnoResponse;
import edu.cibertec.pe.proyecto_backend.service.ListadoAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListadoAlumnoServiceImpl  implements ListadoAlumnoService {

    @Autowired
    ResourceLoader resourceLoader;

    public List<AlumnoResponse> obtenerAlumnos() throws IOException {

        List<AlumnoResponse> listaAlumnos = new ArrayList<>();
        Resource resource = resourceLoader.getResource("classpath:alumnos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))){

            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");

                String codigo = datos[0];
                String nombre = datos[2];
                String apellido = datos[3];

                AlumnoResponse alumnoResponse = new AlumnoResponse(codigo, nombre, apellido);
                listaAlumnos.add(alumnoResponse);
            }

        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

        return listaAlumnos;

    }
}
