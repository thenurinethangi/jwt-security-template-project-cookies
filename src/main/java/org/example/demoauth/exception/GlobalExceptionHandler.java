package org.example.demoauth.exception;

import org.example.demoauth.dto.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIResponse handleAllException(RuntimeException e){
        return new APIResponse(500,"Internal Server Error",e.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public APIResponse handleAccessDeniedException(AccessDeniedException e){
        return new APIResponse(403,"You are not allow to access this/Access Denied",e.getMessage());
    }

    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleAuthenticationException(AuthenticationException e){
        return new APIResponse(401,"Please Login First",e.getMessage());
    }

    @ExceptionHandler(InsufficientAuthenticationException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public APIResponse handleInsufficientAuthenticationException(InsufficientAuthenticationException e){
        return new APIResponse(401,"Please Login First",e.getMessage());
    }
}

































