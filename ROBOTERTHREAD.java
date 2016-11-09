public class ROBOTERTHREAD extends TANZROBOTER implements Runnable {
    int pause;
    int tanzschritte;
    ROBOTERTHREAD(WELT welt, int pauseNeu, int tanzschritteNeu) {
        super(welt);
        pause = pauseNeu;
        tanzschritte = tanzschritteNeu;
    }
    
    ROBOTERTHREAD(int startx, int starty, char blickrichtung, WELT welt, int pauseNeu, int tanzschritteNeu) {
        super(startx, starty, blickrichtung, welt);
        pause = pauseNeu;
        tanzschritte = tanzschritteNeu;
    }
    
    public void run() {
        for(int i = 0; i <= tanzschritte; i++) {
            Tanzen();
            try {
                Thread.sleep(pause);
            } catch (Exception e) {
                System.out.println("Fehler beim Pausieren.");
            }
        }
    }
}