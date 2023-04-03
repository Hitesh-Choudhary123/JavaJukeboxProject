create database jukeboxdb;
use jukeboxdb;
drop database jukeboxdb;
create table customer(firstName varchar(50),lastName varchar(50),userName varchar(50), password varchar(50));
select * from customer;
drop table customer;
create table songs(song_id int primary key,song_name varchar(50));
insert into songs values(1,"Pasoori");
insert into songs values(2,"Ae Dil Hai Mushkil");
insert into songs values(3,"Lean On");
insert into songs values(4,"Bella Ciao");
insert into songs values(5,"Aankhon Aankhon");
insert into songs values(6,"2 Bhai");
-- update songs set song_id=7 where song_name="Lean on";
select * from songs;
drop table songs;
create table playlist(song_id int,Playlist_name varchar(50));
insert into playlist values(1,"Hitesh");
select * from playlist;
drop table playlist;
create table playSong(song_id int , song_name varchar(50),songPath varchar(200));
insert into playSong values(1,"Pasoori","Pasoori");
insert into playSong values(2,"Ae Dil Hai Mushkil","05 Ae Dil Hai Mushkil Title Track - Arijit Singh 190Kbps");
insert into playSong values(3,"Lean On","Lean On (Feat. Mo N Dj Snake) Major Lazer 190kbps");
insert into playSong values(4,"Bella Ciao","Bella Ciao(PagalWorld.com.se)");
insert into playSong values(5,"Aankhon Aankhon","03 Aankhon Aankhon (Bhaag Johnny) 320Kbps");
insert into playSong values(6,"2 Bhai","2 Bhai - Kambi Rajpuria");
select * from playSong;
drop table playSong;