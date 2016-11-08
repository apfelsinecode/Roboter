public class TANZROBOTER extends ROBOTER {
    
    TANZROBOTER(WELT welt) {
        super(welt);
    }
    
    TANZROBOTER(int startx, int starty, char blickrichtung, WELT welt) {
        super(startx, starty, blickrichtung, welt);
    }
    
    public void Umdrehen()
    {
        RechtsDrehen();
        RechtsDrehen();
    }
    
    public void VorsichtigerSchritt() {
        if (IstWand()) {
            Umdrehen();
        } else if(IstRoboter()) {
            LinksDrehen();
        } else {
            Schritt();
        }
    }
    
    public void VorsichtigerRechtsSchritt() {
        RechtsDrehen();
        if (!IstWand() && !IstRoboter()) {
            Schritt();
            LinksDrehen();
        } else {
            LinksDrehen();
        }
    }
    
    public void Tanzen() {
        int zufall = (int) (Math.random() * 4);
        switch (zufall) {
            case 0:
                LinksDrehen();
                break;
            case 1:
                RechtsDrehen();
                break;
            case 2:
                VorsichtigerSchritt();
                break;
            case 3:
                VorsichtigerRechtsSchritt();
                break;
        }
    }
    
    public void Tanzen(int anzahl) {
        for (int i = 0; i < anzahl; i++) {
            Tanzen();
        }
    }
}