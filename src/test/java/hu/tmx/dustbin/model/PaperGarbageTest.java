package hu.tmx.dustbin.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaperGarbageTest {

    PaperGarbage paperGarbage;

    @Before
    public void init(){
        paperGarbage = new PaperGarbage("paper", false);
    }

    @Test
    public void paperIsSqueezeTrue(){
        paperGarbage.squeeze();
        assertTrue(paperGarbage.isSqueezed());
    }

    @After
    public void clear(){
        paperGarbage = null;
    }
}