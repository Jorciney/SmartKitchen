package be.myitworld.smartkitchen.model;

import java.util.List;

/**
 * Created by Jorciney on 14/05/2016.
 */
public class Recipe {
    private long id;
    private String title;
    private List<Ingredient> ingredients;
    private String description;
    private int portions;
    private String time;
    private String directions;
    private String author;
    private List<String> images;
    private int rate;
    private List<Category> categories;


    public Recipe(long id, List<Ingredient> ingredients, String directions) {
        this.id = id;
        this.ingredients = ingredients;
        this.directions = directions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int hashCode() {
        return (this.getId() + "").hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (o instanceof Recipe && o != null && ((Recipe) o).getId() == this.getId())
            return true;
        else return false;
    }
}
