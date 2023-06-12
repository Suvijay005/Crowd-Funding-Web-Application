package com.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.app.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
 Optional<User> findByEmail(String email);
	
	@Modifying
	@Query("update user u set u.firstName=?1, u.lastName=?2, u.email=?3, u.mobileNo=?4, u.address=?5, u.city=?6, u.state=?7, u.country=?8, u.pincode=?9 where u.id=?10")
	int updateProfile(String firstName, String lastName, String email, String mobileNo, String address, String city, String state, String country, String pincode, Long id);
}
