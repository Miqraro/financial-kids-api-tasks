package org.r4.login;

import javax.enterprise.context.ApplicationScoped;
import org.r4.login.*;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger; // logging
import java.util.List;

@ApplicationScoped
public class TareaService {

Logger logger = Logger.getLogger(TareaService.class); // logging

@ConfigProperty(name = "hash-key")
	
	String hashKey;

    public List<Tarea> tarea(){
        try{
        logger.debug("hashKey: " + hashKey);
        
        List<Tarea> tareas = Tarea.todasTareas();

        if(tareas == null){
            logger.debug("tareas: " + "null");
        }
        
        if ( tareas!= null){
            return tareas;
        }else{
            return null;
        }
        }catch(Exception e){
            logger.debug("Nos hemos caído");
            return null;
        }        
    }
}

