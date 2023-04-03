package com.userlogin;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PlaySong {
    static String path;
    public static void toPlaySongs() throws SQLException, LineUnavailableException, UnsupportedAudioFileException, IOException {
        System.out.println("Available Songs");
        System.out.println("******************");
        System.out.println("Please Enter Song_Id to play the song");
        System.out.println("Song_Id    SongName");
        System.out.println("*********************");
        Statement st = User.connection();
        ResultSet r=st.executeQuery("select * from playSong");
            while (r.next()){
                System.out.format("  %d     %s ",r.getInt(1),r.getString(2));
                System.out.println();
            }
            System.out.println("select song_id");
            Scanner sc=new Scanner(System.in);
            int song_id=sc.nextInt();
            ResultSet r1=st.executeQuery("select * from playSong where song_id="+song_id+"");
            while (r1.next()){
                path="C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\"+r1.getString(3)+".wav";
            }
            File file = new File(path);
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            clip.open(audioStream);
            int input;
            int flag = 0;
            long clipPosition = 0;
            while (flag == 0)
            {
                System.out.println("\nEnter Your Choice\n----- ---- ------\n 1. Play\n 2. Pause\n 3. Resume\n 4. Restart\n 5. Forward\n 6.Backwards\n  9. Exit");

                input = sc.nextInt();
                switch (input) {
                    case 1:
                        clip.start();
                        System.out.println("+------------+");
                        System.out.println("|Playing Song|");
                        System.out.println("+------------+");
                        break;
                    case 2:
                        clipPosition = clip.getMicrosecondPosition();
                        clip.stop();
                        System.out.println("+-----------+");
                        System.out.println("|Song Paused|");
                        System.out.println("+-----------+");
                        break;
                    case 3:
                        clip.setMicrosecondPosition(clipPosition);
                        clip.start();
                        System.out.println("+------------+");
                        System.out.println("|Song Resumed|");
                        System.out.println("+------------+");
                        break;
                    case 4:
                        clip.setMicrosecondPosition(0);
                        clip.start();
                        System.out.println("+--------------+");
                        System.out.println("|Song Restarted|");
                        System.out.println("+--------------+");
                        break;
                    case 5:
                        System.out.println("+-----------------+");
                        System.out.println("|Forwarding by 50s|");
                        System.out.println("+-----------------+");
                        clip.setMicrosecondPosition(clip.getMicrosecondPosition() + 5000000);
                        break;
                    case 6:
                        System.out.println("+-----------------+");
                        System.out.println("|Backward by 50s|");
                        System.out.println("+-----------------+");
                        clip.setMicrosecondPosition(clip.getMicrosecondPosition() - 5000000);
                        break;

                    case 9:
                        clip.close();
                        flag = 1;
                        break;
                    default:
                        System.out.println("Not a valid Input");
                }
            }
//        } catch (UnsupportedAudioFileException e) {
//            throw new RuntimeException(e);
//        } catch (SQLException e) {
////           // throw new RuntimeException(e);
////        } catch (LineUnavailableException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
