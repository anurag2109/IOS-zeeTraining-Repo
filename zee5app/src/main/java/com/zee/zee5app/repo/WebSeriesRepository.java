package com.zee.zee5app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.WebSeries;

public interface WebSeriesRepository extends JpaRepository<WebSeries, String> {

}
