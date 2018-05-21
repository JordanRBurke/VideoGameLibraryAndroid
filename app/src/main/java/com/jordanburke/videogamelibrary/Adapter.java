package com.jordanburke.videogamelibrary;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

    private final AdapterCallBack adapterCallBack;
    private List<GameModel> gameList;

    
    

    public Adapter(List<GameModel> gameList, AdapterCallBack adapterCallBack) {

        this.gameList = gameList;
        this.adapterCallBack = adapterCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video_game, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        super.onBindViewHolder(holder, position, payload);
        holder.bind(gameList.get(position));
        holder.gameItemBackground.setOnClickListener(holder.onRowClicked(gameList.get(position)));
    }
    

//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List payloads) {
//
//
//    }

    @Override
    public int getItemCount() {
        return gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

        private TextView gameName;
        private TextView gameGenre;
        private TextView gameDate;
        private ConstraintLayout gameItemBackground;
        private AdapterCallBack adapterCallBack;
        

        public ViewHolder (View itemView) {
            super(itemView);

            gameName = itemView.findViewById(R.id.item_game_title);
            gameGenre = itemView.findViewById(R.id.item_genre_view);
            gameDate = itemView.findViewById(R.id.item_date);
            gameItemBackground = itemView.findViewById(R.id.item_row_layout);

        }

        
        
        

        public void bind(GameModel position) {
//            studentName.setText(studentList.get(position).getName());
//            studentAge.setText(studentList.get(position).getAge());
//            studentPhoneType.setText(studentList.get(position).getPhoneNumber());
//            studentSummary.setText(studentList.get(position).getSummary());


        }

        public View.OnClickListener onRowClicked(final GameModel gameModel) {


            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    adapterCallBack.rowClicked(gameModel);
                }
            };
        }


//        @Override
//        public void onClick(View v) {
////            gameList.get()
//        }
    }

    public interface AdapterCallBack {
        void rowClicked(GameModel gameModel);

    }

    
}

