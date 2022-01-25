public class AdapterVGAtoHDMI implements VGA {

    private CableVGA cableVGA;

    public AdapterVGAtoHDMI(CableVGA cableVGA) {
        this.cableVGA = cableVGA;
    }

    @Override
    public void connectWithVgaCable() {
        this.cableVGA.insert();
        this.cableVGA.outWork();
    }
}
