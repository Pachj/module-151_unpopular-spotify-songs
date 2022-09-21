package ch.bbw.m151.unpopularSpotifySongs;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SongRepository extends JpaRepository<SongEntity, String> {
    List<SongEntity> findAllByTempoLessThanAndEnergyGreaterThan(double tempo, double energy);

    // TODO needs to be limited in controller
    List<SongEntity> findAllBySpeechiness(double speechiness);

    // 4e
    @Query("SELECT tempo, COUNT(tempo) as cnt FROM SongEntity GROUP BY tempo")
    List<Object[]>getTempoCount();
}
