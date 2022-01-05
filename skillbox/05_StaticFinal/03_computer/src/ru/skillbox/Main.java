package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        Computer computer = new Computer("ZOON",
                "ZOONBI",
                new CPU(1, 1, 1, 1),
                new RAM(RamType.DDR4, 12, 12),
                new Storage(MemoryType.SDD, 10, 10),
                new Screen(12, ScreenType.IPS, 12),
                new Keyboard(KeyboardType.MECH, true, 12));

        System.out.println(computer.getWeight());

        computer.computerToString();
    }
}
