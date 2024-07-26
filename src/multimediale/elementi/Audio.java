package multimediale.elementi;

import multimediale.ElementoMultimediale;
import multimediale.Riproduzione;

public class Audio extends ElementoMultimediale implements Riproduzione {
    private int durata;
    private int volume;

    public Audio(String titolo, int durata, int volume) {
        super(titolo);
        this.durata = durata;
        this.volume = volume;
    }

    public void abbassaVolume() {
        volume--;

    }

    public void alzaVolume() {
        volume++;
    }

    @Override
    public void play() {
        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + " " + "m" + "!".repeat(volume));
        }
    }
}
