package be.myitworld.smartkitchen.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Jorciney on 23/05/2016.
 */
public class Category {
    private String name;
    private String imageUrl;
    private Set<Recipe>recipes=new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public int hashCode() {
        return (this.getName() + "").hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (o instanceof Category && o != null && ((Category) o).getName() == this.getName())
            return true;
        else return false;
    }
}
