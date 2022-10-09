public class ElecPhotonicsStudent extends Student{
    /**
     * Constructor which initialises the character with its particular propriety values. It also
     * defines the maximum KP and current KP points which are used for skills, a character starts with
     * 0 It uses the super method, declared in the character class to do this
     */
    public ElecPhotonicsStudent(String name) {
        super(name, 6, 6, 6, 6, 7);
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points, attack an enemy giving it triple damage If the condition is not met throws
     * an exception
     */
    public void PhotonsAttack(Character enemy) throws Exception{
        if (this.currentKP == this.maxKP) {
            enemy.decreaseHP(3 * (100 * this.getAttack()) / (100 + enemy.getDefence()));
            System.out.println(this.getName() + " has used PhotonsAttack on " + enemy.getName());
            this.increaseEP(4);
            this.currentKP = 0;
            if (enemy.getHP() <= 0) {
              this.increaseEP(4);
            }
        } else {
            throw new Exception("Not enough KP points");
        }
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points, increases the user base speed by 1 point
     * an exception
     */
  public void FiberReach() throws Exception {
    if (this.currentKP == this.maxKP) {
      this.increaseBaseSpd();
      System.out.println(this.getName() + "used FiberReach, its speed increased by 1");
        this.increaseEP(4);
        this.currentKP = 0;
    } else throw new Exception("Not enough KP points");

    }
}
