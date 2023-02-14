package ec.DTO;

import ec.Models.enumeration.PassengerStatus;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class NewPassenger {
    private String passenger;
    private String destination;
    private PassengerStatus status;
    private String comentario;


    
}
