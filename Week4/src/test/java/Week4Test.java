import org.junit.Test;
import org.junit.Assert;


public class Week4Test {
    @Test
    public void testMax2Int1(){
        int expectedResult = 1000;
        int actualResult = Week4.max2Int(-5, 1000);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int2(){
        int expectedResult = -10;
        int actualResult = Week4.max2Int(-500, -10);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int3(){
        int expectedResult = 1000;
        int actualResult = Week4.max2Int(999, 1000);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int4(){
        int expectedResult = 50;
        int actualResult = Week4.max2Int(0, 50);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMax2Int5(){
        int expectedResult = 0;
        int actualResult = Week4.max2Int(-50, 0);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinArray1(){
        int[] array = {-1000, 0, 5, 100};
        int expectedResult = -1000;
        int actualResult = Week4.minArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinArray2(){
        int[] array = {-1000, -5000, -50, -100};
        int expectedResult = -5000;
        int actualResult = Week4.minArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinArray3(){
        int[] array = {1000, 3000, 5, 100};
        int expectedResult = 5;
        int actualResult = Week4.minArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinArray4(){
        int[] array = {1000, 0, 500, 100};
        int expectedResult = 0;
        int actualResult = Week4.minArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testMinArray5(){
        int[] array = {-1000, 0, -5, -100};
        int expectedResult = -1000;
        int actualResult = Week4.minArray(array);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateBMI1(){
        String actualResult = Week4.calculateBMI(55, 1.84);
        String expectedResult = "Thiếu cân";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateBMI2(){
        String actualResult = Week4.calculateBMI(75, 1.84);
        String expectedResult = "Bình thường";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateBMI3(){
        String actualResult = Week4.calculateBMI(80, 1.84);
        String expectedResult = "Thừa cân";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateBMI4(){
        String actualResult = Week4.calculateBMI(150, 1.84);
        String expectedResult = "Béo phì";
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testCalculateBMI5(){
        String actualResult = Week4.calculateBMI(100, 1.84);
        String expectedResult = "Béo phì";
        Assert.assertEquals(expectedResult, actualResult);
    }
}
