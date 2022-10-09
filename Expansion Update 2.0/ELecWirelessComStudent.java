public class ELecWirelessComStudent extends Student {
    /**
     * Constructor which initialises the character with its particular propriety values. It also
     * defines the maximum KP and current KP points which are used for skills, a character starts with
     * 0 It uses the super method, declared in the character class to do this
     */
    public ELecWirelessComStudent(String name) {
        super(name, 5, 6, 4, 5, 11);
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points, attack all alive enemies, causing 2xDMG and  heals his remaining teammates
     * If the condition is not met throws an exception
     */
    public void WirelessMindControl(Team enemy) throws Exception{
        if (this.currentKP == this.maxKP){
            Team userTeam = this.getTeam();
            int addedHealth = this.getDefence() / 2;
            for (Character c : userTeam.getMembers()){
                if (c.getHP() > 0){
                    c.increaseHP(addedHealth);
                }
            }
            System.out.println(this.getName() + " used WirelessMindControl, healing his teammates");

            for (Character c : enemy.getMembers()){
                if (c.getHP() > 0){
                    int dobuleAtk = (2 * (100 * this.getAttack()) / (100 + c.getDefence()));
                    c.decreaseHP(dobuleAtk);
                }
                if (c.getHP() <= 0){
                    this.increaseEP(4);
                }
            }

            System.out.println(this.getName() + " used WirelessMindControl, causing 2xDMG to all the enemies");

            this.increaseEP(4);
            this.currentKP = 0;
        }else throw new Exception("not enough KPs");
    }

    public void ElectroMagneticField(){
        Team userTeam = this.getTeam();
        for (Character c : userTeam.getMembers()){
            if (c.getHP() > 0){
                c.increaseBaseDef();
            }
        }
        System.out.println(this.getName() + " used ElectroMagneticField on team, they have more defence");
        this.increaseEP(4);
        this.currentKP = 0;
    }
}
