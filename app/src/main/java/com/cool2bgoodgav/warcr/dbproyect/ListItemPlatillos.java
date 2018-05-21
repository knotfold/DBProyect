package com.cool2bgoodgav.warcr.dbproyect;

/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemPlatillos {

    private String NombrePlatillo;
    private  String CostoPlatillo;
    private String TipoPlatillo;
    private String DescripcionPlatillo;

    public ListItemPlatillos(String nombrePlatillo, String costoPlatillo, String tipoPlatillo, String descripcionPlatillo) {
        NombrePlatillo = nombrePlatillo;
        CostoPlatillo = costoPlatillo;
        TipoPlatillo = tipoPlatillo;
        DescripcionPlatillo = descripcionPlatillo;
    }

    public String getNombrePlatillo() {
        return NombrePlatillo;
    }

    public String getCostoPlatillo() {
        return CostoPlatillo;
    }

    public String getTipoPlatillo() {
        return TipoPlatillo;
    }

    public String getDescripcionPlatillo() {
        return DescripcionPlatillo;
    }
}

