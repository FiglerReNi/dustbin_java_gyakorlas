package hu.tmx.dustbin.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlasticGarbageTest {
    PlasticGarbage plasticGarbage;

    @Before
    public void init(){
        plasticGarbage = new PlasticGarbage("plastic", false);
    }

    @Test
    public void plasticIsCleanTrue(){
        plasticGarbage.clean();
        assertTrue(plasticGarbage.isCleand());
    }

    @After
    public void clear(){
        plasticGarbage = null;
    }
}