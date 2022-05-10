package com.giantLink.user.request;


public record UserRequest(
        String firstName,
        String lastName,
        String email
) {

}
