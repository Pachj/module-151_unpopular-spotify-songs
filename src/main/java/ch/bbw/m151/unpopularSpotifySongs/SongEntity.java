package ch.bbw.m151.unpopularSpotifySongs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SongEntity {
    @Id
    private String trackId;
    private double danceability;
    private double energy;
    private double speechiness;
    private double acousticness;
    private double instrumentalness;
    private double tempo;
    private String trackName;
    @ManyToOne
    private ArtistGenreEntity trackArtist;
}
