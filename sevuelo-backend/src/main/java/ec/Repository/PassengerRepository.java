package ec.Repository;

import ec.Models.Passenger;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring Data SQL repository for the Request entity.
 */
@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

  
   
}
