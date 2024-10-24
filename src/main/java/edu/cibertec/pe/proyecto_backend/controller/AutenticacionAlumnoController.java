package edu.cibertec.pe.proyecto_backend.controller;
import edu.cibertec.pe.proyecto_backend.dto.LoginRequestDTO;
import edu.cibertec.pe.proyecto_backend.dto.LoginResponseDTO;
import edu.cibertec.pe.proyecto_backend.service.AutenticacionAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;

@RestController
@RequestMapping("/autenticar")
public class AutenticacionAlumnoController {
    @Autowired
    AutenticacionAlumnoService autenticacionalumnoService;

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO loginRequestDTO){

        try {
            String[] datosAlumno = autenticacionalumnoService.validarIntegrantes(loginRequestDTO);
            System.out.println("Respuesta backend: " + Arrays.toString(datosAlumno));

            if (datosAlumno == null) {
                return new LoginResponseDTO("01", "Error: Alumno no encontrado", "", "");
            }
            return new LoginResponseDTO("00", "Inicio de sesión exitoso", datosAlumno[0], datosAlumno[1]);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new LoginResponseDTO("99", "Error: Problemas en la autenticación", "", "");
        }
    }
}
