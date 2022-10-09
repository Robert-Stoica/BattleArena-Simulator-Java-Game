public class Minion extends Character implements Monster, MonsterAbilities {

  /**
   * Constructor which initialises the character with its particular propriety values. It uses the
   * super method, declared in the character class to do this
   */
  public Minion(String name) {
    super(name, 5, 5, 5, 5);
  }

  /**
   * Method which launches the attack on a character based on a given chance, if the random number
   * falls in one of the specified ranges it uses a given ability.
   */
  public void strike(Character name) {
    Toolbox probability = new Toolbox();
    int d = probability.getRandomInteger(100);
    if (d <= 75) {
      SyntaxError(name);
      System.out.println(this.getName() + " used SyntaxError on " + name.getName());
    } else if (d >= 76 && d <= 90) {
      NullPointerException(name);
      System.out.println(this.getName() + "has healed");
    } else if (d >= 91 && d <= 100) {
      ArrayIndexOutOfBoundException(name);
      System.out.println(
          this.getName() + " used ArrayIndexOutOfBoundException on " + name.getName());
    }
  }

  /**
   * Method which defines the monster attack, it respects the specs guidelines. it attacks the enemy
   * with normal damage
   */
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

  /** Methods which are only used by boss classes. */
  public void NoneTermination() {}

  public void ConcurrentModificationException(Character enemy) {}
}
