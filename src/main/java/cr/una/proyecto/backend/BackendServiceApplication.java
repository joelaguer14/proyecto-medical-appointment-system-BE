package cr.una.proyecto.backend;

import cr.una.proyecto.backend.model.Address;
import cr.una.proyecto.backend.model.Disease;
import cr.una.proyecto.backend.model.Patient;
import cr.una.proyecto.backend.model.Phone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.Date;

/**
 * @author Felipe Guzman Rodriguez
 * @author Manfred Joel Aguero Campos
 *
 * Implementation of BackendServiceApplication class
 */
@SpringBootApplication
public class BackendServiceApplication {
    private static final Logger logger = LogManager.getLogger(BackendServiceApplication.class);

    /**
     * Main
     * @param args, args
     */
    public static void main(String[] args) {
//        logger.info("Initializing the backend");
//        SpringApplication app = new SpringApplication(BackendServiceApplication.class);
//        app.setDefaultProperties(Collections.singletonMap("server.port", "8083"));
//        app.run(args);

//        Patient patient= new Patient();//int id, String fullName, String observations, Date
//        //birthDate, List< Address > addresses, List< Phone > phones, List< Disease > diseases
//patient.setBirthDate(new Date());

    }
}