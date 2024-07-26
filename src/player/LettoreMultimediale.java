package player;

import multimediale.ElementoMultimediale;
import multimediale.elementi.Audio;
import multimediale.elementi.Immagini;
import multimediale.elementi.Video;

import java.util.Scanner;

public class LettoreMultimediale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];


        for (int i = 0; i < 5; i++) {
            System.out.print("Inserisci il tipo di elemento (immagine, audio, video): ");
            String tipo = scanner.nextLine();
            System.out.print("Inserisci il titolo: ");
            String titolo = scanner.nextLine();

            switch (tipo.toLowerCase()) {
                case "immagine":
                    System.out.print("Inserisci la luminosità: ");
                    int luminosita = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Immagini(titolo, luminosita);
                    break;
                case "audio":
                    System.out.print("Inserisci la durata: ");
                    int durataAudio = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inserisci il volume: ");
                    int volumeAudio = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Audio(titolo, durataAudio, volumeAudio);
                    break;
                case "video":
                    System.out.print("Inserisci la durata: ");
                    int durataVideo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inserisci il volume: ");
                    int volumeVideo = Integer.parseInt(scanner.nextLine());
                    System.out.print("Inserisci la luminosità: ");
                    int luminositaVideo = Integer.parseInt(scanner.nextLine());
                    elementi[i] = new Video(titolo, durataVideo, volumeVideo, luminositaVideo);
                    break;
                default:
                    System.out.println("Tipo non valido.");
                    i--;
                    break;
            }
        }


        while (true) {
            System.out.print("Scegli un elemento da eseguire (1-5) o 0 per terminare: ");
            int scelta = Integer.parseInt(scanner.nextLine());

            if (scelta == 0) {
                System.out.println("Programma terminato.");
                break;
            } else if (scelta > 0 && scelta <= 5) {
                ElementoMultimediale elemento = elementi[scelta - 1];


                boolean tornaAlMenuPrincipale = false;
                while (!tornaAlMenuPrincipale) {
                    System.out.println("Elemento selezionato: " + elemento.getTitolo());
                    int opzione = -1;

                    if (elemento instanceof Audio) {
                        System.out.println("1. Regola durata");
                        System.out.println("2. Regola volume");
                        System.out.println("3. Esegui");
                        System.out.println("4. Torna al menu principale");
                        opzione = Integer.parseInt(scanner.nextLine());

                        switch (opzione) {
                            case 1:
                                System.out.print("Inserisci la nuova durata: ");
                                int nuovaDurata = Integer.parseInt(scanner.nextLine());
                                ((Audio) elemento).setDurata(nuovaDurata);
                                break;
                            case 2:
                                System.out.print("Inserisci il nuovo volume: ");
                                int nuovoVolume = Integer.parseInt(scanner.nextLine());
                                ((Audio) elemento).setVolume(nuovoVolume);
                                break;
                            case 3:
                                ((Audio) elemento).play();
                                break;
                            case 4:
                                tornaAlMenuPrincipale = true;
                                break;
                            default:
                                System.out.println("Opzione non valida.");
                        }
                    } else if (elemento instanceof Video) {
                        System.out.println("1. Regola durata");
                        System.out.println("2. Regola volume");
                        System.out.println("3. Regola luminosità");
                        System.out.println("4. Esegui");
                        System.out.println("5. Torna al menu principale");
                        opzione = Integer.parseInt(scanner.nextLine());

                        switch (opzione) {
                            case 1:
                                System.out.print("Inserisci la nuova durata: ");
                                int nuovaDurata = Integer.parseInt(scanner.nextLine());
                                ((Video) elemento).setDurata(nuovaDurata);
                                break;
                            case 2:
                                System.out.print("Inserisci il nuovo volume: ");
                                int nuovoVolume = Integer.parseInt(scanner.nextLine());
                                ((Video) elemento).setVolume(nuovoVolume);
                                break;
                            case 3:
                                System.out.print("Inserisci la nuova luminosità: ");
                                int nuovaLuminosita = Integer.parseInt(scanner.nextLine());
                                ((Video) elemento).setLuminosita(nuovaLuminosita);
                                break;
                            case 4:
                                ((Video) elemento).play();
                                break;
                            case 5:
                                tornaAlMenuPrincipale = true;
                                break;
                            default:
                                System.out.println("Opzione non valida.");
                        }
                    } else if (elemento instanceof Immagini) {
                        System.out.println("1. Regola luminosità");
                        System.out.println("2. Esegui");
                        System.out.println("3. Torna al menu principale");
                        opzione = Integer.parseInt(scanner.nextLine());

                        switch (opzione) {
                            case 1:
                                System.out.print("Inserisci la nuova luminosità: ");
                                int nuovaLuminosita = Integer.parseInt(scanner.nextLine());
                                ((Immagini) elemento).setLuminosita(nuovaLuminosita);
                                break;
                            case 2:
                                ((Immagini) elemento).show();
                                break;
                            case 3:
                                tornaAlMenuPrincipale = true;
                                break;
                            default:
                                System.out.println("Opzione non valida.");
                        }
                    } else {
                        System.out.println("Elemento non riconosciuto.");
                    }


                    if ((elemento instanceof Immagini && opzione == 4) || opzione == 5 || (elemento instanceof Immagini && opzione == 3)) {
                        tornaAlMenuPrincipale = true;
                    }
                }
            } else {
                System.out.println("Scelta non valida.");
            }
        }
        scanner.close();
    }
}
