public class ElecSysSecureStudent extends Student {
    /**
     * Constructor which initialises the character with its particular propriety values. It also
     * defines the maximum KP and current KP points which are used for skills, a character starts with
     * 0 It uses the super method, declared in the character class to do this
     */
    public ElecSysSecureStudent(String name) {
        super(name, 7, 7, 6, 5, 6);
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points, uses the enemy attack on him, otherwise it throws an exception
     * an exception
     */
    public void breakingSystemSecurity(Character enemy) throws Exception{
        if (this.currentKP == this.maxKP) {
            Monster minion = new Minion("Hacked Minion");
            Student student = new AIStudent("Hacked student");
            if (enemy instanceof Monster) {
              System.out.println(
                  this.getName() + " used breakingSystemSecurity(Hacked Minion) on " + enemy.getName());
              minion.strike(enemy);
            } else if (enemy instanceof Student) {
              System.out.println(
                  this.getName()
                      + " used breakingSystemSecurity(Hacked student) on "
                      + enemy.getName());
              student.javaProgramming(enemy);
            }
            this.increaseEP(4);
            this.currentKP = 0;
            if (enemy.getHP() <= 0) this.increaseEP(4);
        }else throw new Exception("not enough KPS");
    }

    /**
     * Method which defines the student attack, it respects the specs guidelines. If it has the
     * required KP points, regains the user max hp, otherwise it throws an exception
     * an exception
     */
    public void cryptograpicAdvantage(){
        int maxHP = this.getMaxHP();
        this.increaseHP(maxHP);
        System.out.println(this.getName() + " has used cryptograpicAdvantage, his hp is now full");
    }

}
