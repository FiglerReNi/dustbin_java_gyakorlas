package hu.tmx.dustbin.model;

public class PlasticGarbage extends Garbage {


    private boolean cleand;

    public PlasticGarbage(String name, boolean cleand) {
        super(name);
        this.cleand = cleand;
    }

    public boolean isCleand() {
        return cleand;
    }

    @Override
    public void clean() {
        if (!this.cleand) {
            this.cleand = true;
        }
    }
}
