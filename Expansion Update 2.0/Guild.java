import java.util.*;

public class Guild {

  private ArrayList<Character> memebers;

  /**
   * Constructor which initialises the different student classes, 2 of each Adds them to an array
   * list of characters, the Guild
   */
  public Guild() {
    memebers = new ArrayList<>();
    Character student1 = new AIStudent("AIStudent-1");
    Character student2 = new AIStudent("AIStudent-2");
    Character student3 = new CyberStudent("CyberStudent-1");
    Character student4 = new CyberStudent("CyberStudent-2");
    Character student5 = new SEStudent("SEStudent-1");
    Character student6 = new SEStudent("SEStudent-2");
    Character student7 = new CSStudent("CSStudent-1");
    Character student8 = new CSStudent("CSStudent-2");

    /*Character student1 = new ElecNanoTechStudent("Nano1");
    Character student2 = new ElecCSStudent("CSS1");
    Character student3 = new ElecSysSecureStudent("Secure1");
    Character student4 = new ElecSysSecureStudent("Secure2");
    Character student5 = new ElecPhotonicsStudent("Photon1");
    Character student6 = new ElecPhotonicsStudent("Photon2");
    Character student7 = new ELecWirelessComStudent("Wireless1");
    Character student8 = new ElecAIStudent("AI1");*/


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
