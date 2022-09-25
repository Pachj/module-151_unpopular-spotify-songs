package ch.bbw.m151.unpopularSpotifySongs;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest(properties = {"spring.h2.console.enabled=false"})
public class SongRepositoryTest implements WithAssertions {

    @Autowired
    private SongRepository songRepository;
    //    @Autowired
//    private TestEntityManager entityManager;
    @Autowired
    private MainController mainController;

    //    @GetMapping("/findAll")
    @Test
    void shouldFindAllSongEntities() {
        assertThat(songRepository.findAll()).hasSize(9923);
    }

    //    @GetMapping("/findAllWithLimit")
    @Test
    void shouldFindInsertedMaximumOfEntities() {
        int limit = 5;
        List<SongEntity> allWithLimit = mainController.findAllWithLimit(limit);
        assertThat(allWithLimit).hasSize(limit);
    }

    //    @GetMapping("/findAllByTempoLessThanAndEnergyGreaterThan")
    @Test
    void shouldFindWithSpecifiedTempoAndEnergy() {
        double tempo = 144.077;
        double energy = 0.5;
        List<SongEntity> foundEntities = songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
        assertThat(foundEntities).hasSize(4526);
    }

    //    @DeleteMapping("/deleteByTrackId/{id}")
    @Test
    void shouldDeleteEntityById() {
        String id = "701JUA6oOLOLbUqeskgGf6";
        Optional<SongEntity> songEntity = songRepository.findById(id);
        assertThat(songEntity).isPresent();
        mainController.deleteByTrackId(id);
        assertThat(songRepository.findAll()).doesNotContain(songEntity.get());
    }


//    @GetMapping("/getTempoCount")

}
