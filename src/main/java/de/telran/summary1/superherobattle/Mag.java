package de.telran.summary1.superherobattle;

public class Mag extends EvilCreature implements HealingSkills, SpellSkills{
    private int level;


    public Mag(String name, int force, int protection,  int level) {
        super(name, force, protection);
        this.level = level;
    }



    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public void heal(Character character) {
        character.setHealth(100);
        System.out.println(character.getName() + " healed");
    }

    @Override
    public void heal(Character[] characters) {
        for (int i = 0; i < characters.length; i++) {
            heal(characters[i]);
        }
        System.out.println("Characters are healed");
    }

    @Override
    public void applySpell(Superhero hero, Spells spell) {
        switch (spell) {
            case CURSE -> {
                hero.setHealth((int)((hero.getHealth() * (1 - 0.1 * getLevel()))));
                System.out.println("Health " + hero.getName() + " reduced to " + hero.getHealth());
            }
            case REVIVE -> {
                heal(hero);
            }
            case INSPIRE -> {
                hero.setForce((int)(hero.getForce() * (1 + 0.1 * getLevel())));
                System.out.println("Force " + hero.getName() + " increased to " + hero.getHealth());
            }
        }
    }

    @Override
    public void applySpell(Superhero[] heroes, Spells spell) {
        for (int i = 0; i < heroes.length; i++) {
            applySpell(heroes[i], spell);
        }
    }
}
