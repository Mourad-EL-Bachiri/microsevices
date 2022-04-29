package com.giantLink.user.response;

public record UserResponse(
        Integer id,
        String firstName,
        String lastName,
        String email
) {
}
