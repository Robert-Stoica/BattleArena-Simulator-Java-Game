public class ElecCSStudent extends Student {
    /**
     * Constructor which initialises the character with its particular propriety values. It also
     * defines the maximum KP and current KP points which are used for skills, a character starts with
     * 0 It uses the super method, declared in the character class to do this
     */
    public ElecCSStudent(String name) {
        super(name, 4, 8, 4, 5, 9);
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points, kills the enemy with one single attack
     * If the condition is not met throws an exception
     */
    public void SystematicAttack(Character enemy) throws Exception{
        if (this.currentKP == this.maxKP){
                enemy.decreaseHP(enemy.getMaxHP());
                if (enemy.getHP() <= 0){
                    this.increaseEP(4);
                }
                this.increaseEP(4);
                this.currentKP = 0;

        }else throw new Exception("not enough KPs");
    }
}
