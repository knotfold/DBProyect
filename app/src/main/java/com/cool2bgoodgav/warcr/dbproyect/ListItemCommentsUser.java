package com.cool2bgoodgav.warcr.dbproyect;

/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemCommentsUser {

    private String IdComentario;
    private String ComentarioRes;
    private  String NombreCliente;

    public ListItemCommentsUser(String idComentario, String comentarioRes, String nombreCliente) {
        IdComentario = idComentario;
        ComentarioRes = comentarioRes;
        NombreCliente = nombreCliente;
    }

    public String getIdComentario() {
        return IdComentario;
    }

    public String getComentarioRes() {
        return ComentarioRes;
    }

    public String getNombreCliente() {
        return NombreCliente;
    }
}

