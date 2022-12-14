package com.example.arena;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Category> categories;

    private static String JSON_URL = "http://10.0.2.2/ArenaServer/food.json";

    private int foodImage;

    CategoryAdapter adapter;





    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        recyclerView = findViewById(R.id.mRecyclerView);
        categories = new ArrayList<>();

        foodImage = R.drawable.food_image_empty;

        addItemsFromJSON();

    }


    private void addItemsFromJSON() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, JSON_URL, null, response -> {
            for (int i = 0; i < response.length(); i++) {
                try {
                    JSONObject categoryObject = response.getJSONObject(i);

                    Category category = new Category();
                    category.setId(categoryObject.getString("id"));
                    category.setName(categoryObject.getString("name"));
                    category.setDescription(categoryObject.getString("description"));
                    category.setPrice(categoryObject.getString("price"));
                    category.setFavorite(categoryObject.getString("favorite"));
                    category.setFoodImage(foodImage);
                    categories.add(category);


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            adapter = new CategoryAdapter(getApplicationContext(), categories);
            recyclerView.setAdapter(adapter);
        }, error -> Log.d("tag", "onErrorResponse: " + error.getMessage()));
        queue.add(jsonArrayRequest);
    }

}

