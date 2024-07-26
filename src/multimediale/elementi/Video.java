package multimediale.elementi;

import multimediale.ElementoMultimediale;
import multimediale.Riproduzione;

public class Video extends ElementoMultimediale implements Riproduzione {
    private int durata;
    private int volume;
    private int luminosita;

    public Video(String titolo, int durata, int volume, int luminosita) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
        this.luminosita = luminosita;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }


    public void abbassaVoulme() {
        volume--;

    }

    public void alzaVoulme() {
        volume++;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        luminosita--;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "V " + "!".repeat(volume) + " B " + "*".repeat(luminosita));
        }
    }
}
