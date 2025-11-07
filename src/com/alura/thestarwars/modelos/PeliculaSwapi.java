package com.alura.thestarwars.modelos;

import java.util.List;

public record PeliculaSwapi(String title, int episode_id, String opening_crawl,
                            String director, String producer, List<String> characters) {
}
