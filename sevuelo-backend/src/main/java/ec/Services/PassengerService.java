package ec.Services;

import java.util.List;

import ec.DTO.NewPassenger;
import ec.DTO.PassengerDTO;

public interface PassengerService {
public PassengerDTO create(NewPassenger newPassanger);
public List<PassengerDTO> list(); 
public PassengerDTO retrieve (Long id);
public PassengerDTO reserve (PassengerDTO passengerDTO, Long id);

    
}
