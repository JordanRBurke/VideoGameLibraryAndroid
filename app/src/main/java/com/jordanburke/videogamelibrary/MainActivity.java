package com.jordanburke.videogamelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Adapter.AdapterCallBack {

    @BindView(R.id.recycler_view_main)
    protected RecyclerView recyclerViewMain;
    private VideoGameDatabase videoGameDatabase;
    private Adapter adapter;
    private List<GameModel> gameList;
    private LinearLayoutManager linearLayoutManager;
    AddGameFragment addGameFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        videoGameDatabase = ((VideoGameApplication) getApplicationContext()).getDatabase();

        setUpRecyclerView();

    }

    private void setUpRecyclerView() {
        linearLayoutManager = new LinearLayoutManager(getApplicationContext());

        adapter = new Adapter(videoGameDatabase.videoGameDao().getVideoGames(),
                this);

        recyclerViewMain.setLayoutManager(linearLayoutManager);
        recyclerViewMain.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

//    @OnClick(R.id.add_game_fab)
//    protected void addGameButtonClicked() {
//
//        AddGameFragment addGameFragment = AddGameFragment.newInstance();
////        AddGameFragment.attachParent(this);
//        getSupportFragmentManager().beginTransaction().replace(R.id.recycler_view_main)
//
//    }
//
//    @Override
//    public void addClicked() {
//
//
//        addGameFragment.setArguments(null);
//        adapter.notifyDataSetChanged();
//
//    }


    @Override
    public void rowClicked(GameModel gameModel) {
        Toast.makeText(this, gameModel.getGameTitle(), Toast.LENGTH_SHORT).show();
    }
}
