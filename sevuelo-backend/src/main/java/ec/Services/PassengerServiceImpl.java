package ec.Services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.DTO.NewPassenger;
import ec.DTO.PassengerDTO;
import ec.Exceptions.ResourceNotFoundException;
import ec.Models.Passenger;
import ec.Repository.PassengerRepository;

@Service
public class PassengerServiceImpl implements PassengerService {

    final ModelMapper modelMapper;
    final PassengerRepository  passengerRepository;


    @Autowired
    public PassengerServiceImpl(@Autowired PassengerRepository repository, ModelMapper mapper){
        this.passengerRepository = repository;
        this.modelMapper=mapper;
      
    }

    //Crear
    @Override
    @Transactional
    public PassengerDTO create(NewPassenger passengerDTO){
        Passenger passenger =modelMapper.map(passengerDTO, Passenger.class);
        passengerRepository.save(passenger);
        return modelMapper.map(passenger,PassengerDTO.class);
        
        
    }

    //Listar
    @Override
    @Transactional(readOnly = true)
    public List<PassengerDTO> list(){
        List<Passenger> passengers = passengerRepository.findAll();
        return passengers.stream().map(passenger -> modelMapper.map(passenger, PassengerDTO.class))
        .collect(Collectors.toList());
    }

    //Consultar
    @Override
    @Transactional(readOnly = true)
    public PassengerDTO retrieve(Long id){
        Passenger passenger = passengerRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("Passenger not found"));
        return modelMapper.map(passenger, PassengerDTO.class);
    }

    //Actualizar
    @Override
    @Transactional
    public PassengerDTO reserve(PassengerDTO passengerDTO, Long id) {
        Passenger passenger = passengerRepository.findById(id)
        .orElseThrow(()-> new ResourceNotFoundException("passenger not found"));
        passenger.setId(id);
        passenger = modelMapper.map(passengerDTO, Passenger.class);
        passengerRepository.save(passenger);
        return modelMapper.map(passenger, PassengerDTO.class);
    }

    
}
