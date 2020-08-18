package com.unusual.service;

import com.unusual.dto.SongDto;
import com.unusual.dto.SongsRepertoarDto;
import com.unusual.model.Gig;
import com.unusual.model.Repertoar;
import com.unusual.model.Song;
import com.unusual.model.SongsRepertoar;
import com.unusual.repository.GigRepository;
import com.unusual.repository.RepertoarRepository;
import com.unusual.repository.SongsPerRepertoarRepository;
import com.unusual.repository.SongsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by MC on 27.9.2019..
 */
@Service
public class SongsService {

    @Autowired
    SongsRepository songsRepository;

    @Autowired
    RepertoarRepository repertoarRepository;

    @Autowired
    SongsPerRepertoarRepository songsPerRepertoarRepository;

    @Autowired
    GigRepository gigRepository;

   public  SongsRepertoarDto getAllSongsForToday(){
        SongsRepertoarDto result = new SongsRepertoarDto();

        Date currentDate = new Date();
        Date startDate;
        Date endDate;
        Calendar cal = Calendar.getInstance();

        //start date
        cal.setTime(currentDate);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        startDate = cal.getTime();

        //end date
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        endDate = cal.getTime();

        Gig gig = gigRepository.getGigForToday(startDate, endDate);
        Repertoar rep = gig.getRepertoar();

        result.setRepertoarId(rep.getId());
        result.setClubName(gig.getClubName());

        List<SongsRepertoar> spr = rep.getSongs();
        List<SongDto> songs = spr.stream().map( s -> {
             return new SongDto( s.getSong().getId(), s.getPosition(), s.getSong().getBandName(), s.getSong().getSongTitle(), s.getSong().getText(), s.getSong().getChords() );}
        ).collect(Collectors.toList());

        result.setSongs(songs);
        return result;
    }

    public SongDto getSongForId(Long id){
       Optional<Song> song = songsRepository.findById(id);
       if( song.isPresent() ){
           Song s = song.get();
           return new SongDto( s.getId(), 0, s.getBandName(), s.getSongTitle(), s.getText(), s.getChords()  );
       }

       return null;
    }
}
