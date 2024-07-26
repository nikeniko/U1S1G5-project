package multimediale.elementi;

import multimediale.ElementoMultimediale;


public class Immagini extends ElementoMultimediale {
    private int luminosita;

    public Immagini(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public void aumentaLuminosita() {
        luminosita++;
    }

    public void diminuisciLuminosita() {
        luminosita--;
    }

    public void show() {
        System.out.println(titolo + " " + "B " + "*".repeat(luminosita));
    }

}
