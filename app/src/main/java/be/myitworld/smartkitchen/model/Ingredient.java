package be.myitworld.smartkitchen.model;

import android.support.annotation.Nullable;

import java.io.Serializable;

/**
 * Created by Jorciney on 14/05/2016.
 */
public class Ingredient implements Serializable{
    private String type;
    private String amount;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Ingredient(String name, String amount) {
        this.name = name;
        this.amount = amount;
    }

    public Ingredient(String name, @Nullable String amount, @Nullable String desc) {
        this.name = name;
        this.amount = amount;
        this.description=desc;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s  %s, %s",getAmount(),getName(), getDescription());
    }
}
