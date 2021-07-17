package hu.tmx.dustbin.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlasticGarbageTest {
    PlasticGarbage plasticGarbage1;
    PlasticGarbage plasticGarbage2;

    @Before
    public void init(){
        plasticGarbage1 = new PlasticGarbage("plastic1", false);
        plasticGarbage2 = new PlasticGarbage("plastic2", true);
    }

    @Test
    public void isCleaned(){
        assertFalse(plasticGarbage1.isCleand());
    }

    @Test
    public void clean(){
        plasticGarbage1.clean();
        assertTrue(plasticGarbage1.isCleand());
        plasticGarbage1.clean();
        assertTrue(plasticGarbage1.isCleand());
    }

    @After
    public void clear(){
        plasticGarbage1 = null;
        plasticGarbage2 = null;
    }
}