package ru.skillbox;

public class Computer {
    private final String vendor;
    private final String name;

    private final CPU cpu;
    private final RAM ram;
    private final Storage storage;
    private final Screen screen;
    private final Keyboard keyboard;

    public Computer(String vendor, String name, CPU cpu, RAM ram, Storage storage, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;

        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public Computer setCPU(CPU cpu) {
        return new Computer(vendor, name, cpu, ram, storage, screen, keyboard);
    }

    public Computer setRAM(RAM ram) {
        return new Computer(vendor, name, cpu, ram, storage, screen, keyboard);
    }

    public Computer setStorage(Storage storage) {
        return new Computer(vendor, name, cpu, ram, storage, screen, keyboard);
    }

    public Computer setScreen(Screen screen) {
        return new Computer(vendor, name, cpu, ram, storage, screen, keyboard);
    }

    public Computer setKeyboard(Keyboard keyboard) {
        return new Computer(vendor, name, cpu, ram, storage, screen, keyboard);
    }

    public double getWeight() {
        return cpu.getWeight() + ram.getWeight() + storage.getWeight() + screen.getWeight() + keyboard.getWeight();
    }

    public void computerToString() {
        System.out.println("Vendor: " + vendor);
        System.out.println("Computer name: " + name);
        System.out.println("CPU: ");
        System.out.println("- frequency: " + cpu.getFrequency());
        System.out.println("- core count: " + cpu.getCoreCount());
        System.out.println("- performance: " + cpu.getPerformance());
        System.out.println("- weight: " + cpu.getWeight());
        System.out.println("RAM: ");
        System.out.println("- RAM type: " + ram.getType());
        System.out.println("- volume: " + ram.getVolume());
        System.out.println("- weight: " + ram.getWeight());
        System.out.println("Storage: ");
        System.out.println("- memory type: " + storage.getMemoryType());
        System.out.println("- memory: " + storage.getMemoryGig() + "GB");
        System.out.println("- weight: " + storage.getWeight());
        System.out.println("Screen: ");
        System.out.println("- diagonal: " + screen.getDiagonal());
        System.out.println("- screen type: " + screen.getScreenType());
        System.out.println("- weight: " + screen.getWeight());
        System.out.println("keyboard: ");
        System.out.println("- keyboard type: " + keyboard.getKeyboardType());
        System.out.println("- backlight: " + keyboard.getIsBacklight());
        System.out.println("- weight: " + keyboard.getWeight());
    }
}
