package hu.tmx.dustbin.service;

import hu.tmx.dustbin.model.Garbage;
import hu.tmx.dustbin.model.PaperGarbage;
import hu.tmx.dustbin.model.PlasticGarbage;

import java.util.ArrayList;
import java.util.List;

public class Dustbin {

    private String color;
    private int houseWasteCount;
    private int paperCount;
    private int plasticCount;
    private List<Garbage> dustbinPaper = new ArrayList<>();
    private List<Garbage> dustbinPlastic = new ArrayList<>();
    private List<Garbage> dustbinHouseWaste = new ArrayList<>();

    public Dustbin(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void throwOutGarbage(Garbage garbage) throws DustbinContentException {
        if (garbage instanceof PaperGarbage && !((PaperGarbage) garbage).isSqueezed()) {
            throw new DustbinContentException(garbage.getClass() + " " + garbage.getName() + " doesn't throwable");
        }
        if(garbage instanceof PlasticGarbage && !((PlasticGarbage) garbage).isCleand()){
            throw new DustbinContentException(garbage.getClass() + " " + garbage.getName() + " doesn't throwable");
        }

        if (garbage instanceof PaperGarbage && ((PaperGarbage) garbage).isSqueezed()) {
            this.paperCount++;
            dustbinPaper.add(garbage);
        } else if (garbage instanceof PlasticGarbage && ((PlasticGarbage) garbage).isCleand()) {
            this.plasticCount++;
            dustbinPlastic.add(garbage);
        } else {
            this.houseWasteCount++;
            dustbinHouseWaste.add(garbage);
        }
    }


    public void emptyContents() {
        this.paperCount = 0;
        this.plasticCount = 0;
        this.houseWasteCount = 0;
        dustbinHouseWaste.clear();
        dustbinPaper.clear();
        dustbinPlastic.clear();
    }

    public void displayContents() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String text = getColor() + " Dustbin! House waste content: " + houseWasteCount + "item()s ";
        text = garabeNames(dustbinHouseWaste, text);
        text += " Paper content: " + paperCount + "item()s ";
        text = garabeNames(dustbinPaper, text);
        text += " Plastic content: " + plasticCount + "item()s ";
        text = garabeNames(dustbinPlastic, text);
        return text;
    }

    private String garabeNames(List<Garbage> dustbinType, String text) {
        for (int i = 0; i < dustbinType.size(); i++) {
            text += (dustbinType.get(i).getName() + " nr." + (i + 1) + " ");
        }
        return text;
    }
}
