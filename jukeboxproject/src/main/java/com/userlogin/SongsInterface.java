package com.userlogin;

import java.util.List;

public interface SongsInterface {
    public  List<Songs> displayAllSongs();
    public  List<Songs> searchByGenre(List<Songs> songslist,String genre);
    public  List<Songs> searchByArtist(List<Songs> songslist,String artist);
    public  List<Songs> searchBySongName(List<Songs> songslist,String name);
}
