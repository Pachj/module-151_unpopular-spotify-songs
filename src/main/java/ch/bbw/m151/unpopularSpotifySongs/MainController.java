package ch.bbw.m151.unpopularSpotifySongs;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MainController {
    private final SongRepository songRepository;

    public MainController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/findAllByTempoLessThanAndEnergyGreaterThan")
    public List<SongEntity> findAllByTempoLessThanAndEnergyGreaterThan(@RequestParam double tempo, double energy) {
        return songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
    }

    @GetMapping("/findAllBySpeechiness")
    public List<SongEntity> findAllBySpeechiness(@RequestParam double speechiness) {
        return songRepository.findAllBySpeechiness(speechiness);
    }

    @DeleteMapping("/deleteByTrackId")
    public void deleteByTrackId(@PathParam("id") String id) {
        songRepository.deleteByTrackId(id);
    }

    @GetMapping("/findAll")
    public List<SongEntity> findAll() {
        return songRepository.findAll();
    }

    @GetMapping("/getTempoCount")
    public List<Object[]> getTempoCount() {
        return songRepository.getTempoCount();
    }
}
