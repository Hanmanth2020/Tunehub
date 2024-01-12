package com.tunehub.main.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tunehub.main.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

}
