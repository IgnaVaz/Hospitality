package com.hospitality.api.entity;

import java.util.UUID;

public class ResponseBase {
    private String mensaje = "";
    private String folio = "";


    public String getMensaje() {
        mensaje = "Operación Exitosa.";
        return mensaje;
    }

    public String getFolio() {
        folio = Folio();
        return folio;
    }

    public static String Folio() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public ResponseBase(){};

    public ResponseBase(Object resultado)
    {
        super();
    };
}
