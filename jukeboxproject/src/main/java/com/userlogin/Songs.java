package com.userlogin;

public class Songs {
    private int song_id;
    private String song_name;
    private String genre;
    private String artist;
    private String songPath;


    public Songs(int song_id,String song_name, String genre,String artist ,String songPath) {
        this.song_id=song_id;
        this.song_name = song_name;
        this.genre = genre;
        this.artist=artist;
        this.songPath=songPath;
    }
    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }
    public String getSong_name() {
        return song_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
    @Override
    public String toString() {
        return "Songs{" +
                "song_name='" + song_name + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", songPath='" + songPath + '\'' +
                '}';
    }
}
