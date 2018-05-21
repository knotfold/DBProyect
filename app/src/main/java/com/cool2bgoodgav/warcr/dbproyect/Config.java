package com.cool2bgoodgav.warcr.dbproyect;

/**
 * Created by warcr on 16/11/2017.
 */

public class Config {
    //Address of our scripts of the CRUD
    public static final String URL_ADD="http://knotfold.x10host.com/addEmpEx2.php";
    public static final String URL_ADD_ADMIN= "http://10.0.2.2:81/dbproject/add_admon.php ";
    public static final String URL_ADD_CLIENTE= "http://10.0.2.2:81/dbproject/add_cliente.php ";
    public static final String URL_ADD_RES= "http://10.0.2.2:81/dbproject/add_res.php ";
    public static final String URL_ADD_PROM= "http://10.0.2.2:81/dbproject/add_promo.php ";
    public static final String URL_ADD_COMMENT= "http://10.0.2.2:81/dbproject/add_comment.php ";

    public static final String URL_LOGIN_USER= "http://10.0.2.2:81/dbproject/login_user.php ";
    public static final String URL_LOGIN_USER_RESULT= "http://10.0.2.2:81/dbproject/login_user_result.php?NombreCliente=";
    public static final String URL_GET_RES= "http://10.0.2.2:81/dbproject/get_res.php";

    //WEB ADRESS
    public static final String URL_LOGIN_USER_RESULT_WEB= "https://knotfoldbase.000webhostapp.com/login_user_result.php?NombreCliente=";
    public static final String URL_ADD_COMMENT_WEB= "https://knotfoldbase.000webhostapp.com/add_comment.php";
    public static final String URL_ADD_CLIENTE_WEB= "https://knotfoldbase.000webhostapp.com/add_cliente.php";
    public static final String URL_UPDATE_USER_COMMENT = "https://knotfoldbase.000webhostapp.com/update_user_comment.php";
    public static final String URL_ADD_RES_WEB= "https://knotfoldbase.000webhostapp.com/add_res.php";
    public static final String URL_ADD_PROM_WEB= "https://knotfoldbase.000webhostapp.com/add_promo.php ";

    //Keys that will be used to send the request to php scripts
    //Tabla admin
    public static final String KEY_EMP_NombreAdmin = "NombreAdmin";
    public static final String KEY_EMP_ContrasenaAdmin = "ContrasenaAdmin";
    //Tabla Cliente
    public static String KEY_EMP_IdCliente = "IdCliente";
    public static final String KEY_EMP_IdCliente_Coment = "IdCliente";
    public static final String KEY_EMP_NombreCliente = "NombreCliente";
    public static final String KEY_EMP_ContrasenaCliente = "ContrasenaCliente";
    //Tabla Restaurante
    public static final String KEY_EMP_IdRestaurante = "IdRestaurante";
    public static final String KEY_EMP_NombreRes = "NombreRes";
    public static final String KEY_EMP_UbicacionRes = "UbicacionRes";
    public static final String KEY_EMP_HorarioRes = "HorarioRes";
    public static final String KEY_EMP_AforoRes = "AforoRes";
    public static final String KEY_EMP_TipoRes = "TipoRes";
    public static final String KEY_EMP_ContactoRes = "ContactoRes";
    //Tabla Promo
    public static final String KEY_EMP_URLPromo = "imagen";
    public static final String KEY_EMP_Restaurante_IdRestaurante = "Restaurante_IdRestaurante";

    //Tabla Comment
    public static final String KEY_EMP_IdComentario = "IdComentario";
    public static final String KEY_EMP_ComentarioRes = "ComentarioRes";






    //JSON Tags login user
    public static final String TAG_JSON_ARRAY_LOGIN_USER="result";
    public static final String TAG_ID_CLIENTE="IdCliente";
    public static final String TAG_NOMBRE_CLIENTE="NombreCliente";
    public static final String TAG_CONTRASENA_CLIENTE="ContrasenaCliente";

    //JSON TAGS RES
    public static final String TAG_JSON_ARRAY_RES="result";
    public static final String TAG_ID_RESTAURANTE = "IdRestaurane";
    public static final String TAG_NOMBRE_RES = "NombreRes";
    public static final String TAG_UBICACION_RES = "UbicacionRes";
    public static final String TAG_HORARIO_RES = "HorarioRes";
    public static final String TAG_AFORO_RES = "AforoRes";
    public static final String TAG_TIPO_RES = "TipoRes";
    public static final String TAG_CONTACTO_RES = "ContactoRes";


    //employee id to pass with intent
    public static final String EMP_IDC = "emp_idc";
    public static final String EMP_IDR = "emp_idR";

    //PASS RES
    public static final String EMP_IdRestaurante = "IdRestaurane";
    public static final String EMP_NombreRes = "NombreRes";
    public static final String EMP_UbicacionRes = "UbicacionRes";
    public static final String EMP_HorarioRes = "HorarioRes";
    public static final String EMP_AforoRes = "AforoRes";
    public static final String EMP_TipoRes = "TipoRes";
    public static final String EMP_ContactoRes = "ContactoRes";
    public static final String EMP_image= "image";
}
