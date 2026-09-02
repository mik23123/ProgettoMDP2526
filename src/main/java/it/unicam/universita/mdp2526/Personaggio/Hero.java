package it.unicam.universita.mdp2526.Personaggio;

public class Hero implements Charachter,SocializeAble,StressAble,SleepAble{
   String name;
   String id;
    State life;
    State energy;
    State stress;
    public boolean justPressed;

    public Hero(String name){
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

// questo metodo serve per decrementare la vita del personaggio
    public void applyPenality() {
        if (checkStress()) {
this.decrementLife(1);        }
    }
    public boolean hangOut(int ore){
        if(this.energy.getStamina()-ore<=0 ) {return false;}


      this.decrementStress(ore);
        this.decrementEnergy(ore);
    return true;
    }

    public void sleep(int ore){
        incrementEnergy(ore);
        System.out.println(getEnergy());
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
        if(this.stress.getStamina()+v>=this.getStressMax())
        {
            stress.setStamina(this.getStressMax());
            return;
        }
        stress.setStamina(stress.getStamina()+v);
    }


    public void incrementEnergy(int v){
        if(this.energy.getStamina()+v>=getEnergyMAx()){
        energy.setStamina(getEnergyMAx());
        return ;}

        energy.setStamina(energy.getStamina()+v);}


    public void decrementStress(int v){
        if(this.stress.getStamina()-v<=0)
        {
            stress.setStamina(0);
            return;
        }
        stress.setStamina(stress.getStamina()-v);}
    public void decrementEnergy(int v){
        if(this.energy.getStamina()-v<=0)
    {
        energy.setStamina(0);
        return;
    }
        energy.setStamina(energy.getStamina()-v);}



    public void decrementLife(int v ){
        life.setStamina(life.getStamina()-v);}



    public int getLifeMax() {
        return life.getStaminaMax();
    }

    public int getEnergyMAx() {
        return energy.getStaminaMax();
    }

    public int getStressMax() {
        return stress.getStaminaMax();
    }


    @Override
    public Charachter getCharacter() {
        return this;
    }
}
