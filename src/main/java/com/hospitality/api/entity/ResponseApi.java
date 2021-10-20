package com.hospitality.api.entity;

public class ResponseApi extends ResponseBase{
    private Object resultado;

    public Object getResultado() {
        return resultado;
    }
    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }


    public ResponseApi(Object object) {
        super();
        this.resultado = object;
    }
	
}
