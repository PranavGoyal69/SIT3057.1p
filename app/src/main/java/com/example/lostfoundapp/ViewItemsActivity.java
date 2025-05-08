package com.example.lostfoundapp;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewItemsActivity extends AppCompatActivity {
    private DatabaseHelper dbHelper;
    private RecyclerView recyclerView;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_items);

        dbHelper = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        loadItems();
    }

    private void loadItems() {
        Cursor cursor = dbHelper.getAllItems();
        if (cursor.getCount() == 0) {
            Toast.makeText(this, "No items found", Toast.LENGTH_SHORT).show();
        } else {
            adapter = new ItemAdapter(this, cursor);
            recyclerView.setAdapter(adapter);
        }
    }

    public void deleteItem(long id) {
        if (dbHelper.deleteItem(id)) {
            Toast.makeText(this, "Item deleted", Toast.LENGTH_SHORT).show();
            loadItems();
        } else {
            Toast.makeText(this, "Error deleting item", Toast.LENGTH_SHORT).show();
        }
    }
}