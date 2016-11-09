public class ARBEIT {
    WELT welt;
    Thread[] threads;
    /**
     * Breite: x
     * Länge: y
     */
    ARBEIT(int anzahlRoboter, int weltBreite, int weltLaenge, int pauseNeu, int tanzschritteNeu) {
        if (!((weltBreite * weltLaenge) < anzahlRoboter) || (anzahlRoboter > 9)) {
            welt = new WELT(weltBreite, weltLaenge, 8);
            threads = new Thread[anzahlRoboter];
            int nextX = 1;
            int nextY = 1;
            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(new ROBOTERTHREAD(nextX, nextY, 'S', welt, pauseNeu, tanzschritteNeu));
                
                if (nextX < weltBreite) { //Roboter noch nicht ganz rechts platziert
                    nextX++;
                } else if(nextY < weltLaenge) { //Roboter noch nicht ganz unten plaziert
                    nextY++;
                    nextX = 1;
                } else {
                    System.out.println("Fehler: Kein Platz für mehr Roboter");
                }
               }
            
            for (int i = 0; i < threads.length; i++){ 
                threads[i].start();
            }
        } else {
            System.out.println("Fehler: Zu viele Roboter (Welt zu klein oder mehr als 9");
        }
    }
}