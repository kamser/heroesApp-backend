package com.example.heroesbackend.enumeration;

public enum Publisher {
    DC_COMICS("DC Comics"),
    MARVEL_STUDIOS("Marvel Studios");

    private final String publisher;

    Publisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return this.publisher;
    }
}
