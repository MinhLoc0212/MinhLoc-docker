package com.example.DinhHuuMinhLoc.profile;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {
	Optional<ProfileEntity> findTopByOrderByCreatedAtDesc();
}

