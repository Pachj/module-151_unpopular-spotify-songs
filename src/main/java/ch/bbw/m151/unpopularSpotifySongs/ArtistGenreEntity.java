package ch.bbw.m151.unpopularSpotifySongs;

import javax.persistence.*;

@Entity
public class ArtistGenreEntity {
    @Id
    public String artistName;
    public String artistId;
    public String genre;
}
