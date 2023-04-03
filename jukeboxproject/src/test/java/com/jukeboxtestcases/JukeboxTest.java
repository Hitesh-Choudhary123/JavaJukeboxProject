package com.jukeboxtestcases;

import com.userlogin.InvalidEntryException;
import com.userlogin.Playlist;
import com.userlogin.Songs;
import com.userlogin.SongsImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JukeboxTest {
    SongsImpl s;
    static Playlist p;

    @BeforeEach
    void setUp(){
        SongsImpl s=new SongsImpl();
        Playlist p=new Playlist();
    }
    @AfterEach
    void tearDown() {
        s=null;
        p=null;
    }
//    @Test
//    public static void displayPlayList() throws InvalidEntryException {
//        assertEquals(1,p.toCreatePlaylist().get(0).getSong_id());
//        assertEquals(4,p.toCreatePlaylist().get(2).getSong_id());
//    }
    @Test
    public void songsTest() throws ClassNotFoundException, SQLException {
        List<Songs> songsList=s.displayAllSongs();
        int total=0,total1=0,total2=0;
        Iterator<Songs> i=songsList.iterator();
        while (i.hasNext()){
            Songs s1=i.next();
            if(s1.getGenre().equalsIgnoreCase("Romantic")){
                total++;
            }
            if (s1.getArtist().equalsIgnoreCase("Shae gill")){
                total1++;
            }
            if (s1.getSong_name().equalsIgnoreCase("Pasoori")){
                total2++;
            }
            assertEquals(2,total);
            assertEquals(1,total1);
            assertEquals(1,total2);

        }


    }


}
