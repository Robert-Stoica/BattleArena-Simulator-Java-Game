public class Boss extends Character implements Monster, MonsterAbilities {

  /**
   * Constructor which initialises the character with its particular propriety values. It uses the
   * super method, declared in the character class to do this
   */
  public Boss(String name) {
    super(name, 8, 7, 8, 7);
  }

  /**
   * Method which launches the attack on a character based on a given chance, if the random number
   * falls in one of the specified ranges it uses a given ability.
   */
  @Override
  public void strike(Character name) {
    Toolbox probability = new Toolbox();
    int d = probability.getRandomInteger(100);
    if (d <= 50) {
      SyntaxError(name);
      System.out.println(this.getName() + " used SyntaxError");
    } else if (d >= 51 && d <= 65) {
      NullPointerException(name);
      System.out.println(this.getName() + " used NullPointerException");
    } else if (d >= 66 && d <= 80) {
      ArrayIndexOutOfBoundException(name);
      System.out.println(
          this.getName() + " used ArrayIndexOutOfBoundException on " + name.getName());
    } else if (d > 81 && d <= 90) {
      NoneTermination();
      System.out.println(this.getName() + "used NoneTermination");
    } else if (d > 91 && d <= 100) {
      ConcurrentModificationException(name);
      System.out.println(this.getName() + "used ConcurrentModificationException");
    }
  }

  /**
   * Method which defines the monster attack, it respects the specs guidelines. it attacks the enemy
   * with normal damage
   */
  @Override
  public void SyntaxError(Character enemy) {
    int commonAtk;
    commonAtk = (100 * this.getAttack()) / (100 + enemy.getDefence());
    enemy.decreaseHP(commonAtk);
    enemy.increaseEP(3);
    if (enemy instanceof Student) {
      ((Student) enemy).increaseKP(3);
    }
    if (enemy.getHP() <= 0) {
      this.increaseEP(4);
    }
    this.increaseEP(3);
  }

  /**
   * Method which defines the monster attack, it respects the specs guidelines. it heals the user
   */
  @Override
  public void NullPointerException(Character enemy) {
    int heal;
    heal = this.getDefence();
    this.increaseHP(heal);
    this.increaseEP(3);
  }

  /**
   * Method which defines the monster attack, it respects the specs guidelines It provokes double
   * damage to the enemy
   */
  @Override
  public void ArrayIndexOutOfBoundException(Character enemy) {
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

  /**
   * Method which defines the monster attack, it respects the specs guidelines it revives the dead
   * teammates
   */
  @Override
  public void NoneTermination() {
    Team bossTeam = this.getTeam();
    for (Character member : bossTeam.getMembers()) {
      if (member.getHP() <= 0) {
        member.currentHP = member.getMaxHP();
        System.out.println("Member " + member.getName() + " has been revived");
      }
    }
    this.increaseEP(3);
  }

  /**
   * Method which defines the monster attack, it respects the specs guidelines it attack every
   * member of the enemy team by applying a normal damage
   */
  @Override
  public void ConcurrentModificationException(Character enemy) {
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
