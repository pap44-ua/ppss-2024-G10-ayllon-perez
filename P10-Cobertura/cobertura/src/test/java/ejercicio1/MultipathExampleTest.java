package ejercicio1;


import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;

public class MultipathExampleTest {

    MultipathExample multiple;

    @BeforeEach
    void setUp()
    {
        multiple = new MultipathExample();
    }
    

    //a > 5
    @Test
    public void test1()
    {
        int a = 6;
        int b = 1;
        int c = 1;

        int resultado = multiple.multiPath1(a,b,c);

        Assert.assertEquals(7, resultado);

    }

    @Test
    public void test2()
    {
        int a = 1;
        int b = 7;
        int c = 1;

        int resultado = MultipathExample.multiPath1(a,b,c);

        Assert.assertEquals(8, resultado);

    }

    @Test
    public void test3()
    {
        int a = 3;
        int b = 6;
        int c = 2;

        int resultado = MultipathExample.multiPath1(a,b,c);

        Assert.assertEquals(8, resultado);

    }

    @Test
    public void test4()
    {
        int a = 0;
        int b = 0;
        int c = 0;

        int resultado = MultipathExample.multiPath2(a,b,c);

        Assert.assertEquals(0, resultado);

    }

    @Test
    public void test5()
    {
        int a = 6;
        int b = 1;
        int c = 1;

        int resultado = MultipathExample.multiPath2(a,b,c);

        Assert.assertEquals(1, resultado);

    }

    @Test
    public void test6()
    {
        int a = 6;
        int b = 5;
        int c = 1;

        int resultado = MultipathExample.multiPath2(a,b,c);

        Assert.assertEquals(1, resultado);

    }

    @Test
    public void test7()
    {
        int a = 6;
        int b = 1;
        int c = 6;

        int resultado = MultipathExample.multiPath2(a,b,c);

        Assert.assertEquals(13, resultado);

    }



}
