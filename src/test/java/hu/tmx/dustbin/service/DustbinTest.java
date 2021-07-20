package hu.tmx.dustbin.service;

import hu.tmx.dustbin.model.PaperGarbage;
import hu.tmx.dustbin.model.PlasticGarbage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DustbinTest {

    Dustbin dustbin;
    PaperGarbage paperGarbage = Mockito.mock(PaperGarbage.class);
    PlasticGarbage plasticGarbage = Mockito.mock(PlasticGarbage.class);

    @Before
    public void init(){
        dustbin = new Dustbin("Yellow");
    }

    @Test
    public void squeezedPaperThrowOutSuccess() throws DustbinContentException {
        when(paperGarbage.isSqueezed()).thenReturn(true);
        dustbin.throwOutGarbage(paperGarbage);
        assertEquals(1, dustbin.getDustbinPaper().size());
        verify(paperGarbage, times(2)).isSqueezed();
    }

    @Test
    public void cleanedPlasticThrowOutSuccess() throws DustbinContentException {
        when(plasticGarbage.isCleand()).thenReturn(true);
        dustbin.throwOutGarbage(plasticGarbage);
        assertEquals(1, dustbin.getDustbinPlastic().size());
        verify(plasticGarbage, times(2)).isCleand();
    }

    @Test(expected = DustbinContentException.class)
    public void notSqueezedPaperThrowExceptionDustbinContentException() throws DustbinContentException {
        when(paperGarbage.isSqueezed()).thenReturn(false);
        dustbin.throwOutGarbage(paperGarbage);
        verify(paperGarbage, times(2)).isSqueezed();
    }

    @Test(expected = DustbinContentException.class)
    public void notCleanedPlasticThrowExceptionDustbinContentException() throws DustbinContentException {
        when(plasticGarbage.isCleand()).thenReturn(false);
        dustbin.throwOutGarbage(plasticGarbage);
        verify(plasticGarbage, times(2)).isCleand();
    }

    @Test
    public void emptyContents() throws DustbinContentException {
        when(paperGarbage.isSqueezed()).thenReturn(true);
        dustbin.throwOutGarbage(paperGarbage);
        dustbin.emptyContents();
        assertEquals(0, dustbin.getDustbinPaper().size());
    }

    @After
    public void destroyObject(){
        dustbin = null;
    }

}