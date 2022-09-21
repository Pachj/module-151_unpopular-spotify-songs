-- expects the csv on the classpath (src/main/resources)
INSERT INTO ARTIST_GENRE_ENTITY (ARTIST_NAME, GENRE)
SELECT DISTINCT artist_name, genre
FROM CSVREAD('src/main/resources/z_genre_of_artists.csv');

INSERT INTO SONG_ENTITY (TRACK_ID, DANCEABILITY, ENERGY, SPEECHINESS, ACOUSTICNESS, INSTRUMENTALNESS, TEMPO, TRACK_NAME, TRACK_ARTIST_ARTIST_NAME)
SELECT track_id, danceability, energy, speechiness, acousticness, instrumentalness, tempo, track_name, track_artist
FROM CSVREAD('src/main/resources/songs.csv');
