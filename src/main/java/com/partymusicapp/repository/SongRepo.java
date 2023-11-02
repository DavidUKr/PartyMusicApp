package com.partymusicapp.repository;

import com.partymusicapp.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepo extends JpaRepository<Song, String> {
}
