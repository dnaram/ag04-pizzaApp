package com.agency04.sbss.pizza.model.pizza;

import java.util.Arrays;
import java.util.HashSet;

public class Margherita extends Pizza {

    public Margherita() {
        setName("Margherita");
        setIngredients(new HashSet<>(Arrays.asList(Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.OREGANO)));
    }
}

