package com.example.dnage.songguessinggame;

import android.app.Application;

import com.napster.cedar.Napster;
import com.napster.cedar.internal.AppInfo;
import com.napster.cedar.player.Player;
import com.napster.cedar.player.notification.NotificationActionListener;
import com.napster.cedar.session.SessionManager;

/**
 * Created by dnage on 12/17/2017.
 */

public abstract class NapsterApplication extends Application implements NotificationActionListener {
    protected Napster napster;
    protected Player player;
    protected SessionManager sessionManager;

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            napster = Napster.register(this, getApiKey(), getSecret());
        } catch (IllegalStateException e) {
            return;
        }
        player = napster.getPlayer();


        //player.setNotificationProperties(new NotificationProperties());
        player.registerNotificationActionListener(this);
        sessionManager = napster.getSessionManager();
    }

    public Napster getNapster() {
        return napster;
    }

    public String getApiKey(){ return "NTFiZTYwN2MtNzg3MC00YjFmLWFjMGUtODlmYWE1MDYyYTkz";}

    public String getSecret(){return "ODFiMzg3MDktM2NmMC00NzY0LTk4ZGYtMTgxMDVmZjA0ODYz" ;}

    public String getRedirectUrl(){return "getrandomsong";}

    public Player getPlayer() {
        return player;
    }

    public SessionManager getSessionManager() {
        return sessionManager;
    }

    public abstract AppInfo getAppInfo();

}
