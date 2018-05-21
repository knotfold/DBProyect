package com.cool2bgoodgav.warcr.dbproyect;

/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemRes {

    private String IdRestaurante;
    private  String NombreRes;
    private String UbicacionRes;
    private String HorarioRes;
    private String AforoRes;
    private String TipoRes;
    private String ContactoRes;
    private String imageUrl;

    public ListItemRes(String idRestaurante, String nombreRes, String ubicacionRes, String horarioRes, String aforoRes, String tipoRes, String contactoRes, String imageUrl) {
        IdRestaurante = idRestaurante;
        NombreRes = nombreRes;
        UbicacionRes = ubicacionRes;
        HorarioRes = horarioRes;
        AforoRes = aforoRes;
        TipoRes = tipoRes;
        ContactoRes = contactoRes;
        this.imageUrl = imageUrl;
    }

    public String getIdRestaurante() {
        return IdRestaurante;
    }

    public String getNombreRes() {
        return NombreRes;
    }

    public String getUbicacionRes() {
        return UbicacionRes;
    }

    public String getHorarioRes() {
        return HorarioRes;
    }

    public String getAforoRes() {
        return AforoRes;
    }

    public String getTipoRes() {
        return TipoRes;
    }

    public String getContactoRes() {
        return ContactoRes;
    }


    public String getImageUrl()
    {
        return imageUrl;
    }
}

