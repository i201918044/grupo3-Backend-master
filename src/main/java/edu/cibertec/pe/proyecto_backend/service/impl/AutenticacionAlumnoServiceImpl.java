package edu.cibertec.pe.proyecto_backend.service.impl;
import edu.cibertec.pe.proyecto_backend.dto.LoginRequestDTO;
import edu.cibertec.pe.proyecto_backend.service.AutenticacionAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@Service
public class AutenticacionAlumnoServiceImpl implements AutenticacionAlumnoService {

    @Autowired
    ResourceLoader resourceLoader;

    @Override
    public String[] validarIntegrantes(LoginRequestDTO loginRequestDTO) throws IOException {

        String[] datosAlumno = null;
        Resource resource = resourceLoader.getResource("classpath:integrantes.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(resource.getFile()))) {
            String linea;
            while ((linea = br.readLine()) != null) {

                String[] datosI = linea.split(";");
                if (loginRequestDTO.codigoAlumno().equals(datosI[0]) &&
                    loginRequestDTO.password().equals(datosI[1])) {

                    datosAlumno = new String[2];
                    datosAlumno[0] = datosI[2];
                    datosAlumno[1] = datosI[3];
                }
            }
        } catch (IOException e) {
            datosAlumno = null;
            throw new IOException(e);
        }
        return datosAlumno;
    }
}
