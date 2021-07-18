package hu.tmx.dustbin.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PaperGarbageTest {

    PaperGarbage paperGarbage1;
    PaperGarbage paperGarbage2;

    @Before
    public void init(){
        paperGarbage1 = new PaperGarbage("paper1", false);
        paperGarbage2 = new PaperGarbage("paper2", true);
    }

    @Test
    public void getName(){
        assertEquals("paper1", paperGarbage1.getName());
    }

    @Test
    public void isSqueezed(){
        assertFalse(paperGarbage1.isSqueezed());
    }

    @Test
    public void squeeze(){
        paperGarbage1.squeeze();
        assertTrue(paperGarbage1.isSqueezed());
        paperGarbage1.squeeze();
        assertTrue(paperGarbage1.isSqueezed());
    }

    @After
    public void clear(){
        paperGarbage1 = null;
        paperGarbage2 = null;
    }
}