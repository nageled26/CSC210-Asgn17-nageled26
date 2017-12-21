package com.example.dnage.songguessinggame;

import java.io.Serializable;

public abstract class AppInfo implements Serializable{

    public String getApiKey(){return "NTFiZTYwN2MtNzg3MC00YjFmLWFjMGUtODlmYWE1MDYyYTkz";}
    public String getSecret(){return "ODFiMzg3MDktM2NmMC00NzY0LTk4ZGYtMTgxMDVmZjA0ODYz";};
    public String getRedirectUrl(){return "getrandomsong";}

}