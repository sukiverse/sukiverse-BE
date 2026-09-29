package com.kimYunHyeong.sukiverse.anime.entity;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anime")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Anime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Jikan(MAL) 원본 id
	@Column(name = "mal_id", nullable = false, unique = true)
	private Long malId;

	@Column(name = "title_kr")
	private String titleKr;

	@Column(name = "title_jp")
	private String titleJp;

	@Column(name = "title_en")
	private String titleEn;

	@Column(name = "img_url", length = 500)
	private String imgUrl;

	@Column(columnDefinition = "TEXT")
	private String description;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, length = 20)
	private AnimeStatus status;

	//방영 시작시점
	@Column(name = "aired_from")
	private LocalDate airedFrom;

	@Column(name = "aired_to")
	private LocalDate airedTo;

	@Enumerated(EnumType.STRING)
	@Column(name = "broadcast_day", length = 20)
	private DayOfWeek broadcastDay;

	@Enumerated(EnumType.STRING)
	@Column(length = 10)
	private Season season;

	// 몇 분기 방영 애니메이션인지
	@Column(name = "season_year")
	private Integer seasonYear;

	// 자체 정제 평점 (0.0 ~ 5.0)
	@Column(precision = 2, scale = 1)
	private BigDecimal rating;

	@ManyToMany
	@JoinTable(
		name = "anime_genre",
		joinColumns = @JoinColumn(name = "anime_id"),
		inverseJoinColumns = @JoinColumn(name = "genre_id")
	)
	private Set<Genre> genres = new HashSet<>();

	@Builder
	public Anime(Long malId, String titleKr, String titleJp, String titleEn, String imgUrl, String description,
			AnimeStatus status, LocalDate airedFrom, LocalDate airedTo, DayOfWeek broadcastDay,
			Season season, Integer seasonYear) {
		this.malId = malId;
		this.titleKr = titleKr;
		this.titleJp = titleJp;
		this.titleEn = titleEn;
		this.imgUrl = imgUrl;
		this.description = description;
		this.status = status;
		this.airedFrom = airedFrom;
		this.airedTo = airedTo;
		this.broadcastDay = broadcastDay;
		this.season = season;
		this.seasonYear = seasonYear;
	}

	public void updateTitles(String titleKr, String titleJp, String titleEn) {
		this.titleKr = titleKr;
		this.titleJp = titleJp;
		this.titleEn = titleEn;
	}
}
