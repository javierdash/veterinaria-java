
package com.mycompany.peluqueriacanina.logica;
import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, 
                        String observaciones, String nombreDuenio, String celDuenio, 
                        String alergico, String atenEsp) {

     //creo una instancia de Duenio y le paso los valores
     Duenio duenio = new Duenio();
     
     //seteamos los campos (asignamos valores)
     duenio.setNombre(nombreDuenio);
     duenio.setCelular(celDuenio);     
     
     Mascotas masco = new Mascotas();
     masco.setAlergico(alergico);
     masco.setAtencion_especial(atenEsp);
     masco.setColor(color);
     masco.setNombre_perro(nombreMasco);
     masco.setObservaciones(observaciones);
     masco.setRaza(raza);
     masco.setUnDuenio(duenio);
     
     //para que persista:
     controlPersis.guardar(duenio,masco);
     
    }

    public List<Mascotas> traerMascotas() {
        
        //quien se encarga de traer los datos es la controladoraDePersistencia (controlPersis
        return controlPersis.traerMascotas();
        
    }


    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascotas(num_cliente);       
    }
    
}
