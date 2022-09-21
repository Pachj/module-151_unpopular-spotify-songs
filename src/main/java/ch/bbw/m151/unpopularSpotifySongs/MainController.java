package ch.bbw.m151.unpopularSpotifySongs;

import org.springframework.data.domain.Pageable;
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

    // 4b
    @GetMapping("/findAllWithLimit")
    public List<SongEntity> findAllWithLimit(@RequestParam int limit) {
        return songRepository.findAll(Pageable.ofSize(limit)).getContent();
    }

    // 4c
    @DeleteMapping("/deleteByTrackId/{id}")
    public void deleteByTrackId(@PathVariable String id) {
        songRepository.deleteById(id);
    }

    // 4d
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
