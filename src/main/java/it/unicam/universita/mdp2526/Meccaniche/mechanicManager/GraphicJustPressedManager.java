package it.unicam.universita.mdp2526.Meccaniche.mechanicManager;

import it.unicam.universita.mdp2526.Meccaniche.MechanicInterfaceManager.JustPressedStateManager;

public class GraphicJustPressedManager implements JustPressedStateManager {
    public boolean buttonStudyJustPressed ;

    public GraphicJustPressedManager(boolean initialValue){
        this.buttonStudyJustPressed=initialValue;
    }
    @Override
    public boolean isJustPressed() {
return  this.buttonStudyJustPressed;    }

    @Override
    public void setPressed() {
this.buttonStudyJustPressed=true;
    }
    public void setNotPressed(){
        this.buttonStudyJustPressed=false;
    }
}
