package com.example.dnage.songguessinggame;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.EditText;

import com.napster.cedar.Napster;
import com.napster.cedar.internal.AppInfo;
import com.napster.cedar.player.Player;
import com.napster.cedar.player.data.Track;
import com.napster.cedar.player.data.Track.Format;
import com.napster.cedar.player.notification.NotificationAction;
import com.napster.cedar.session.SessionManager;

import java.util.LinkedList;
import java.util.List;

//import kaaes.spotify.webapi.android.*;

/**
 * Created by dnage on 11/21/2017.
 */

public class MainActivity extends AppCompatActivity {
    private Napster napster;
    private SessionManager sessionManager;
    //NapsterLoginDialogFragment loginDialog;
    AppInfo appInfo;
    NapsterApplication app;
    Player player;

    EditText title;
    EditText author;
    EditText album;
    ImageButton musicNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        title = (EditText) findViewById(R.id.SongName);
        author = (EditText) findViewById(R.id.SongArtist);
        album = (EditText) findViewById(R.id.SongAlbum);
        musicNote = (ImageButton) findViewById(R.id.imageButton);

        final String[][] list = new String[20][];
        final Uri.Builder builder = new Uri.Builder();
        //napster=Napster.register(this,app.getApiKey(),app.getSecret());
        //player=napster.getPlayer();
        //sessionManager=napster.getSessionManager();
        //app = (NapsterApplication) getApplication();
        app=new NapsterApplication() {
            @Override
            public AppInfo getAppInfo() {
                return new AppInfo(getApiKey(),getApiKey());
            }

            @Override
            public void onNotificationAction(NotificationAction notificationAction) {

            }
        };
        napster = app.getNapster();
        appInfo = app.getAppInfo();
        sessionManager = app.getSessionManager();
        player=app.getPlayer();

        musicNote.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //When the button is clicked
                // handle result..
                List<Format> list = new LinkedList<Format>();
                Format format1 = new Format(320, "AAC");
                Format format2 = new Format(192, "AAC");
                Format format3 = new Format(64, "AAC PLUS");

               // Track.Links links =new Track.Links();
                //{"type":"format","bitrate":320,"name":"AAC"},{"type":"format","bitrate":192,"name":"AAC"},{"type":"format","bitrate":64,"name":"AAC PLUS"}]));
                //{"artists":{"ids":["art.954"],"href":"https://api.napster.com/v2.2/artists/art.954"},"albums":{"ids":["alb.5153820"],"href":"https://api.napster.com/v2.2/albums/alb.5153820"}
                Track track=new Track("track", "tra.5156528", "Say It Ain't So", "Weezer", "Weezer (Blue Album) (Deluxe Edition)", list, "alb.5153820",null, "http://listen.vo.llnwd.net/g2/4/2/4/9/8/911189424.mp3", 30);
                player.play(track);
                author.setText(player.getCurrentTrack().artistName);
                title.setText(player.getCurrentTrack().name);
                album.setText(player.getCurrentTrack().albumName);
                int offset = (int) (8900000 * (Math.random()));
            }
        });


    }
}





