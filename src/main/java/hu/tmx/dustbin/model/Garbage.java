package hu.tmx.dustbin.model;

public abstract class Garbage {

    private String name;

    public Garbage(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void clean(){};
    public void squeeze(){};
}
