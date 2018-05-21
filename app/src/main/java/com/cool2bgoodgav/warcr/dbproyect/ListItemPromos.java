package com.cool2bgoodgav.warcr.dbproyect;

/**
 * Created by warcr on 05/12/2017.
 */

public class ListItemPromos {

    private String IdProm;
    private String imageUrl;

    public ListItemPromos(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getIdProm() {
        return IdProm;
    }

    public String getImageUrl()
    {
        return imageUrl;
    }
}

