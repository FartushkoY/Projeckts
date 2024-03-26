package de.telran.homework_04_03_ArraysAndClone.chestUnderOak;

public class Main {
    public static void main(String[] args) {
        Chest chest = new Chest("chest", new Hare("hare", new Duck("duck", new Egg("egg", new Needle("needle")))));
        System.out.println(chest);

        System.out.println(chest.shallowCopy());
        chest.setTitle("maple");
        chest.getHare().getDuck().getEgg().getNeedle().setTitle("shilo");
        System.out.println("After changing name, shallowCopy:");
        System.out.println(chest);
        System.out.println(chest.shallowCopy());

        System.out.println("-------------------------");
        Chest deepCopyChest = chest.deepCopy();
        System.out.println(deepCopyChest);
        chest.getHare().getDuck().getEgg().getNeedle().setTitle("needle");
        chest.getHare().setTitle("rabbit");
        System.out.println("After changing name, deepCopy:");
        System.out.println(chest);
        System.out.println(deepCopyChest);

        System.out.println("-------------------------");
        chest.clear();
        System.out.println(chest);
    }
}
