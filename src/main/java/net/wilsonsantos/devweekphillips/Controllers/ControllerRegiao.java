package net.wilsonsantos.devweekphillips.Controllers;

import net.wilsonsantos.devweekphillips.Entities.Regiao;
import net.wilsonsantos.devweekphillips.Repositories.RegiaoRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ControllerRegiao {
    private final RegiaoRepo repository;

    public ControllerRegiao(RegiaoRepo repository) {
        this.repository = repository;
    }

    @GetMapping("/regiao")
    public List getRegiao(){
        return repository.findAll();
    }

    @GetMapping("/regiao/{id}")
    public ResponseEntity<?> getRegiaoById(@PathVariable Long id){
        Optional regiaoEscolhidaOptional =  repository.findById(id);
        if(regiaoEscolhidaOptional.isPresent()){
            Object regiaoEscolhida = regiaoEscolhidaOptional.get();
            return new ResponseEntity<>(regiaoEscolhida, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/regiao/novo")
    public Regiao postRegiao(@RequestBody Regiao newRegiao){
      return  repository.save(newRegiao);
    }
    @DeleteMapping("/regiao/{id}")
    public void deleteRegiao(@PathVariable Long id){
        repository.deleteById(id);
    }
}
