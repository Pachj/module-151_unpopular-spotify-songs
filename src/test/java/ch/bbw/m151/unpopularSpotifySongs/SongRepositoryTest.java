package ch.bbw.m151.unpopularSpotifySongs;


import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Transactional
public class SongRepositoryTest implements WithAssertions {

    @Autowired
    private SongRepository songRepository;
    @Autowired
    private MainController mainController;

    // Repository
    @Test
    @DisplayName("Test for query getTempoCount")
    void shouldNotBeNull() {
        List<Object[]> tempoCount = songRepository.getTempoCount();
        assertThat(tempoCount).isNotEmpty();
    }

    @Test
    @DisplayName("Test for query getTempoCount")
    void shouldHaveAsManyListEntriesAsDifferentTempos() {
        int differentTemposInDatabase = 8804;
        List<Object[]> tempoCount = songRepository.getTempoCount();
        assertThat(tempoCount.size()).isEqualTo(differentTemposInDatabase);
    }

    @Test
    @DisplayName("Test for query findAllByTempoLessThanAndEnergyGreaterThan")
    void shouldFindWithSpecifiedTempoAndEnergy() {
        double tempo = 144.077;
        double energy = 0.5;
        List<SongEntity> foundEntities = songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
        assertThat(foundEntities).hasSize(4526);
    }

    @Test
    @DisplayName("Test for query findAllByTempoLessThanAndEnergyGreaterThan")
    void shouldFindNoEntityIfTempoIsTooLow() {
        double tempo = 0.0;
        double energy = 0.5;
        List<SongEntity> foundEntities = songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
        assertThat(foundEntities).isEmpty();
    }

    @Test
    @DisplayName("Test for query findAllByTempoLessThanAndEnergyGreaterThan")
    void shouldFindNoEntityIfEnergyIsTooHigh() {
        double tempo = 144.077;
        double energy = 1;
        List<SongEntity> foundEntities = songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
        assertThat(foundEntities).isEmpty();
    }

    // Controller
    @Test
    @DisplayName("Test for query findAll")
    void shouldFindAllSongEntities() {
        assertThat(mainController.findAll()).hasSize(9923);
    }

    @Test
    @DisplayName("Test for query findAllWithLimit")
    void shouldFindInsertedMaximumOfEntities() {
        int limit = 5;
        List<SongEntity> allWithLimit = mainController.findAllWithLimit(limit);
        assertThat(allWithLimit).hasSize(limit);
    }

    @Test
    @DisplayName("Test for query findAllWithLimit")
    void shouldFindAllEntitiesIfLimitIsHigherThanAmountOfEntries() {
        int limitHigherAmountEntries = 10000;
        List<SongEntity> allWithLimit = mainController.findAllWithLimit(limitHigherAmountEntries);
        assertThat(allWithLimit).hasSize(songRepository.findAll().size());
    }

    @Test
    @DisplayName("Test for query deleteByTrackId")
    void shouldDeleteEntityById() {
        String id = "701JUA6oOLOLbUqeskgGf6";
        Optional<SongEntity> songEntity = songRepository.findById(id);
        assertThat(songEntity).isPresent();
        mainController.deleteByTrackId(id);
        assertThat(songRepository.findAll()).doesNotContain(songEntity.get());
    }
}
