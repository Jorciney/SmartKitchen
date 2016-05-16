package be.myitworld.smartkitchen.tools;

import java.util.ArrayList;
import java.util.List;

import be.myitworld.smartkitchen.model.Ingredient;
import be.myitworld.smartkitchen.model.Recipe;

/**
 * Created by Jorciney on 15/05/2016.
 */
public class Manager {
    private static Manager ourInstance = new Manager();
    public static List<Recipe> recipes;
    public static List<Ingredient> ingredients;

    public static Manager getInstance() {
        return ourInstance;
    }

    private Manager() {
        recipes = new ArrayList<>();
        ingredients= new ArrayList();
        setUpData();
    }
    
    public void setUpData() {
        ingredients.add(new Ingredient("Potatoes", "8", "peeled, cut into large wedges (about 6-7 wedges per potato)"));
        ingredients.add(new Ingredient("Garlic cloves", "4", " minced (more garlic is a good thing, less garlic is a no-no for this recipe)"));
        ingredients.add(new Ingredient("Olive oil", "1/2 cup"));
        ingredients.add(new Ingredient("Water", "1 cup"));
        ingredients.add(new Ingredient("Dried oregano", "1 tablespoon", "(get the Mediterranean, it's the best!)"));
        ingredients.add(new Ingredient("Lemon", "1", "juiced"));
        ingredients.add(new Ingredient("Sea salt", null));
        ingredients.add(new Ingredient("Fresh coarse ground black pepper", null));
        String directions = "Preheat oven to 420°F A reviewer has suggested spraying the baking pan with Pam - that sounds like a great idea!\n" +
                "Put all the ingredients into a baking pan large enough to hold them.\n" +
                "Season generously with sea salt and black pepper.\n" +
                "Make sure your hands are very clean and put them in the pan and give everything a toss to distribute.\n" +
                "The garlic will drop into the water/oil solution but its flavour will permeate the potatoes, and this way, it won't burn.\n" +
                "Bake for 40 minutes.\n" +
                "When a nice golden-brown crust has formed on the potatoes, give them a stir to bring the white underside up, season lightly with a bit more sea salt and pepper and just a light sprinkling of oregano.\n" +
                "Add 1/2 cup more water if pan appears to be getting dry, and pop back into oven to brown other side of potatoes.\n" +
                "This will take about another 40 minutes.\n" +
                "Do not be afraid of overcooking the potatoes- they will be delicious.\n" +
                "Note: I often melt a bouillon cube in the water; if you do, make sure to cut back some on the salt.";
        Recipe recipe1 = new Recipe(1, ingredients, directions);
        recipe1.setTitle("Greek Potatoes");
        recipe1.setPortions(8);
        recipe1.setAuthor("Evelyn/athens");
        recipe1.setTime("1hr 29min");
        recipe1.setImages(new ArrayList<String>() {{
            add("http://img.sndimg.com/food/image/upload/w_555,h_416,c_fit,fl_progressive,q_95/v1/img/recipes/87/78/2/pichn4jhf.jpg");
            add("http://www.copykat.com/wp-content/uploads/2012/10/Roasted-Greek-Potatoes.jpg");
            add("http://i349.photobucket.com/albums/q371/d-k-photos/greek-garlic-potatoes13.jpg");
            add("https://phoodingdotcom1.files.wordpress.com/2014/05/greek_potatoes.jpg");
        }});
        
        ingredients.clear();
        ingredients.add(new Ingredient("Tomatoes", "12 ounces", "very ripe and cored"));
        ingredients.add(new Ingredient("White Onion", "1 medium"));
        ingredients.add(new Ingredient("Jalapenos", "3 medium", null));
        ingredients.add(new Ingredient("Long grain white rice", "2 cups", null));
        ingredients.add(new Ingredient("Canola oil", "1/2 cup", null));
        ingredients.add(new Ingredient("Garlic cloves", "4", null));
        ingredients.add(new Ingredient("Chicken broth", "2 cups", null));
        ingredients.add(new Ingredient("Tomato paste", "1 tablespoon", "(may omit if using canned tomatoes)"));
        ingredients.add(new Ingredient("Salt", "1 1/2 teaspoons", null));
        ingredients.add(new Ingredient("Fresh cilantro", "1/2 cup", "minced"));
        ingredients.add(new Ingredient("Lime", "1", null));
        directions = "Adjust rack to middle position and preheat oven to 350.\n" +
                "Process tomato and onion in processor or blender until pureed and thoroughly smooth. Transfer mixture to measuring cup and reserve exactly 2 cups. Discard excess.\n" +
                "Remove ribs and seeds from 2 jalapenos and discard. Mince flesh and set aside. Mince remaining jalapeno. Set aside.\n" +
                "Place rice in a fine mesh strainer and rinse under cold running water until water runs clear- about 1 1/2 minutes.Shake rice vigorously to remove excess water.This step removes the starch from the rice so it will not stick. IF YOU OMIT THIS STEP YOUR RICE WILL NOT BE DRY AND FLUFFY.\n" +
                "Heat oil in heavy bottomed ovensafe 12 inch straight sided sautee pan or Dutch oven with tight fitting lid over low-medium heat about 2 minutes. (The recipe is very specific about this but I used a 10 inch dutch oven and it worked out fine.) Drop a few rice grains in and if they sizzle then it is ready. Add rice and fry stirring until rice is light golden and translucent, about 6-8 minutes. Be careful that the oil doesn't get too hot too fast or the oil will splatter.\n" +
                "Reduce heat to medium, add garlic and 2 minced jalapenos and cook , stirring constantly until fragrant, about 1 1/2 minutes.\n" +
                "Stir in broth, pureed mixture,tomato paste, and salt. Increase heat to medium high, and bring to a boil.\n" +
                "Cover pan and transfer pan to oven to bake until liquid is absorbed and rice is tender, 30-35 minutes.Stir well after 15 minutes.\n" +
                "Stir in cilantro, minced jalapeno to taste, and pass lime wedges separately.\n" +
                "Edited to add 6-15-05: If you can't get good fresh tomatoes you are better off using canned tomatoes. Don't use those awful hard and underipe tomatoes that are at most supermarket chains. Just be sure that the processed tomatoes and the one onion equals 2 cups. One the other hand- if you find that after processing your tomatoes and onions that you have less than 2 cups- simply add enough bottled salsa to make up the difference.\n" +
                "Edited 8-21-06: Do not skip any of the steps. It may seem stupid- but rinsing the rice to remove the starch is very important if you want fluffy rice. It will only take two minutes of your time but it makes the difference.\n" +
                "Edited 8-15-08: Leftovers are just as delicious the next day so this is a perfect dish to make ahead time for potlucks. This rice also freezes well. For Freezing Ahead: Cool, portion and freeze in a ziploc bag. To reheat from frozen: Place in a pyrex dish and warm in the microwave, stirring every 2-3 minutes until heated through.\n" +
                "You'll love this rice! Money back guarantee.";
        Recipe recipe2 = new Recipe(2, ingredients, directions);
        recipe2.setTitle("Mexican Rice");
        recipe2.setAuthor("Pot Scrubber");
        recipe2.setPortions(8);
        recipe2.setTime("55min");
        recipe2.setTitle("Mexican Rice");
        recipe2.setAuthor("Pot Scrubber");
        recipe2.setPortions(8);
        recipe2.setTime("55min");
        recipe2.setImages(new ArrayList<String>() {{
            add("https://i.ytimg.com/vi/2XHx_YqNeqY/maxresdefault.jpg");
            add("http://ksmartstatic.sify.com/cmf-1.0.0/appflow/bawarchi.com/Image/oetcrTiiihhhe_bigger.jpg");
            add("http://cdn.iowagirleats.com/wp-content/uploads/2012/09/CrockPotChickenTacos_04.jpg");
        }});

        ingredients.clear();
        ingredients.add(new Ingredient("Chopped onion", "1/2 cup", null));
        ingredients.add(new Ingredient("Butter", "3 tablespoons", "or 3 tablespoons margarine, melted"));
        ingredients.add(new Ingredient("Cream of chicken soup", "2(10 3/4 ounce)cans", null));
        ingredients.add(new Ingredient("Shredded cheddar cheese", "2 cups", "divided"));
        ingredients.add(new Ingredient("Milk", "1 cup", null));
        ingredients.add(new Ingredient("Chopped cooked chicken", "3 1/2 cups", null));
        ingredients.add(new Ingredient("Cooked macaroni", "2 1/2 cups", null));
        ingredients.add(new Ingredient("Salt", null, null));
        ingredients.add(new Ingredient("Pepper", null, null));
        ingredients.add(new Ingredient("Ritz cracker crumbs", "1/4 cup", null));
        directions = "In a large skillet over med-high heat, saute onions in butter until onions are tender.\n" +
                "Add in soup and 1 ½ cups cheese; gradually stir in milk.\n" +
                "Cook over medium heat until cheese melts; stir in chicken and macaroni; taste and adjust seasoning with salt and pepper.\n" +
                "Transfer mixture to a greased 2 ½ quart casserole; sprinkle with cracker crumbs.\n" +
                "Bake in a preheated 350° oven for 30 minutes or until heated through.\n" +
                "Top with remaining ½ cup cheese and bake 5 minutes.";
        Recipe recipe3 = new Recipe(3, ingredients, directions);
        recipe3.setTitle("Chicken-Macaroni Casserole");
        recipe3.setAuthor("Ratherbeswimmin'");
        recipe3.setPortions(8);
        recipe3.setTime("1hr");
        recipe3.setImages(new ArrayList<String>() {{
            add("http://cookdiary.net/wp-content/uploads/images/Chicken-Noodle-Casserole_14288.jpg");
            add("http://d2droglu4qf8st.cloudfront.net/2015/01/205251/Easy-Cheesy-Beef-Stroganoff-Casserole-Featured_Large500_ID-837912.jpg");
            add("http://brightcove.vo.llnwd.net/d22/unsecured/media/1033249144001/1033249144001_1653328464001_ari-origin05-arc-126-1337805378234.jpg");
            add("http://www.myfavandbestrecipes.com/wp-content/uploads/2013/08/Baked-Chicken-Macaroni-Casserole.jpg");
        }});
        
        ingredients.clear();
        ingredients.add(new Ingredient("Ground beef", "1/2 kg", null));
        ingredients.add(new Ingredient("Taco seasoning", "1 (1 1/4 ounce) package", null));
        ingredients.add(new Ingredient("Fried beans", "1 (15 ounce) can", null));
        ingredients.add(new Ingredient("Monterey jack cheese", "2 cups", "divided (or mixed cheddar, jack etc.)"));
        ingredients.add(new Ingredient("Salsa", "1 cup", "(I prefer mild, but if you would like to kick it up a notch, go for it)"));
        ingredients.add(new Ingredient("Green onions", "2", "chopped"));
        ingredients.add(new Ingredient("Black olives", "1 (2 1/3 ounce) cansliced ", null));
        ingredients.add(new Ingredient("Tomatoes", "1", "chopped"));
        ingredients.add(new Ingredient("Corn chips", "2 cups", "(coarsely crushed or chopped)"));
        directions = "Brown ground beef and drain.\n" +
                "Add taco seasoning and cook according to package directions, adding proper amount of water.\n" +
                "Put corn chips on bottom of 8x8\" dish.\n" +
                "Cook refried beans on stove until hot.\n" +
                "Add 1 cup cheese and 1 cup salsa. Stir until combined.\n" +
                "Pour beans over corn chips in dish.\n" +
                "Add beef to top of beans.\n" +
                "Sprinkle remaining cheese over top.\n" +
                "Sprinkle green onions and black olives over cheese.\n" +
                "Bake in a 375 degree oven until the cheese is sufficiently melted.\n" +
                "Take out of oven and sprinkle chopped tomatoes on top. Wait 1-2 minutes and then serve.";
        Recipe recipe4 = new Recipe(3, ingredients, directions);
        recipe4.setTitle("Fantastic Taco Casserole");
        recipe4.setAuthor("Leilani'");
        recipe4.setPortions(7);
        recipe4.setTime("30min");
        recipe4.setImages(new ArrayList<String>() {{
            add("http://img.sndimg.com/food/image/upload/w_555,h_416,c_fit,fl_progressive,q_95/v1/img/recipes/15/51/86/cCMUFybQ86ZNzeJ40nAw_DSC_0390.jpg");
            add("http://img.sndimg.com/food/image/upload/w_555,h_416,c_fit,fl_progressive,q_95/v1/img/recipes/15/51/86/RTh2tRZSwduJXwptfKNw_DSC_0389.jpg");
            add("http://img.sndimg.com/food/image/upload/w_555,h_416,c_fit,fl_progressive,q_95/v1/img/recipes/72/61/4/jHka17sRT0eoUIlQPGqk_DSC_0320.JPG");
            add("http:/images.edge-generalmills.com/c9fb25ee-cb22-48ea-aaa3-3c5b45ac5a45.jpg");
        }});
        recipes.add(recipe1);
        recipes.add(recipe2);
        recipes.add(recipe3);
        recipes.add(recipe4);
    }
}
