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

    public String getTrackId() {
        return trackId;
    }

    public double getDanceability() {
        return danceability;
    }

    public double getEnergy() {
        return energy;
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public double getAcousticness() {
        return acousticness;
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public double getTempo() {
        return tempo;
    }

    public String getTrackName() {
        return trackName;
    }

    public ArtistGenreEntity getTrackArtist() {
        return trackArtist;
    }
}
