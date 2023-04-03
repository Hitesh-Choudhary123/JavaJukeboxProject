package com.userlogin;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Playlist {
    public void toCreatePlaylist() throws InvalidEntryException{
        Scanner sc=new Scanner(System.in);
        try {
            System.out.println("Please enter the Playlist Name");
            String Playlist_name = sc.next();
            Statement st = User.connection();
            ResultSet r = st.executeQuery("select * from songs");
            System.out.println("Song_Id   Song_name");
            System.out.println("***********************");
            while (r.next()) {
                System.out.format("  %d       %s", r.getInt(1), r.getString(2));
                System.out.println();
            }
            System.out.println("Please enter the song_id");
            int song_id = sc.nextInt();
            if(song_id<1 || song_id>6){
                throw new InvalidEntryException();
            }
            st.executeUpdate("insert into playlist values(" + song_id + ",'" + Playlist_name + "')");
            System.out.println("***********************************");
            System.out.println("Your song is added to playlist");
            System.out.println("***********************************");
            System.out.println("Enter 1 to add more songs, 2 to return to main list");
            int playlist = sc.nextInt();
            int flag = 0;
            while (flag == 0) {
                switch (playlist) {
                    case 1:
                        System.out.println("Please enter the song_id");
                        System.out.println("*****************************");
                        ResultSet r1 = st.executeQuery("select * from songs");
                        while (r1.next()) {
                            System.out.format(" %d      %s", r1.getInt(1), r1.getString(2));
                            System.out.println();
                        }
                        int id = sc.nextInt();
                        ResultSet s = st.executeQuery("select * from playlist where song_id=" + id + " and Playlist_name='" + Playlist_name + "' ");
                            if (s.next()) {
                                System.out.println("********************************************");
                                System.out.println("Your song is already exists in the playlist");
                                System.out.println("********************************************");
                                System.out.println("Please enter 0 to continue, 1 to return to main list");
                            } else {
                                st.executeUpdate("insert into playlist values(" + id + ",'" + Playlist_name + "')");
                                System.out.println("***********************************");
                                System.out.println("Your song is added to the list");
                                System.out.println("***********************************");
                                System.out.println("Please enter 0 to continue, 1 to return to main list");
                            }
                            Scanner sc2 = new Scanner(System.in);
                            int number = sc2.nextInt();
                            SongsImpl m = new SongsImpl();
                            m.displayAllSongs();
                            if (number == 1)
                                flag = number;
                            break;
                    case 2:
                        SongsImpl m1 = new SongsImpl();
                        m1.displayAllSongs();
                        break;
                        }

                    }

                }
                        catch(SQLException e){
                        throw new RuntimeException(e);
        }

    }
}
