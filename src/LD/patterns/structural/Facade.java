package LD.patterns.structural;

class CPU {
    void initialize() {
        System.out.println("CPU initialization.");
    }
}

class Memory {
    void load(long position, String data) {
        System.out.println("Loading data into memory at position " + position + ".");
    }
}

class HardDrive {
    String readBootSector() {
        return "Boot sector data";
    }
}

class OperatingSystem {
    String loadKernel() {
        return "OS kernel data";
    }
}

class Computer {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();
    private OperatingSystem operatingSystem = new OperatingSystem();

    void startComputer() {
        String bootSector = hardDrive.readBootSector();
        String osData = operatingSystem.loadKernel();
        memory.load(0, bootSector);
        memory.load(1024, osData);
        cpu.initialize();
    }
}

public class Facade {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}
