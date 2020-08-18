package com.unusual;

import com.unusual.model.Gig;
import com.unusual.model.Repertoar;
import com.unusual.model.Song;
import com.unusual.model.SongsRepertoar;
import com.unusual.repository.GigRepository;
import com.unusual.repository.RepertoarRepository;
import com.unusual.repository.SongsPerRepertoarRepository;
import com.unusual.repository.SongsRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConverterApplicationTests {

	@Autowired
	SongsRepository songsRepository;

	@Autowired
	RepertoarRepository repertoarRepository;

	@Autowired
	SongsPerRepertoarRepository songsPerRepertoarRepository;

	@Autowired
	GigRepository gigRepository;

	//@BeforeClass
	public void initData(){
		Gig gig1 = new Gig();
		gig1.setClubName("Dylan dog");
		gig1.setGigDate(new Date());
		gigRepository.save(gig1);

		//create song1
		Song song1 = new Song();
		song1.setBandName("bla1");
		song1.setChords("BlaMol1");
		song1.setSongTitle("Truc1");
		song1.setText("No me interesa1");
		songsRepository.save(song1);

		//create song2
		Song song2 = new Song();
		song2.setBandName("bla2");
		song2.setChords("BlaMol2");
		song2.setSongTitle("Truc2");
		song2.setText("No me interesa2");
		songsRepository.save(song2);

		//create repertoar
		Repertoar rep = new Repertoar();
		repertoarRepository.save(rep);

		//create gig
		gig1.setRepertoar(rep);
		gigRepository.save(gig1);

		//create songs per repertoar (song1)
		SongsRepertoar spr = new SongsRepertoar();
		spr.setSong(song1);
		spr.setRepertoar(rep);
		spr.setPosition(1);
		rep.getSongs().add(spr);
		repertoarRepository.save(rep);

		//create songs per repertoar (song2)
		spr.setSong(song2);
		spr.setRepertoar(rep);
		spr.setPosition(2);
		rep.getSongs().add(spr);
		repertoarRepository.save(rep);
	}

	@Test
	public void getAllSongsForGig() {

		Iterable<Gig> gigs = gigRepository.findAll();

		for( Gig gig : gigs ){
			System.out.println("Gigging at "+gig.getClubName()+" on date "+gig.getGigDate());
			Repertoar rep = gig.getRepertoar();
			List<SongsRepertoar> sr = rep.getSongs();
			for( SongsRepertoar tmp : sr ){
				System.out.println("position: "+tmp.getPosition()+
						", title:"+tmp.getSong().getSongTitle()+
						", band name:"+tmp.getSong().getBandName()+
						", text:"+tmp.getSong().getText()+
						", chords:"+tmp.getSong().getChords());

			}
		}

	}

}
