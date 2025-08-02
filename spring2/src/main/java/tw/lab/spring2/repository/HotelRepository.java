package tw.lab.spring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.lab.spring2.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{

}