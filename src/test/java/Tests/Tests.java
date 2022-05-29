
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tests;

import com.mycompany.movilbackend.Movilbackend;
import com.mycompany.movilbackend.dao.DirectionRepository;
import com.mycompany.movilbackend.dao.EmailRepository;
import com.mycompany.movilbackend.dao.PersonRepository;
import com.mycompany.movilbackend.dao.PhoneRepository;
import com.mycompany.movilbackend.enums.EstadoCivil;
import com.mycompany.movilbackend.enums.Sexo;
import com.mycompany.movilbackend.model.Direction;
import com.mycompany.movilbackend.model.Email;
import com.mycompany.movilbackend.model.Person;
import com.mycompany.movilbackend.model.Phone;
import java.util.Calendar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = Movilbackend.class)
public class Tests {
    @Autowired
   private PersonRepository personRepository;
   
   @Autowired
   private PhoneRepository phoneRepository;

   @Autowired
   private EmailRepository emailRepository;

   @Autowired
   private DirectionRepository directionRepository;
   @Test
   public void testing(){

       Calendar fecha = Calendar.getInstance();
       fecha.set(1981, 1, 1);

       Person persona = new Person();
       persona.setCedula("1150231668");
       persona.setNombres("Sandra Chamba");
       persona.setFechaNacimiento(fecha.getTime());
       persona.setEstadoCivil(EstadoCivil.SOLTERO);
       persona.setSexo(Sexo.MUJER);

       personRepository.save(persona);
       Phone telefono = new Phone();
       telefono.setPerson(persona);
       telefono.setTelefono("0982749777");

       phoneRepository.save(telefono);

       Email correo = new Email();

       correo.setPerson(persona);
       correo.setEmail("jhulianachamba24@gmail.com");

       emailRepository.save(correo);

       Direction direccion = new Direction();

       direccion.setPerson(persona);
       direccion.setDireccion("Cdla.Victor Emilio Valdivieso");

       directionRepository.save(direccion);

}
   
 
    
}
