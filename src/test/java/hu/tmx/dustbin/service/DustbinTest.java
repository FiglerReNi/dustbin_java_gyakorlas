package hu.tmx.dustbin.service;

import hu.tmx.dustbin.model.Garbage;
import hu.tmx.dustbin.model.PaperGarbage;
import hu.tmx.dustbin.model.PlasticGarbage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class DustbinTest {

    Dustbin dustbin;
    PaperGarbage paperGarbage = Mockito.mock(PaperGarbage.class);
    PlasticGarbage plasticGarbage = Mockito.mock(PlasticGarbage.class);

    @Before
    public void init(){
        dustbin = new Dustbin("Yellow");
    }

    @Test
    public void getColor(){
        assertEquals("Yellow", dustbin.getColor());
    }

    @Test
    public void throwOutGarbage() throws DustbinContentException {
            when(paperGarbage.isSqueezed()).thenReturn(true);
            when(plasticGarbage.isCleand()).thenReturn(true);
            dustbin.throwOutGarbage(paperGarbage);
            dustbin.throwOutGarbage(plasticGarbage);
            assertEquals(1, dustbin.getPaperCount());
            assertEquals(1, dustbin.getDustbinPaper().size());
            assertEquals(1, dustbin.getPlasticCount());
            assertEquals(1, dustbin.getDustbinPlastic().size());
    }

    @Test(expected = DustbinContentException.class)
    public void DustbinContentException() throws DustbinContentException {
        when(paperGarbage.isSqueezed()).thenReturn(false);
        when(plasticGarbage.isCleand()).thenReturn(false);
        dustbin.throwOutGarbage(paperGarbage);
        dustbin.throwOutGarbage(plasticGarbage);
    }

    @Test
    public void emptyContents() throws DustbinContentException {
        when(paperGarbage.isSqueezed()).thenReturn(true);
        dustbin.throwOutGarbage(paperGarbage);
        dustbin.emptyContents();
        assertEquals(0, dustbin.getPaperCount());
        assertEquals(0, dustbin.getDustbinPaper().size());
    }

    @After
    public void destroyObject(){
        dustbin = null;
    }


}