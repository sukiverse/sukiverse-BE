package com.kimYunHyeong.sukiverse.anime.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimYunHyeong.sukiverse.anime.entity.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

	Optional<Genre> findByMalGenreId(Integer malGenreId);
}
