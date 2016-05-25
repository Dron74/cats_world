package com.alex.eat;

import org.assertj.core.api.Assertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by Студент on 25.05.2016.
 */
public class MeatBasketCollectionTest {
    @Test
    public void testAddMeatToOneElementBasket() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(1);
        Meat meat = new Meat(10, "red");
        basketCollection.addMeat(meat);
        Set<Meat> meats = basketCollection.getAllMeats();
        Assert.assertEquals("Size should be 1", 1, meats.size());
        Assert.assertEquals("Added meat is really that we add", meat, meats.iterator().next());
    }

    @Test
    public void testGetMeatFromOneElementBasket() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(1);
        Meat meat = new Meat(10, "red");
        basketCollection.addMeat(meat);
        Meat meatFromBasket = basketCollection.getMeat();
        Assert.assertEquals(0, basketCollection.getCurrentSize());
        Assert.assertEquals(meat, meatFromBasket);
    }

    @Test
    public void testAddMeatToZeroElementBasket() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(0);
        Meat meat = new Meat(10, "red");
        basketCollection.addMeat(meat);
        Assert.assertEquals(0, basketCollection.getCurrentSize());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetAppleFromZeroElementBasket() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(0);
        Meat meatFromBasket = basketCollection.getMeat();
    }

    @Test
    public void testAddMeat() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(3);
        basketCollection.addMeat(new Meat(1, "brown"));
        basketCollection.addMeat(new Meat(2, "red"));
        Assert.assertEquals(2, basketCollection.getCurrentSize());
    }

    @Test
    public void testAddMeatToFullBasket() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(3);

        Meat redMeat = new Meat(1, "red");
        Meat brownMeat = new Meat(2, "brown");

        basketCollection.addMeat(redMeat);
        basketCollection.addMeat(brownMeat);


        Assert.assertEquals(2, basketCollection.getCurrentSize());
        Set<Meat> meats = basketCollection.getAllMeats();
        Assert.assertEquals(redMeat, meats.iterator().next());
        Assert.assertEquals(brownMeat, meats.iterator().next());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetMeatFromEmptyBasket() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(3);
        basketCollection.getMeat();
    }

    @Test
    public void testGetMeats() {
        MeatBasketCollection basketCollection = new MeatBasketCollection(3);

        Meat brownMeat = new Meat(1, "brown");
        Meat redMeat = new Meat(2, "red");
        Meat whiteMeat = new Meat(3, "white");

        basketCollection.addMeat(brownMeat);
        basketCollection.addMeat(redMeat);
        basketCollection.addMeat(whiteMeat);



        Assert.assertEquals(3, basketCollection.getCurrentSize());

        List<Meat> testMeats = new ArrayList<>();
        testMeats.add(brownMeat);
        testMeats.add(redMeat);
        testMeats.add(whiteMeat);


        Meat currentTestMeat = basketCollection.getMeat();
        Assertions.assertThat(currentTestMeat).isIn(testMeats);
        testMeats.remove(currentTestMeat);


        Assert.assertEquals(brownMeat, basketCollection.getMeat());
        Assert.assertEquals(redMeat, basketCollection.getMeat());

        Assert.assertEquals(0, basketCollection.getCurrentSize());

    }
    @Test
    public void tetsWeightOfBasket(){
        MeatBasketCollection basketCollection = new MeatBasketCollection(4);
        Meat redmeat = new Meat(1, "red");
        Meat brownmeat = new Meat(2, "brown");
        Meat whitemeat = new Meat(3, "white");
        basketCollection.addMeat(brownmeat);
        basketCollection.addMeat(redmeat);
        basketCollection.addMeat(whitemeat);
        Assert.assertEquals(6,basketCollection.getWeight());
    }

}