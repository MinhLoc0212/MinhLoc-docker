package com.example.DinhHuuMinhLoc.profile;

import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

	private final ProfileRepository repository;

	public ProfileController(ProfileRepository repository) {
		this.repository = repository;
	}

	@PostMapping
	public ResponseEntity<ProfileResponse> save(@Valid @RequestBody SaveProfileRequest request) {
		ProfileEntity entity = new ProfileEntity();
		entity.setFullName(request.fullName().trim());
		entity.setStudentId(request.studentId().trim());
		entity.setMajor(request.major().trim());
		entity.setInterests(String.join(", ", request.interests().stream().map(String::trim).toList()));

		ProfileEntity saved = repository.save(entity);
		return ResponseEntity.created(URI.create("/api/profile/" + saved.getId())).body(ProfileResponse.from(saved));
	}

	@GetMapping("/latest")
	public ResponseEntity<ProfileResponse> latest() {
		return repository.findTopByOrderByCreatedAtDesc()
				.map(ProfileResponse::from)
				.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
}

