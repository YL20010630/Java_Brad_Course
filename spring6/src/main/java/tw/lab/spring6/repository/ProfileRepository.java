package tw.lab.spring6.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.lab.spring6.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long>{

}