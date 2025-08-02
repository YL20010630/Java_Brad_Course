package tw.lab.spring4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.lab.spring4.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}
