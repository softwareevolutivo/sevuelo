package ec.Controllers;

import ec.DTO.NewPassenger;
import ec.DTO.PassengerDTO;



import ec.Services.PassengerService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;



import jakarta.validation.Valid;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = {"http://localhost:8080","http://localhost:3000"})
public class PassengerController {
    private final PassengerService service;
    
    @Autowired
    public PassengerController (PassengerService srv){
        this.service=srv;
    }
  

    //Crear
    @PostMapping("/requests")
    public ResponseEntity<PassengerDTO> create(@Valid @RequestBody NewPassenger passengerDTO) {
        PassengerDTO result=service.create(passengerDTO);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    //Listar
    @GetMapping() 
    public ResponseEntity<List<PassengerDTO>> list(){
        List<PassengerDTO> result  = service.list();
        return ResponseEntity.ok().body(result);        
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassengerDTO> retrive(@PathVariable("id") Long id){
        PassengerDTO result = service.retrieve(id);
        return ResponseEntity.ok().body(result);        
    }

    @PutMapping("/reserve")
    public ResponseEntity<PassengerDTO> reserve(@PathVariable("id") Long id,@RequestBody PassengerDTO passengerDTO ){
        PassengerDTO result = service.reserve(passengerDTO, id);
        return ResponseEntity.ok().body(result);
    }


}
