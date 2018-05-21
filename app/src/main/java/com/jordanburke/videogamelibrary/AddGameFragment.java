package com.jordanburke.videogamelibrary;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AddGameFragment extends Fragment{

    @BindView(R.id.game_name_edit)
    protected EditText nameEdit;
    @BindView(R.id.summary_view_edit)
    protected EditText summaryEdit;
    @BindView(R.id.item_game_title)
    protected TextView gameTitle;
    @BindView(R.id.item_date)
    protected TextView gameDate;
    @BindView(R.id.item_genre_view)
    protected TextView genreView;
    private VideoGameDatabase videoGameDatabase;
    private GameModel videoGame;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_game, container, false);
        ButterKnife.bind(this, view);
        
        return view;
        
        
    }

    public static AddGameFragment newInstance() {
        
        Bundle args = new Bundle();
        
        AddGameFragment fragment = new AddGameFragment();
        fragment.setArguments(args);
        return fragment;
    }

//    public void attackParent(ActivityCallBack activityCallBack) {
//
//
//
//    }

    public interface activityCallBack {

    }
    @OnClick(R.id.add_game_fab)
    protected void addButtonCLicked () {

        // TODO - Add check to make sure both fields have text.
        // Get Title and genre from edit text, Create new video game
        // object with this information, send to database to be saves,
        // Toast that game has been saved


        String userNameEdit = nameEdit.getText().toString();
        String userSummaryEdit = summaryEdit.getText().toString();
        String userGenreView = genreView.getText().toString();

        if (userNameEdit == "" || userSummaryEdit == "") {
            Toast myToast = new Toast(getActivity());
           myToast.makeText(getActivity(), "NO TEXT FOUND", Toast.LENGTH_LONG).show();

        } else {
            Toast myToast = new Toast(getActivity());
            myToast.makeText(getActivity(), "Game Added!", Toast.LENGTH_LONG).show();
        }
        gameTitle.setText(userNameEdit);
        gameDate.setText(userSummaryEdit);

//        addGameToDatabase(gameTitle, gameDate);

    }
    private void addGameToDatabase() {
//        GameModel videoGame = new GameModel(gameTitle, gameDate,false);
        videoGameDatabase.videoGameDao().addVideoGame(videoGame);

    }

    @Override
    public void onStart() {
        super.onStart();
        videoGameDatabase = ((VideoGameApplication) getActivity().getApplicationContext()).getDatabase();
    }
}
