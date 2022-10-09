public abstract class MonsterSkills extends Character{

    public MonsterSkills(String name, int baseHP, int baseAtk, int baseDef, int baseSpd) {
        super(name, baseHP, baseAtk, baseDef, baseSpd);
    }

    public void SyntaxError(Character enemy){
        int commonAtk;
        commonAtk = (100 * this.getAttack()) / (100 + enemy.getDefence());
        enemy.decreaseHP(commonAtk);
        enemy.increaseEP(3);
        if (enemy instanceof Student){
            ((Student) enemy).increaseKP(3);
        }
        if (enemy.getHP() <= 0){
            this.increaseEP(4);
        }
        this.increaseEP(3);
    }
    public void NullPointerException(Character enemy){
        int heal;
        heal = this.getDefence();
        this.increaseHP(heal);
        this.increaseEP(3);
    }
    public void ArrayIndexOutOfBoundException(Character enemy){
        int doubleDmg;
        doubleDmg = 2 * ((100 * this.getAttack()) / (100 + enemy.getDefence()));
        enemy.decreaseHP(doubleDmg);
        enemy.increaseEP(3);
        if (enemy instanceof Student) {
            ((Student) enemy).increaseKP(3);
        }
        if (enemy.getHP() <= 0) {
            this.increaseEP(4);
        }
        this.increaseEP(3);
    }
    public void NoneTermination(){
        Team bossTeam = this.getTeam();
        for (Character member : bossTeam.getMembers()) {
            if (member.getHP() <= 0) {
                member.currentHP = member.getMaxHP();
                System.out.println("Member " + member.getName() + " has been revived");
            }
        }
        this.increaseEP(3);
    }
    public void ConcurrentModificationException(Character enemy){
        Team enemyTeam = enemy.getTeam();
        for (Character member : enemyTeam.getMembers()) {
            if (member.getHP() > 0) {
                member.decreaseHP((100 * this.getAttack()) / (100 + enemy.getDefence()));
                System.out.println(member.getName() + "  has been attacked by " + this.getName());
                member.increaseEP(3);
            }
            if (member instanceof Student) {
                ((Student) member).increaseKP(3);
            }
            if (member.getHP() <= 0) {
                this.increaseEP(4);
            }
        }
        this.increaseEP(3);
    }
}
