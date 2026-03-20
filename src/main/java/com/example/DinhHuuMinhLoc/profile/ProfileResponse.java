package com.example.DinhHuuMinhLoc.profile;

import java.time.Instant;

public record ProfileResponse(
		Long id,
		String fullName,
		String studentId,
		String major,
		String interests,
		Instant createdAt
) {
	static ProfileResponse from(ProfileEntity entity) {
		return new ProfileResponse(
				entity.getId(),
				entity.getFullName(),
				entity.getStudentId(),
				entity.getMajor(),
				entity.getInterests(),
				entity.getCreatedAt()
		);
	}
}

