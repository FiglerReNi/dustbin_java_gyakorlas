package hu.tmx.dustbin.model;

public class PaperGarbage extends Garbage {

    private boolean squeezed;

    public PaperGarbage(String name, boolean squeezed) {
        super(name);
        this.squeezed = squeezed;
    }

    public boolean isSqueezed() {
        return squeezed;
    }

    @Override
    public void squeeze() {
        if (!this.squeezed) {
            this.squeezed = true;
        }
    }
}
