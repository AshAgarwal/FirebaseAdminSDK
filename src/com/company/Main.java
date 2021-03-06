package com.company;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

// JSON Parsing {Source: GeeksForGeeks}
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

public class Main {

    public static void main(String[] args) throws InterruptedException{
	    // write your code here

        FileInputStream serviceAccount = null;
        FirebaseOptions options = null;

        try {
            // Fetch the service Account key JSON file contents
            serviceAccount = new FileInputStream("demotest-58ccc-firebase-adminsdk-d0qxk-ad13e38160.json");
            // Initialize the app with a service account, granting admin privileges
            options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://demotest-58ccc.firebaseio.com/")
                    .build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FirebaseApp.initializeApp(Objects.requireNonNull(options));

        // -------------------------------------------------------------------------------
        /*
        // Code for JSON Parsing
        String rawData = "{'@context': 'http://schema.org', '@type': 'Recipe', 'mainEntityOfPage': 'https://www.allrecipes.com/recipe/16000/green-beans-with-almonds/', 'name': 'Green Beans with Almonds', 'image': {'@type': 'ImageObject', 'url': 'https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F6220926.jpg', 'width': 1242, 'height': 1242, 'caption': null}, 'datePublished': '1999-12-20T03:46:37.000Z', 'description': 'This is one of those dishes that tradition has snatched. Most everyone has a green bean dish on the menu for the holidays. The almonds are a nice detour from the usual ingredients.', 'prepTime': 'P0DT0H0M', 'cookTime': 'P0DT0H0M', 'totalTime': 'P0DT0H0M', 'recipeYield': '6 to 8 servings', 'recipeIngredient': ['2 pounds fresh green beans, washed and trimmed', '2 slices bacon', '¼ cup sliced almonds'], 'recipeInstructions': [{'@type': 'HowToStep', 'text': 'Remove both ends of beans, break in half, and wash thoroughly.\\n'}, {'@type': 'HowToStep', 'text': 'Place in a large pot and add water 3 to 4 inches from the top. Add bacon and cook until tender.\\n'}, {'@type': 'HowToStep', 'text': 'Remove bacon from cooking water and discard. Remove beans and place in a large bowl, add almonds and toss. Serve Hot.\\n'}], 'recipeCategory': ['Side Dish', 'Vegetable Side Dishes', 'Green Beans'], 'recipeCuisine': [], 'author': {'@type': 'Person', 'name': 'Patti'}, 'aggregateRating': {'@type': 'AggregateRating', 'ratingValue': 4.314285714285714, 'ratingCount': 35, 'itemReviewed': 'Green Beans with Almonds', 'bestRating': '5', 'worstRating': '1'}, 'nutrition': {'@type': 'NutritionInformation', 'calories': '97.1 calories', 'carbohydrateContent': '9.9 g', 'cholesterolContent': '5.4 mg', 'fatContent': '5.5 g', 'fiberContent': '4.8 g', 'proteinContent': '4 g', 'saturatedFatContent': '1.4 g', 'servingSize': null, 'sodiumContent': '74.4 mg', 'sugarContent': '1.9 g', 'transFatContent': null, 'unsaturatedFatContent': null}, 'review': [{'@type': 'Review', 'datePublished': '2008-10-12T02:49:45.947Z', 'reviewBody': \"I would have rated this 5-stars for ingredients and only 2-stars for the cooking method--the idea of cooking the raw bacon in with the cooking water just didn't appeal to me. I sauteed diced bacon with minced garlic then tossed in the beans cooked crisp tender and finished with the almonds which I toasted. Now THAT'S good!\", 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'naples34102', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/naples34102'}}, {'@type': 'Review', 'datePublished': '2006-10-19T13:15:09.893Z', 'reviewBody': 'I revamped this recipe a lot...sorry. I cooked my beans as directed (leaving them slightly undercooked) only I added just a bit of bacon drippings to the water to add flavor. Meanwhile, I sauteed pearl onions & chopped pancetta in EVOO & a little butter until the onions were golden, deglazed the pan w/ a bit of chicken broth, added the green beans (drained) & sliced almonds... as well as a bit of Garlic Butter (recipe frm this site) that I had in the fridge. FANTASTIC!', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 3}, 'author': {'@type': 'Person', 'name': 'IMVINTAGE', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/1379521'}}, {'@type': 'Review', 'datePublished': '2005-07-13T01:25:35.42Z', 'reviewBody': \"Used frozen whole beans from Sam's Club and added a lot more slivered toasted almonds (Trader Joe's). Had to add a great amount of seasoning. I sauteed in butter as well as extra virgin olive oil and added fresh minced garlic. Also seasoning salt and fresh ground black pepper. Without any of the above this would have been blah. For this fact I am giving the recipe a three. With my additions it became a five.\", 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 3}, 'author': {'@type': 'Person', 'name': 'JDVMD', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/595916'}}, {'@type': 'Review', 'datePublished': '2003-06-18T23:23:07.657Z', 'reviewBody': 'Very yummy idea and I used slivered almonds that were treated with garlic to add extra flavor. Yummy!', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'JMSCRUGGS78', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/588566'}}, {'@type': 'Review', 'datePublished': '2011-10-17T19:44:21.72Z', 'reviewBody': 'I used this recipe as a guide but changed the method quite a bit. I cooked my bacon separately cooled and crumbled it. I tossed the almonds in a little of the bacon grease and toasted them in the oven at 350 for about 10 minutes. I cooked my green beans in water until crisp tender drained them and tossed them in a little more of the bacon grease. When it was time to serve I re-heated the beans and bacon in the microwave adding salt and pepper and served them garnished with the toasted almonds. Different method entirely but my results were probably similar to the submitter s intent.', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'bellepepper', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/4452392'}}, {'@type': 'Review', 'datePublished': '2006-08-14T21:56:49.64Z', 'reviewBody': 'Bravo! Incorporating the bacon took the bitterness out of the beans without having to dredge them in butter. My husband LOVED this and he is not a vegetable eater. Will make over and over!', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 5}, 'author': {'@type': 'Person', 'name': 'Paula', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/1567027'}}, {'@type': 'Review', 'datePublished': '2007-08-02T22:55:56.87Z', 'reviewBody': 'I followed this recipe about 95%. Instead of bacon I used unsalted butter strictly and sauteed the beans with almond slivers. I sauteed the beans until they were crispy and not limp. Then after I drained the excess butter. Be careful not to burn the almonds. Do not store covered or they will become soft and limp.', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'ARBUTUSROEHM', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/1191154'}}, {'@type': 'Review', 'datePublished': '2004-07-21T13:24:24.81Z', 'reviewBody': 'This just needed a lot more flavor for us. I ended up tossing in melted butter with garlic salt added to it. I think next time I will try simmering the almonds in the garlic butter mixture and just pour over the beans and toss.', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 2}, 'author': {'@type': 'Person', 'name': 'Wilemon', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/536781'}}, {'@type': 'Review', 'datePublished': '2009-12-04T01:55:54.85Z', 'reviewBody': 'I used slivered almonds roasted in toaster oven - be carefull not to burn almonds', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 5}, 'author': {'@type': 'Person', 'name': 'SuzyQ', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/suzyq'}}]}";

        try {
            Object obj = new JSONParser().parse(rawData);
            JSONObject jo = (JSONObject) obj;

            String foodName = (String) jo.get("'name'");
            System.out.println(foodName);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        */

        // -------------------------------------------------------------------------------------
        String rawData = "{'@context': 'http://schema.org', '@type': 'Recipe', 'mainEntityOfPage': 'https://www.allrecipes.com/recipe/16000/green-beans-with-almonds/', 'name': 'Green Beans with Almonds', 'image': {'@type': 'ImageObject', 'url': 'https://imagesvc.meredithcorp.io/v3/mm/image?url=https%3A%2F%2Fimages.media-allrecipes.com%2Fuserphotos%2F6220926.jpg', 'width': 1242, 'height': 1242, 'caption': null}, 'datePublished': '1999-12-20T03:46:37.000Z', 'description': 'This is one of those dishes that tradition has snatched. Most everyone has a green bean dish on the menu for the holidays. The almonds are a nice detour from the usual ingredients.', 'prepTime': 'P0DT0H0M', 'cookTime': 'P0DT0H0M', 'totalTime': 'P0DT0H0M', 'recipeYield': '6 to 8 servings', 'recipeIngredient': ['2 pounds fresh green beans, washed and trimmed', '2 slices bacon', '¼ cup sliced almonds'], 'recipeInstructions': [{'@type': 'HowToStep', 'text': 'Remove both ends of beans, break in half, and wash thoroughly.\\n'}, {'@type': 'HowToStep', 'text': 'Place in a large pot and add water 3 to 4 inches from the top. Add bacon and cook until tender.\\n'}, {'@type': 'HowToStep', 'text': 'Remove bacon from cooking water and discard. Remove beans and place in a large bowl, add almonds and toss. Serve Hot.\\n'}], 'recipeCategory': ['Side Dish', 'Vegetable Side Dishes', 'Green Beans'], 'recipeCuisine': [], 'author': {'@type': 'Person', 'name': 'Patti'}, 'aggregateRating': {'@type': 'AggregateRating', 'ratingValue': 4.314285714285714, 'ratingCount': 35, 'itemReviewed': 'Green Beans with Almonds', 'bestRating': '5', 'worstRating': '1'}, 'nutrition': {'@type': 'NutritionInformation', 'calories': '97.1 calories', 'carbohydrateContent': '9.9 g', 'cholesterolContent': '5.4 mg', 'fatContent': '5.5 g', 'fiberContent': '4.8 g', 'proteinContent': '4 g', 'saturatedFatContent': '1.4 g', 'servingSize': null, 'sodiumContent': '74.4 mg', 'sugarContent': '1.9 g', 'transFatContent': null, 'unsaturatedFatContent': null}, 'review': [{'@type': 'Review', 'datePublished': '2008-10-12T02:49:45.947Z', 'reviewBody': \"I would have rated this 5-stars for ingredients and only 2-stars for the cooking method--the idea of cooking the raw bacon in with the cooking water just didn't appeal to me. I sauteed diced bacon with minced garlic then tossed in the beans cooked crisp tender and finished with the almonds which I toasted. Now THAT'S good!\", 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'naples34102', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/naples34102'}}, {'@type': 'Review', 'datePublished': '2006-10-19T13:15:09.893Z', 'reviewBody': 'I revamped this recipe a lot...sorry. I cooked my beans as directed (leaving them slightly undercooked) only I added just a bit of bacon drippings to the water to add flavor. Meanwhile, I sauteed pearl onions & chopped pancetta in EVOO & a little butter until the onions were golden, deglazed the pan w/ a bit of chicken broth, added the green beans (drained) & sliced almonds... as well as a bit of Garlic Butter (recipe frm this site) that I had in the fridge. FANTASTIC!', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 3}, 'author': {'@type': 'Person', 'name': 'IMVINTAGE', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/1379521'}}, {'@type': 'Review', 'datePublished': '2005-07-13T01:25:35.42Z', 'reviewBody': \"Used frozen whole beans from Sam's Club and added a lot more slivered toasted almonds (Trader Joe's). Had to add a great amount of seasoning. I sauteed in butter as well as extra virgin olive oil and added fresh minced garlic. Also seasoning salt and fresh ground black pepper. Without any of the above this would have been blah. For this fact I am giving the recipe a three. With my additions it became a five.\", 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 3}, 'author': {'@type': 'Person', 'name': 'JDVMD', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/595916'}}, {'@type': 'Review', 'datePublished': '2003-06-18T23:23:07.657Z', 'reviewBody': 'Very yummy idea and I used slivered almonds that were treated with garlic to add extra flavor. Yummy!', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'JMSCRUGGS78', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/588566'}}, {'@type': 'Review', 'datePublished': '2011-10-17T19:44:21.72Z', 'reviewBody': 'I used this recipe as a guide but changed the method quite a bit. I cooked my bacon separately cooled and crumbled it. I tossed the almonds in a little of the bacon grease and toasted them in the oven at 350 for about 10 minutes. I cooked my green beans in water until crisp tender drained them and tossed them in a little more of the bacon grease. When it was time to serve I re-heated the beans and bacon in the microwave adding salt and pepper and served them garnished with the toasted almonds. Different method entirely but my results were probably similar to the submitter s intent.', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'bellepepper', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/4452392'}}, {'@type': 'Review', 'datePublished': '2006-08-14T21:56:49.64Z', 'reviewBody': 'Bravo! Incorporating the bacon took the bitterness out of the beans without having to dredge them in butter. My husband LOVED this and he is not a vegetable eater. Will make over and over!', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 5}, 'author': {'@type': 'Person', 'name': 'Paula', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/1567027'}}, {'@type': 'Review', 'datePublished': '2007-08-02T22:55:56.87Z', 'reviewBody': 'I followed this recipe about 95%. Instead of bacon I used unsalted butter strictly and sauteed the beans with almond slivers. I sauteed the beans until they were crispy and not limp. Then after I drained the excess butter. Be careful not to burn the almonds. Do not store covered or they will become soft and limp.', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 4}, 'author': {'@type': 'Person', 'name': 'ARBUTUSROEHM', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/1191154'}}, {'@type': 'Review', 'datePublished': '2004-07-21T13:24:24.81Z', 'reviewBody': 'This just needed a lot more flavor for us. I ended up tossing in melted butter with garlic salt added to it. I think next time I will try simmering the almonds in the garlic butter mixture and just pour over the beans and toss.', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 2}, 'author': {'@type': 'Person', 'name': 'Wilemon', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/536781'}}, {'@type': 'Review', 'datePublished': '2009-12-04T01:55:54.85Z', 'reviewBody': 'I used slivered almonds roasted in toaster oven - be carefull not to burn almonds', 'reviewRating': {'@type': 'Rating', 'worstRating': '1', 'bestRating': '5', 'ratingValue': 5}, 'author': {'@type': 'Person', 'name': 'SuzyQ', 'image': null, 'sameAs': 'https://www.allrecipes.com/cook/suzyq'}}]}";

        JsonParser parser = new JsonParser();

        JsonElement rootElement = parser.parse(rawData);
        Assert.assertNotNull(rootElement);

        JsonObject rootObj = rootElement.getAsJsonObject();
        // Get Food Information
        String foodName = rootObj.get("name").toString();
        String description = rootObj.get("description").toString();
        String prepTime = rootObj.get("prepTime").toString();
        String cookTime = rootObj.get("cookTime").toString();
        String totalTime = rootObj.get("totalTime").toString();
        String recipeYield = rootObj.get("recipeYield").toString();
        String cuisineType = "Italian";
        String category = "Breakfast";

        System.out.println(foodName);
        System.out.println(description);
        System.out.println(prepTime);
        System.out.println(cookTime);
        System.out.println(totalTime);
        System.out.println(recipeYield);

        // Recipe Ingredients
        JsonArray ingredients = rootObj.getAsJsonArray("recipeIngredient");
        String[] recipeIngredients = new String[ingredients.size()];
        System.out.println("-----------Ingredients---------------");
        for (int iter = 0; iter < ingredients.size(); iter++) {
            recipeIngredients[iter] = ingredients.get(iter).toString();
            System.out.println(iter +  " : " + recipeIngredients[iter]);
        }

        // Recipe Instructions
        JsonArray instruction = rootObj.getAsJsonArray("recipeInstructions");
        String[] recipeInstruction = new String[instruction.size()];
        System.out.println("-----------Instructions---------------");
        for (int iter = 0; iter < instruction.size(); iter++) {
            JsonObject obj = instruction.get(iter).getAsJsonObject();
            recipeInstruction[iter] = obj.get("text").toString();
            System.out.println(iter + " : " + recipeInstruction[iter]);
        }

        FoodRecipe recipe = new FoodRecipe(cuisineType, foodName, description, prepTime, cookTime, totalTime, recipeYield, category);

        // Write to Firebase Database
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child(recipe.getCuisineType())
                .child(recipe.getFoodName())
                .setValue(recipe, ((databaseError, databaseReference) -> System.out.println("\nDone Writing to Firebase")));

        for (int iter = 0; iter < recipeIngredients.length; iter++) {
            ref.child(recipe.getCuisineType())
                    .child(recipe.getFoodName())
                    .child("ingredients")
                    .child(iter + "").setValue(recipeIngredients[iter], (databaseError, databaseReference) -> System.out.println("Ingredients Also Added..."));
        }
        // Write Complete

        Thread.sleep(100000);
    }
}
