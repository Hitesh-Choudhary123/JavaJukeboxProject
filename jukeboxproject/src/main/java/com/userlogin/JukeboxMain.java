package com.userlogin;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import static com.userlogin.PlaySong.toPlaySongs;
import static com.userlogin.User.checkuser;
import static com.userlogin.User.newUser;

public class JukeboxMain {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException,InvalidEntryException {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("******** Welcome to JukeBox *******");
        Scanner sc=new Scanner(System.in);
        System.out.println("1. Create an account \n2. Login ");
        int answer=sc.nextInt();

        switch (answer){
            case 1: {
                System.out.println("Enter the firstname");
                String firstName=sc.next();
                System.out.println("Enter the lastname");
                String lastName=sc.next();
                System.out.println("Enter the username");
                String userName=sc.next();
                System.out.println("Enter the password");
                String password=sc.next();
                System.out.println("--------------------------------------------");
                System.out.println("  New User account created successfully");
                System.out.println("--------------------------------------------");
                newUser(firstName,lastName,userName,password);
                break;
            }
            case 2: {
                System.out.println("Enter the username");
                String userName=sc.next();
                System.out.println("Enter the password");
                String password=sc.next();
                checkuser(userName,password);
                break;
            }
        }
        SongsImpl l=new SongsImpl();
        List<Songs> e=l.displayAllSongs();
        Scanner obj=new Scanner(System.in);
        System.out.println("1. Search by Genre");
        System.out.println("2. Search by Artist");
        System.out.println("3. Search by Song Name");
        int option=obj.nextInt();
        if(option==1){
            Scanner obj1=new Scanner(System.in);
            System.out.println("Enter the genre name");
            String genre=obj1.nextLine();
            l.searchByGenre(e,genre);
        }
        else if(option==2){
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter the artist name");
            String artist=sc1.nextLine();
            l.searchByArtist(e,artist);
        }
        else if (option==3){
            Scanner sc1=new Scanner(System.in);
            System.out.println("Enter the song name");
            String name=sc1.nextLine();
            l.searchBySongName(e,name);
            System.out.println("***************************");
        }
        else {
            System.out.println("Invalid Entry");
        }
        Playlist p=new Playlist();
        p.toCreatePlaylist();
          toPlaySongs();
    }
}
