package ch.bbw.m151.unpopularSpotifySongs;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    private final SongRepository songRepository;

    public MainController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // 4a
    @GetMapping("/findAllByTempoLessThanAndEnergyGreaterThan")
    public List<SongEntity> findAllByTempoLessThanAndEnergyGreaterThan(@RequestParam double tempo, double energy) {
        return songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
    }

    @GetMapping("/findAllBySpeechiness")
    public List<SongEntity> findAllBySpeechiness(@RequestParam double speechiness) {
        return songRepository.findAllBySpeechiness(speechiness);
    }

    // 4c
    @DeleteMapping("/deleteByTrackId/{id}")
    public void deleteByTrackId(@PathVariable String id) {
        songRepository.deleteById(id);
    }

    // 4d
    // TODO, no FK
    @GetMapping("/findAll")
    public List<SongEntity> findAll() {
        return songRepository.findAll();
    }

    // 4e
    @GetMapping("/getTempoCount")
    public List<Object[]> getTempoCount() {
        return songRepository.getTempoCount();
    }
}
