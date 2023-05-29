
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

    public Mascotas traerMascotas(int num_cliente) {
        return controlPersis.traerMascotas(num_cliente);      
    
    }

    public void modificarMascota(Mascotas masco, String nombreMasco, String raza, String color, String observaciones, String nombreDuenio, String celDuenio, String alergico, String atenEsp) {



     // campos a modificar de la mascota
     masco.setAlergico(alergico);
     masco.setAtencion_especial(atenEsp);
     masco.setColor(color);
     masco.setNombre_perro(nombreMasco);
     masco.setObservaciones(observaciones);
     masco.setRaza(raza);
     
     //no se pueden modificar ambas tablas directamente. Creo 2 metodos
     //para que persista:
     controlPersis.modificarMascota(masco);

     //seteo nuevos valores del dueño:
     Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
     dueno.setCelular(celDuenio);
     dueno.setNombre(nombreDuenio);
     
     //llamar al modificar dueño:
     this.modificarDuenio(dueno);

     
     
    //ESTA OPCION LA PENSÉ YO PERO NO LA USAMOS, NO SE SI SIRVE..   
    //creo un objeto con el mismo id del que quiero modificar! 
    //     Duenio duenio = new Duenio();
    //     
    //     duenio.setCelular(masco.getUnDuenio().getCelular());
    //     duenio.setId_duenio(masco.getUnDuenio().getId_duenio());
    //     duenio.setNombre(masco.getUnDuenio().getNombre());
    //     duenio.setDireccion(masco.getUnDuenio().getDireccion());
             
    //controlPersis.modificarDuenio(duenio);
    
    
    }

    //método creado que podemos reutilizar
    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);

    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }



}
