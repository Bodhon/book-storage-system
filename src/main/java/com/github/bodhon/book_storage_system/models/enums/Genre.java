package com.github.bodhon.book_storage_system.models.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Genre {
    FICTION("Fiction"),
    NON_FICTION("Non-fiction"),
    SCIENCE_FICTION("Science Fiction"),
    FANTASY("Fantasy"),
    MYSTERY("Mystery"),
    THRILLER("Thriller"),
    ROMANCE("Romance"),
    HISTORICAL("Historical"),
    HORROR("Horror"),
    CHILDREN("Children's Literature"),
    YOUNG_ADULT("Young Adult"),
    BIOGRAPHY("Biography"),
    POETRY("Poetry"),
    CLASSIC("Classic"),
    ADVENTURE("Adventure"),
    CRIME("Crime"),
    SELF_HELP("Self Help"),
    HEALTH("Health"),
    TRAVEL("Travel"),
    SCIENCE("Science"),
    HISTORY("History"),
    BUSINESS("Business"),
    COOKING("Cooking"),
    ART("Art"),
    RELIGIOUS("Religious"),
    PHILOSOPHY("Philosophy"),
    EDUCATIONAL("Educational"),
    LAW("Law"),
    POLITICS("Politics"),
    SPORTS("Sports"),
    MUSIC("Music");


    private final String name;
}
