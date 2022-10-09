import java.util.ArrayList;

public abstract class Team {

  private String name;
  ArrayList<Character> members;

  /**
   * Constructor which initialises the Team name and the array list of members which forms the team
   */
  public Team(String name) {
    this.name = name;
    this.members = new ArrayList<>();
  }

  /** Method which gets the name of the team */
  public String getName() {
    return this.name;
  }

  /** Method which returns the team as an array of characters */
  public Character[] getMembers() {
    Character[] membersArray = new Character[0];
    membersArray = members.toArray(membersArray);
    return membersArray;
  }

  /**
   * Method which adds a member to the team, and checks if the player is already there or the array
   * has reached full size;
   */
  public int addMember(Character member) {

    if (members.contains(member)) {
      return -1;
    } else if (members.size() == 5) {
      return -2;
    } else {
      members.add(member);
    }
    return members.size();
  }

  /**
   * Method which compares the amount of hp of each characters within a given team
   *
   * @return the alive member with most hp
   */
  public Character choseMemberMaxHP(Team team) {
    Character maxHP = team.members.get(0);

    for (Character memeber : team.getMembers()) {
      if (memeber.getHP() > maxHP.getHP() && memeber.getHP() > 0) maxHP = memeber;
    }

    return maxHP;
  }

  /**
   * Method which compares the levels of each characters within a given team
   *
   * @return the alive member with the highest level
   */
  public Character choseMemberMaxLvl(Team team) {
    Character maxLvlMember = team.members.get(0);

    for (Character memeber : team.getMembers()) {
      if ((memeber.getLevel() > maxLvlMember.getLevel()) && memeber.getHP() > 0)
        maxLvlMember = memeber;
    }

    return maxLvlMember;
  }

  /**
   * Method which compares the attack of each characters within a given team
   *
   * @return the alive member or friend with most attack
   */
  public Character choseFriendMaxAtk() {
    Character maxAtkMember = this.members.get(0);

    for (Character memeber : this.getMembers()) {
      if ((memeber.getAttack() > maxAtkMember.getAttack()) && memeber.getHP() > 0)
        maxAtkMember = memeber;
    }

    return maxAtkMember;
  }

  /**
   * Method which compares the speed of each characters within a given team
   *
   * @return the alive member with most attack
   */
  public Character choseMemberMaxSpd(Team team) {
    Character maxSpdMember = team.members.get(0);

    for (Character memeber : team.getMembers()) {
      if (memeber.getLevel() > maxSpdMember.getLevel() && memeber.getHP() > 0)
        maxSpdMember = memeber;
    }

    return maxSpdMember;
  }

  /**
   * Method which moves the player which holds a turn to execute an action upon the enemy team,
   * itself or its own team
   */
  abstract void move(Character member, Team enemyTeam) throws Exception;
}
