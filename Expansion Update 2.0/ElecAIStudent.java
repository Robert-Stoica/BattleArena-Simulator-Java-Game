import java.sql.SQLOutput;

public class ElecAIStudent extends Student{
    /**
     * Constructor which initialises the character with its particular propriety values. It also
     * defines the maximum KP and current KP points which are used for skills, a character starts with
     * 0 It uses the super method, declared in the character class to do this
     */
    public ElecAIStudent(String name) {
        super(name, 7, 6, 5, 5, 6);
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points,user boosts attack property for a short time and attacks the enemy, a quarter of the dealt damage is used by the skill user to regenerate his own hp
     * If the condition is not met throws an exception
     */
    public void autonomousAttack(Character enemy) throws Exception{
        if (this.currentKP == this.maxKP){
            int attackBoost = this.getAttack() + this.getAttack() * 2;
            int addedHP = attackBoost / 4;
            int damage = (100 * attackBoost) / (100 + this.getDefence());
            enemy.decreaseHP(damage);
            System.out.println(this.getName() + " used autonomousAttack on " + enemy.getName());
            if (enemy.getHP() <= 0){
                this.increaseEP(4);
            }
            this.increaseHP(addedHP);
            System.out.println(this.getName() + " successfully used autonomousAttack, and got healed a bit");
            this.increaseEP(4);
            this.currentKP = 0;
        }else throw new Exception("not enough KPs");
    }

    public void dataGathering(){
        this.increaseEP(this.getTargetEP());
        System.out.println(this.getName() + "used DataGathering and now is level " + this.getLevel());
        this.increaseEP(4);
        this.currentKP = 0;
    }
}
