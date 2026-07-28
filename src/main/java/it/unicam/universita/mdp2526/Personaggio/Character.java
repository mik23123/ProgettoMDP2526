package it.unicam.universita.mdp2526.Personaggio;

public class Character {
   String name;
   String id;
    State life;
    State energy;
    State stress;
    State food;

    public Character(String name){
        this.life = new State(10,"Vita");
        this.energy =new State(10,"Energia");
        this.stress=new State(10,"Stress");
        this.name = name;

    }
    public boolean checkStress(){
        if(getStress()>(int) (getStressMax()*0.75)){
            return true;
        }
        return false;
    }

    public boolean hangOut(int ore){
    if(this.getStress()-ore<=0) this.stress.setStamina(0);
       else  this.decrementStress(ore);
    return true;
    }

    public boolean sleep(int ore){
        if(getEnergy()+ore>=10){
        this.stress.setStamina(0);
        }

                energy.increment(ore);
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
    public void decrementStress(int v){ stress.setStamina(stress.getStamina()-v);}
    public void decrementEnergy(int v){ energy.setStamina(energy.getStamina()-v);}
    public int getLifeMax() {
        return life.getStaminaMax();
    }

    public int getEnergyMAx() {
        return energy.getStaminaMax();
    }

    public int getStressMax() {
        return stress.getStaminaMax();
    }



    public int getFood() {
        return food.getStamina();
    }
}
