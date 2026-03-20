package com.example.DinhHuuMinhLoc.profile;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record SaveProfileRequest(
		@NotBlank String fullName,
		@NotBlank String studentId,
		@NotBlank String major,
		@NotNull @NotEmpty List<@NotBlank String> interests
) {}

