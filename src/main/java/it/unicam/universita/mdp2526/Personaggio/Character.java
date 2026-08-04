package it.unicam.universita.mdp2526.Personaggio;

public class Character {
   String name;
   String id;
    State life;
    State energy;
    State stress;
    public boolean justPressed;

    public Character(String name){
        this.life = new State(3,"Vita");
        this.energy =new State(10,"Energia");
        this.stress=new State(10,"Stress");
        this.life.setStamina(3);
        this.name = name;
        justPressed=false;
    }
    public void setJustPressed(boolean b1){this.justPressed=b1;}

    public boolean checkStress(){
        if(getStress()>=9){
            return true;
        }
        return false;
    }
    public boolean checkGameOver(){
        if(this.getLife()<=0 ) {return true;}
        return false;
    }

    public void applyStressPenalty() {
        if (checkStress()) {
this.decrementLife(1);        }
    }
    public boolean hangOut(int ore){
        if(this.getEnergy()-ore<=0 ) {return false;}
        System.out.println(getEnergy());
      this.decrementStress(ore);
        this.decrementEnergy(ore);
        if(this.getStress()-ore<=0) {this.stress.setStamina(0); }
    return true;
    }

    public boolean sleep(int ore){
        incrementEnergy(ore);
        System.out.println(getEnergy());

                    if(getEnergy()>=10){
                    this.energy.setStamina(10);
                    }
                    return true;
    }




    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getLife() {
        return life.getStamina();
    }

    public int getEnergy() {
        return energy.getStamina();
    }

    public int getStress() {
        return stress.getStamina();
    }
    public void incrementStress(int v){
        stress.setStamina(stress.getStamina()+v);
    }
    public void incrementEnergy(int v){energy.setStamina(energy.getStamina()+v);}
    public void decrementStress(int v){ stress.setStamina(stress.getStamina()-v);}
    public void decrementEnergy(int v){ energy.setStamina(energy.getStamina()-v);}
    public void decrementLife(int v ){life.setStamina(life.getStamina()-v);}
    public int getLifeMax() {
        return life.getStaminaMax();
    }

    public int getEnergyMAx() {
        return energy.getStaminaMax();
    }

    public int getStressMax() {
        return stress.getStaminaMax();
    }



}
