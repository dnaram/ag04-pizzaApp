package com.agency04.sbss.pizza.model.pizza;

import java.util.Arrays;
import java.util.HashSet;

public class Carbonara extends Pizza {

    public Carbonara() {
        setName("Carbonara");
        setIngredients(new HashSet<>(Arrays.asList(Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.PARMESAN,
                Ingredient.EGGS,
                Ingredient.BACON)));
    }
}

