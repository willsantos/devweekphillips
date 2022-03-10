package net.wilsonsantos.devweekphillips.Controllers;

import net.wilsonsantos.devweekphillips.Entities.Incidencia;
import net.wilsonsantos.devweekphillips.Repositories.IncidenciaRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ControllerIncidencia {
    private final IncidenciaRepo repository;

    public ControllerIncidencia(IncidenciaRepo repository) {
        this.repository = repository;
    }


    @GetMapping("/incidencias")
    public ResponseEntity<List<Incidencia>> findIncidencias(){
        List<Incidencia> listaIncidencia = repository.findAll();
        if (listaIncidencia.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<>(listaIncidencia, HttpStatus.OK);
    }

    @GetMapping("/incidencias/{id}")
    public ResponseEntity<Incidencia> findIncidenciasById(@PathVariable Long id){
        Optional<Incidencia> incidenciaOptional = repository.findById(id);
        if (incidenciaOptional.isPresent()){
            Incidencia incidenciaUnid = incidenciaOptional.get();
            return new ResponseEntity<>(incidenciaUnid, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/incidencias/novo")
    public Incidencia newIncidencia(@RequestBody Incidencia newIncidencia){
        return repository.save(newIncidencia);
    }

}
