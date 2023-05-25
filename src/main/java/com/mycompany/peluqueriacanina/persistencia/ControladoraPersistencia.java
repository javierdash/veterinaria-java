
package com.mycompany.peluqueriacanina.persistencia;

import com.mycompany.peluqueriacanina.logica.Duenio;
import com.mycompany.peluqueriacanina.logica.Mascotas;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotasJpaController mascoJpa = new MascotasJpaController();

    public void guardar(Duenio duenio, Mascotas masco) {

        //crear en la BD el dueño
        duenioJpa.create(duenio);
        
        //crear en la BD la mascota
        mascoJpa.create(masco);
    }
    
}
