package ch.bbw.m151.unpopularSpotifySongs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MainController {
    private final SongRepository songRepository;

    public MainController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostMapping("/findAllByTempoLessThanAndEnergyGreaterThan")
    public List<SongEntity> findAllByTempoLessThanAndEnergyGreaterThan(@RequestBody double tempo, double energy) {
        return songRepository.findAllByTempoLessThanAndEnergyGreaterThan(tempo, energy);
    }

    @PostMapping("/findAllBySpeechiness")
    public List<SongEntity> findAllBySpeechiness(@RequestBody double speechiness) {
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
    public List<Double> getTempoCount() {
        return songRepository.getTempoCount();
    }
}
