package com.enterprise.gateway.exception;

public class RouteNotFoundException extends RuntimeException {

    public RouteNotFoundException(String path) {
        super("Route not found : " + path);
    }

}


