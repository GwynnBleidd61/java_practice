package examples;

public class Monster {
    int eyes;
    int arms;
    int legs;

    Monster() {
        this(4);
    }

    Monster(int limbs) {
        this(limbs, limbs, limbs);
    }

    Monster(int eyes, int arms, int legs) {
        this.eyes = eyes;
        this.arms = arms;
        this.legs = legs;
    }

    void voice() {
        voice(1);
    }

    void voice(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Grrrrrrrrrrr...");
        }
    }

    void voice(int count, String sound) {
        for (int i = 0; i < count; i++) {
            System.out.println(sound);
        }
    }




}
