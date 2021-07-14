package hu.tmx.dustbin;

import hu.tmx.dustbin.model.Garbage;
import hu.tmx.dustbin.model.PaperGarbage;
import hu.tmx.dustbin.model.PlasticGarbage;
import hu.tmx.dustbin.service.Dustbin;
import hu.tmx.dustbin.service.DustbinContentException;

public class App {
    public static void main(String[] args) {

        Dustbin dustbin = new Dustbin("Yellow");
        Garbage paperGarbage1 = new PaperGarbage("paper1", true);
        Garbage plasticGarbage1 = new PlasticGarbage("plastic1", true);
        try {
            dustbin.throwOutGarbage(paperGarbage1);
        } catch (DustbinContentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            dustbin.throwOutGarbage(plasticGarbage1);
        } catch (DustbinContentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }
        dustbin.displayContents();
        Garbage plasticGarbage2 = new PlasticGarbage("plastic2", false);
        try {
            dustbin.throwOutGarbage(plasticGarbage2);
        } catch (DustbinContentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        dustbin.displayContents();
        plasticGarbage2.clean();
        try {
            dustbin.throwOutGarbage(plasticGarbage2);
        } catch (DustbinContentException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        dustbin.displayContents();
        dustbin.emptyContents();
        dustbin.displayContents();
    }
}
