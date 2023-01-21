package com.fronchak.animeflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fronchak.animeflix.entities.Anime;

@Repository
public interface AnimeRepository extends JpaRepository<Anime, Long> {

}
