package com.mycompany.peluqueriacanina.logica;

import com.mycompany.peluqueriacanina.persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza,
            String color, String observaciones,
            String alergico, String atenEsp,
            String nombreDuenio, String celDuenio) {
       
            //creamos el dueño y asignamos sus valores
            Duenio duenio = new Duenio();
            duenio.setNombre(nombreDuenio);
            duenio.setCelDuenio(celDuenio);
            
            //creamos la mascota y asignamos sus valores
            Mascota masco = new Mascota();   
            masco.setNombre(nombreMasco);   
            masco.setRaza(raza);
            masco.setColor(color);
            masco.setAlergico(alergico);
            masco.setAtencion_especial(atenEsp);
            masco.setObservaciones(observaciones);
            masco.setUnDuenio(duenio);
                
            controlPersis.guardar(duenio, masco);
            
    }

    public List<Mascota> traerMascotas() {

        return controlPersis.traerMascotas();

    }

    public void borrarMascota(int num_cliente) {

         controlPersis.borrarMascota(num_cliente);

    }


    public Mascota traerMascota(int num_cliente) {  //EXPLICACION EN EL VIDEO #2 MIN 02:06:40

        return controlPersis.traerMascota(num_cliente);

    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color, String observaciones,
            String alergico, String atenEsp, String nombreDuenio, String celDuenio) {

        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(atenEsp);
        masco.setAlergico(alergico);
     
        //modifico la mascota
        controlPersis.modificarMascota(masco);
     
        //seteo nuevos valores del dueño
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(nombreDuenio);
        
        //llamar al modificar dueño
        this.modificarDuenio(dueno);
        
    }

    private Duenio buscarDuenio(int id_duenio) {

        return controlPersis.traerDuenio(id_duenio);
        
    }

    private void modificarDuenio(Duenio dueno) {

        controlPersis.modificarDuenio(dueno);

    }
    

    
    
    
}
