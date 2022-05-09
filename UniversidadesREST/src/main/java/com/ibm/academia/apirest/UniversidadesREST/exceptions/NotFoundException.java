package com.ibm.academia.apirest.UniversidadesREST.exceptions;

public class NotFoundException extends RuntimeException
{
    public NotFoundException(String message){
        super(message);

    }


    private static final long serialVersionUID = -692083794584032204L;
}
