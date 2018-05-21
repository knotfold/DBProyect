package com.cool2bgoodgav.warcr.dbproyect;

/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemComments {

    private String ComentarioRes;
    private  String NombreCliente;

    public ListItemComments(String comentarioRes, String nombreCliente) {
        ComentarioRes = comentarioRes;
        NombreCliente = nombreCliente;
    }

    public String getComentarioRes() {
        return ComentarioRes;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }
}

