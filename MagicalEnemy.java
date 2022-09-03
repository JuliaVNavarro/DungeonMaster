/* MagicalEnemy.java represents an Enemy with magical abilities
 * where it is extended from the abstract Entity.java and implements 
 * Magical.java. */
public class MagicalEnemy extends Enemy implements Magical {
	
	public MagicalEnemy(String n, int mHp){
		super(n, mHp); // calls the superclass constructor from Entity.java
	}
	
	/* When a MagicalEnemy needs to attack, it will randomly
	 * choose a magical attacking ability
	 * @param e the hero's information that is being attacked
	 * @return a string representation of the attack that had occurred and the damage done */
	@Override
	public String attack(Entity e) {
		String a = "";
		int rand = (int)(Math.random() * 3) + 1;
		if(rand == 1) {
			a = magicMissile(e);
		}
		else if(rand == 2) {
			a = fireball(e);
		}
		else if(rand == 3){
			a = thunderclap(e);
		}
		return a;	
	}
	
	/* Magical Enemy will attack using a magic missile, which will cause a random amount of damage.
	 * @param e the hero's information that is being attacked
	 * @return a string representation of the attack that had occurred and the damage done*/
	@Override
	public String magicMissile(Entity e) {
		int dmg = (int)(Math.random() * 5) + 1;
		e.takeDamage(dmg);
    return super.getName() + " shoots " + e.getName() + " with a Magic Missile for " + dmg + " damage.";
	}
	
	/* Magical Enemy will attack using a fireball, which will cause a random amount of damage.
	 * @param e the hero's information that is being attacked
	 * @return a string representation of the attack that had occurred and the damage done*/
	@Override
	public String fireball(Entity e) {
		int dmg = (int)(Math.random() * 5) + 1;
		e.takeDamage(dmg);
    return super.getName() + " burns " + e.getName() + " with a Fireball for " + dmg + " damage.";
	}
	
	/* Magical Enemy will attack using a thunderclap, which will cause a random amount of damage.
	 * @param e the hero's information that is being attacked
	 * @return a string representation of the attack that had occurred and the damage done*/
	@Override
	public String thunderclap(Entity e) {
		int dmg = (int)(Math.random() * 5) + 1;
		e.takeDamage(dmg);
    return super.getName() + " zaps " + e.getName() + " with Thunderclap for " + dmg + " damage.";
	}
}
