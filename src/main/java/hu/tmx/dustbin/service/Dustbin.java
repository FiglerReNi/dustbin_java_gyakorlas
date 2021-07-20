package hu.tmx.dustbin.service;

import hu.tmx.dustbin.model.Garbage;
import hu.tmx.dustbin.model.PaperGarbage;
import hu.tmx.dustbin.model.PlasticGarbage;

import java.util.ArrayList;
import java.util.List;

public class Dustbin {

    private final String color;
    private List<Garbage> dustbinPaper = new ArrayList<>();
    private List<Garbage> dustbinPlastic = new ArrayList<>();
    private List<Garbage> dustbinHouseWaste = new ArrayList<>();

    public Dustbin(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public List<Garbage> getDustbinPaper() {
        return dustbinPaper;
    }

    public List<Garbage> getDustbinPlastic() {
        return dustbinPlastic;
    }

    public List<Garbage> getDustbinHouseWaste() {
        return dustbinHouseWaste;
    }

    public void throwOutGarbage(Garbage garbage) throws DustbinContentException {
        if (garbage instanceof PaperGarbage && !((PaperGarbage) garbage).isSqueezed()) {
            throw new DustbinContentException(garbage.getClass() + " " + garbage.getName() + " isn't throwable");
        }
        if(garbage instanceof PlasticGarbage && !((PlasticGarbage) garbage).isCleand()){
            throw new DustbinContentException(garbage.getClass() + " " + garbage.getName() + " isn't throwable");
        }

        if (garbage instanceof PaperGarbage && ((PaperGarbage) garbage).isSqueezed()) {
            dustbinPaper.add(garbage);
        } else if (garbage instanceof PlasticGarbage && ((PlasticGarbage) garbage).isCleand()) {
            dustbinPlastic.add(garbage);
        } else {
            dustbinHouseWaste.add(garbage);
        }
    }

    public void emptyContents() {
        dustbinHouseWaste.clear();
        dustbinPaper.clear();
        dustbinPlastic.clear();
    }

    public void displayContents() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String text = getColor() + " Dustbin! House waste content: " + dustbinHouseWaste.size() + "item()s ";
        text = garbageNames(dustbinHouseWaste, text);
        text += " Paper content: " + dustbinPaper.size() + "item()s ";
        text = garbageNames(dustbinPaper, text);
        text += " Plastic content: " + dustbinPlastic.size() + "item()s ";
        text = garbageNames(dustbinPlastic, text);
        return text;
    }

    private String garbageNames(List<Garbage> dustbinType, String text) {
        for (int i = 0; i < dustbinType.size(); i++) {
            text += (dustbinType.get(i).getName() + " nr." + (i + 1) + " ");
        }
        return text;
    }
}
