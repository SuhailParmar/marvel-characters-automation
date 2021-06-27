package com.yapily.automation.models;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class Character {
    private final Integer id;
    private final String name;
    private final String description;
    private final CharacterThumbnail thumbnail;

    @AllArgsConstructor
    @Builder
    public static class CharacterThumbnail {
        private final String path;
        private final String extension;
    }
}