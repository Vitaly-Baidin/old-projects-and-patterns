public class Main {
    public static void main(String[] args) {
        VGA adapterVGAtoHDMI = new AdapterVGAtoHDMI(new CableVGA());
        adapterVGAtoHDMI.connectWithVgaCable();
    }
}
