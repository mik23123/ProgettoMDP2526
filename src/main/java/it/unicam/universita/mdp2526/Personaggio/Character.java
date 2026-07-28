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

    public void esci(int ore){
int stressfinale=0;
int energiaFinale=0;
        while(ore>0){
            stressfinale=stressfinale+1;
            energiaFinale=energiaFinale+1;
            ore--;
        }
this.decrementStress(stressfinale);
        this.decrementEnergy((int)(energiaFinale)/2);
    }
    public boolean sleep(int ore){
        if(getEnergy()==getEnergyMAx()){
        return false;
        }

                energy.increment(ore);
            return true;
    }

    public void eat(){
        energy.increment(1);
        food.increment(1);
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
    public void decrementStress(int v){ stress.setStamina(stress.getStaminaMax()-v);}
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
