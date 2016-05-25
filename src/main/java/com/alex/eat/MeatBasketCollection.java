package com.alex.eat;

import java.util.*;

/**
 * Created by Студент on 25.05.2016.
 */
public class MeatBasketCollection implements Weigh {
    private Set<Meat> meats;
    private int size;

    public MeatBasketCollection(int size) {
        this.meats = new HashSet<>(size);
        this.size = size;
    }

    public void addMeat(Meat meat) {
        if (meats.size() < size) {
            meats.add(meat);
        } else {
            System.out.println("Sorry basket is full!");
        }
    }

    public Meat getMeat() {
        Iterator<Meat> iterator = meats.iterator();
        if (iterator.hasNext()) {
            Meat nextMeat = iterator.next();
            meats.remove(nextMeat);
            return nextMeat;
        } else {
            throw new IllegalStateException("Sorry basket is full");
        }
    }

    public Set<Meat> getAllMeats() {
        return Collections.unmodifiableSet(meats);
    }


    public int getCurrentSize() {
        return meats.size();
    }


    @Override
    public int getWeight() {
   /*     int sum = 0;
        for (Meat meat : meats) {
            if (meat != null) {
                sum=sum+meat.getWeight();
            }
        }*/
        ///4 var
        return meats.parallelStream().mapToInt(meat -> meat.getWeight()).sum();
    }


}
