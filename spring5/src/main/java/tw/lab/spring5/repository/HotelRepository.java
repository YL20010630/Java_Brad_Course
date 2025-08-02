package tw.lab.spring5.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tw.lab.spring5.entity.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	@Query("""
			SELECT h
			FROM Hotel h
			WHERE h.name LIKE %:name%
				AND h.addr LIKE %:addr%
				AND h.tel LIKE %:tel%
			""")
	List<Hotel> findByNameAndAddrAndTel(
			@Param("name") String name,
			@Param("addr") String addr,
			@Param("tel") String tel
			);
	
}