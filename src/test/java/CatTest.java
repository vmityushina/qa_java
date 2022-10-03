import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Spy
    private Feline feline;

    @Test
    public void getSoundTest() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        Assert.assertEquals(expectedSound, cat.getSound());
    }

    @Test
    public void getFoodTest() throws Exception {
        Cat cat = Mockito.spy(new Cat(feline));
        Mockito.when(feline.eatMeat()).thenCallRealMethod();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Assert.assertEquals(expectedFood, cat.getFood());
    }

}
