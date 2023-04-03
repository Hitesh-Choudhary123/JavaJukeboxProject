package com.userlogin;

import java.util.*;

public class SongsImpl implements SongsInterface {
    //Scanner sc=new Scanner(System.in);

    public List<Songs> displayAllSongs() {
        List<Songs> songslist=new ArrayList<>();
        Songs s1=new Songs(1,"Pasoori","Romantic","Shae Gill","C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\Pasoori.wav");
        Songs s2=new Songs(2,"Ae Dil Hai Mushkil","Romantic","Arijit Singh","C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\05 Ae Dil Hai Mushkil Title Track - Arijit Singh 190Kbps.wav");
        Songs s3=new Songs(3,"Lean On","Rock","Major Lazer","C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\Lean On (Feat. Mo N Dj Snake) Major Lazer 190kbps.wav");
        Songs s4=new Songs(4,"Bella Ciao","Rock","Manu pilas","C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\Bella Ciao(PagalWorld.com.se).wav");
        Songs s5=new Songs(5,"Aankhon Aankhon","Hindi","Yo Yo Honey Singh","C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\03 Aankhon Aankhon (Bhaag Johnny) 320Kbps.wav");
        Songs s6=new Songs(6,"2 Bhai","Punjabi","Kambi","C:\\intellij\\JAVA\\Test\\Project\\JukeBoxProject\\src\\main\\resources\\2 Bhai - Kambi Rajpuria.wav");
        songslist.addAll(Arrays.asList(s1,s2,s3,s4,s5,s6));
        Iterator<Songs> I=songslist.iterator();
            System.out.println("Song name                        SongGenre                     SongAlbumArtist");
            System.out.println("***********************************************************************************");
        while (I.hasNext()){
            Songs S=I.next();
            System.out.println(S.getSong_name() + "          " +S.getGenre()+  "               " +S.getArtist());
            System.out.println("***********************************************************************************");
        }
        return songslist;
    }

    public List<Songs> searchByGenre(List<Songs> songslist,String genre) {
        Iterator<Songs> i=songslist.iterator();
        while (i.hasNext()){
            Songs s=i.next();
            if(s.getGenre().equalsIgnoreCase(genre)) {
                System.out.println(s.getSong_name());
            }
        }
        return songslist;
    }

    public List<Songs> searchByArtist(List<Songs> songslist,String artist) {
//        Iterator<Songs> i1=songslist.iterator();
//        while (i1.hasNext()){
//            Songs s=i1.next();
//            System.out.println(s.getArtist());
//        }
        Iterator<Songs> i1=songslist.iterator();
        while (i1.hasNext()){
            Songs s1=i1.next();
            if(s1.getArtist().equalsIgnoreCase(artist)){
                System.out.println(s1.getSong_name());
            }
        }
        return songslist;
    }

    public List<Songs> searchBySongName(List<Songs> songslist,String name) {
        Iterator<Songs> i2=songslist.iterator();
        while (i2.hasNext()){
            Songs s2=i2.next();
            if(s2.getSong_name().equalsIgnoreCase(name)){
                System.out.println(s2.getSong_name());
            }
        }
        return songslist;
    }
//    public static void toDisplayTheWholelist(){
//        System.out.println("Please select the below options :");
//        System.out.println("***********************************");
//        System.out.println("1. Display songs");
//        System.out.println("2. Create playlist");
//        System.out.println("3. To play songs");
//        System.out.println("4. Exit");
//        Scanner sc=new Scanner(System.in);
//        int i=sc.nextInt();
//        switch (i){
//            case 1:
//                System.out.println("Select the below options");
//                System.out.println("*************************");
//                System.out.println("1. To Display all songs");
//                System.out.println("2. Search song by Genre");
//                System.out.println("3. Search song by Artist");
//                System.out.println("4. To go back");
//                int j=sc.nextInt();
//                switch (j){
//                    case 1 :
//                        displayAllSongs();
//                        break;
//                    case 2:
//                        searchByGenre(songslist,g)
//                }
      // }
    //}
}
