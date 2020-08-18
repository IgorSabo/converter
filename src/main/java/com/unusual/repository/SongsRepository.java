package com.unusual.repository;

import com.unusual.model.Song;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by MC on 27.9.2019..
 */
public interface SongsRepository extends CrudRepository<Song, Long> {
}
