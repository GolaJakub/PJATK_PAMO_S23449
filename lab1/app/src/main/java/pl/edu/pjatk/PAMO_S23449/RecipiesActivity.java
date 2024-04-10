package pl.edu.pjatk.PAMO_S23449;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecipiesActivity extends AppCompatActivity {

    private List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipies_activity);

        recipes = new ArrayList<>();
        recipes.add(new Recipe("Pierś z kurczaka z mozzarellą i pomidorami", new String[]{"pierś z kurczaka 800 gramów", "Sos sałatkowy francuski Knorr", "Przyprawa do złotego kurczaka Knorr", "Fix Gulasz z kurczakiem Knorr", "średnia cebula 1 sztuka", "pomidory 2 sztuki" + "kalarepy 2 sztuki", "mozarella 200 gramów", "papryka 1 sztuka", "suszone pomidory 20 gramów", "jogurt naturalny100 mililitrów", "liść bazylii 3 sztuki"},
                new String[]{"Piersi z kurczaka umyj i osusz. Za pomocą ostrego noża zrób w nich głębokie nacięcia, formując kieszenie. Mięso dopraw do smaku. Dla lepszego efektu możesz zamarynować je w Przyprawie do złotego kurczaka Knorr i pozostawić w chłodnym miejscu na około 20 minut.",
                        "Cebulę pokrój w kostkę i podsmaż na patelni. Bazylię pokrój w paski.", "Ser i suszone pomidory pokrój w drobną kostkę, dodaj wystudzoną cebulę oraz bazylię. Tak przygotowany farsz umieść w kieszonkach kurczaka.",
                "Mięso obsmaż równomiernie na patelni. Na koniec wymieszaj Fix z 300 mililitrami zimnej wody.",
                "Zalej fixem mięso i całość duś powoli, pod przykryciem około 10 minut, co jakiś czas przekładając kurczaka na patelni.",
                "Przygotuj sałatkę: Sos sałatkowy koperkowo-ziołowy Knorr wymieszaj z jogurtem. Kalarepy dokładnie umyj i przekrój na pół. Za pomocą małego nożyka oraz łyżki wydrąż miąższ. Pomidory, paprykę oraz miąższ kalarepy pokrój w kostkę i wymieszaj z wcześniej przygotowanym sosem sałatkowym. Wydrążone kalarepki napełnij sałatką."}));
        recipes.add(new Recipe("Tagliatelle z kurczakiem", new String[]{"makaron tagliatelle 300 gramów", "Naturalnie smaczne Tagliatelle z kurczakiem Knorr", "pierś z kurczaka 1 sztuka",
        "śmietana 18% 150 mililitrów", "woda 100 mililitrów", "starty ser mozzarella 4 łyżki", "olej 2 łyżki"
        }, new String[]{"Pierś kurczaka pokrój w kostkę 1x1 cm. Na patelni rozgrzej olej i usmaż pokrojone mięso.", "W miseczce wymieszaj zawartość opakowania Knorr z wodą i śmietaną, wlej na patelnię i zagotuj.", "Makaron ugotuj al dente we wrzącej lekko osolonej wodzie i odcedź. Ugotowany makaron przełóż na patelnię i wymieszaj z sosem.",
        "Gotowy makaron wyłóż na talerze i posyp startym serem."}));

        RecyclerView recipeList = findViewById(R.id.recipeList);
        RecipeAdapter recipeAdapter = new RecipeAdapter(recipes);
        recipeList.setLayoutManager(new LinearLayoutManager(this));
        recipeList.setAdapter(recipeAdapter);
        configureBackButton();
    }

    private void configureBackButton() {
        Button bmiButton = (Button) findViewById(R.id.back);
        bmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RecipiesActivity.this, HomeActivity.class));
            }
        });
    }



    private class RecipeViewHolder extends RecyclerView.ViewHolder {
        private TextView recipeTitle;
        private RecyclerView recipeIngredientsList;
        private RecyclerView recipeStepsList;

        public RecipeViewHolder(View itemView) {
            super(itemView);
            recipeTitle = itemView.findViewById(R.id.recipeTitle);
            recipeIngredientsList = itemView.findViewById(R.id.recipeIngredientsList);
            recipeStepsList = itemView.findViewById(R.id.recipeStepsList);
        }
    }

    private class RecipeAdapter extends RecyclerView.Adapter<RecipeViewHolder> {

        private List<Recipe> recipes;

        public RecipeAdapter(List<Recipe> recipes) {
            this.recipes = recipes;
        }

        @Override
        public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.recipe_item, parent, false);
            return new RecipeViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecipeViewHolder holder, int position) {
            Recipe recipe = recipes.get(position);
            holder.recipeTitle.setText(recipe.getTitle());

            IngredientAdapter ingredientAdapter = new IngredientAdapter(Arrays.asList(recipe.getIngredients()));
            holder.recipeIngredientsList.setLayoutManager(new LinearLayoutManager(holder.recipeIngredientsList.getContext()));
            holder.recipeIngredientsList.setAdapter(ingredientAdapter);

            StepAdapter stepAdapter = new StepAdapter(Arrays.asList(recipe.getSteps()));
            holder.recipeStepsList.setLayoutManager(new LinearLayoutManager(holder.recipeStepsList.getContext()));
            holder.recipeStepsList.setAdapter(stepAdapter);
        }

        @Override
        public int getItemCount() {
            return recipes.size();
        }
    }

    private class IngredientViewHolder extends RecyclerView.ViewHolder {
        private TextView ingredientText;
        private CheckBox ingredientCheckbox;

        public IngredientViewHolder(View itemView) {
            super(itemView);
            ingredientText = itemView.findViewById(R.id.ingredientText);
            ingredientCheckbox = itemView.findViewById(R.id.ingredientCheckbox);
        }
    }

    private class IngredientAdapter extends RecyclerView.Adapter<IngredientViewHolder> {

        private List<String> ingredients;

        public IngredientAdapter(List<String> ingredients) {
            this.ingredients = ingredients;
        }

        @Override
        public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.ingredient_item, parent, false);
            return new IngredientViewHolder(view);
        }

        @Override
        public void onBindViewHolder(IngredientViewHolder holder, int position) {
            String ingredient = ingredients.get(position);
            holder.ingredientText.setText(ingredient);
            holder.ingredientCheckbox.setChecked(false);
        }

        @Override
        public int getItemCount() {
            return ingredients.size();
        }
    }

    private class StepAdapter extends RecyclerView.Adapter<StepAdapter.StepViewHolder> {

        private List<String> steps;

        public StepAdapter(List<String> steps) {
            this.steps = steps;
        }

        @Override
        public StepViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.step_item, parent, false);
            return new StepViewHolder(view);
        }

        @Override
        public void onBindViewHolder(StepViewHolder holder, int position) {
            String step = steps.get(position);
            holder.stepText.setText(step);
        }

        @Override
        public int getItemCount() {
            return steps.size();
        }

        private class StepViewHolder extends RecyclerView.ViewHolder {
            private TextView stepText;

            public StepViewHolder(View itemView) {
                super(itemView);
                stepText = itemView.findViewById(R.id.stepText);
            }
        }
    }

    private static class Recipe {
        private String title;
        private String[] ingredients;
        private String[] steps;

        public Recipe(String title, String[] ingredients, String[] steps) {
            this.title = title;
            this.ingredients = ingredients;
            this.steps = steps;
        }

        public String getTitle() {
            return title;
        }

        public String[] getIngredients() {
            return ingredients;
        }

        public String[] getSteps() {
            return steps;
        }
    }
}