package com.agency04.sbss.pizza.model.pizza;

public class Romana extends Pizza {

    public Romana() {
        setName("Romana");
        setIngredients(new Ingredient[]{Ingredient.TOMATO_SAUCE,
                Ingredient.MOZZARELLA,
                Ingredient.ANCHOVIES,
                Ingredient.CAPERS,
                Ingredient.OREGANO
        });
    }
}
