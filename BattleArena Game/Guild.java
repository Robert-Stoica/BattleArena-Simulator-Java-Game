import java.util.*;

public class Guild {

  private ArrayList<Character> memebers;

  /**
   * Constructor which initialises the different student classes, 2 of each Adds them to an array
   * list of characters, the Guild
   */
  public Guild() {
    memebers = new ArrayList<>();
    Character student1 = new AIStudent("Achilles");
    Character student2 = new AIStudent("Adonis");
    Character student3 = new CyberStudent("Hera");
    Character student4 = new CyberStudent("Juno");
    Character student5 = new SEStudent("Poseidon");
    Character student6 = new SEStudent("Neptune");
    Character student7 = new CSStudent("Hades");
    Character student8 = new CSStudent("Aphrodite");
    this.addMember(student1);
    this.addMember(student2);
    this.addMember(student3);
    this.addMember(student4);
    this.addMember(student5);
    this.addMember(student6);
    this.addMember(student7);
    this.addMember(student8);
  }

  /** Adds characters to the guild */
  public void addMember(Character member) {
    memebers.add(member);
  }

  /** Returns the members of the guild */
  public Collection<Character> getMembers() {
    return memebers;
  }

  /**
   * Method which mainly works with the array of characters previously formed form the student
   * characters It also takes an enemy team for optimization purposes Sorts the array by comparing
   * each members based on their health values, after the array is reversed, making it in descending
   * order Loops through all its characters and adds them to a Student team
   *
   * @return the Student team.
   */
  public StudentTeam getTeam(Team enemyTeam) {

    StudentTeam team = new StudentTeam("StudentTeam");

    // sort the array in terms of hp;
    (memebers)
        .sort(
            new Comparator<Character>() {
              public int compare(Character c1, Character c2) {
                if (c1.getHP() >= c2.getHP()) {
                  return -1;
                } else if (c1.getHP() <= c2.getHP()) {
                  return 1;
                } else {
                  return 0;
                }
              }
            });

    Collections.reverse(Arrays.asList(memebers));

    for (Character member : memebers) {
      if (member.getHP() > 0) {
        team.addMember(member);
        member.setTeam(team);
      }
    }

    return team;
  }

  /** Method which verifies if a the members of a guild are alive */
  public int isAlive(Guild guild) {
    int checker = guild.getMembers().size();
    for (Character c : guild.getMembers()) if (c.getHP() <= 0) checker--;
    return checker;
  }
}
