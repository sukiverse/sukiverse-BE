package com.kimYunHyeong.sukiverse.anime.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "genre")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true, length = 50)
	private String name;

	// Jikan(MAL) 장르 id. 크롤링한 영문 장르를 이 값으로 매칭해 한국어 장르로 변환한다.
	@Column(name = "mal_genre_id", unique = true)
	private Integer malGenreId;

	@Builder
	public Genre(String name, Integer malGenreId) {
		this.name = name;
		this.malGenreId = malGenreId;
	}
}
