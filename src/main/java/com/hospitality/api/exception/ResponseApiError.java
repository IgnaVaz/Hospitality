package com.hospitality.api.exception;

import java.util.ArrayList;

public class ResponseApiError {
    private String codigo = "";
    private String mensaje = "";
    private String folio = "";
    private String info = "";
    private ArrayList<String> detalles = new ArrayList<>();

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public ArrayList<String> getDetalles() {
        return detalles;
    }

    public void setDetalles(ArrayList<String> detalles) {
        this.detalles = detalles;
    }

    public ResponseApiError(String codigo, String mensaje, String folio, String info, ArrayList<String> detalles) {
        super();
        this.codigo = codigo;
        this.mensaje = mensaje;
        this.folio = folio;
        this.info = "https://kleverness-developer.com.mx/info#"+codigo;
        this.detalles = detalles;
    }
}
