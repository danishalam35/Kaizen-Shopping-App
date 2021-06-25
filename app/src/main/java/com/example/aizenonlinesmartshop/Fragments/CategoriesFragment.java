package com.example.aizenonlinesmartshop.Fragments;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.aizenonlinesmartshop.R;


public class CategoriesFragment extends Fragment {
    ImageButton arrow,a1,a2,a3,a4,a5,a6;
    LinearLayout hiddenView,h1,h2,h3,h4,h5,h6;
    public CardView cardView,c1,c2,c3,c4,c5,c6;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        cardView =view.findViewById(R.id.cardView);
        arrow = view.findViewById(R.id.arrow_button);
        hiddenView = view.findViewById(R.id.hidden_view);
        c1=view.findViewById(R.id.cardViewa);
        c2=view.findViewById(R.id.cardViewb);
        c3=view.findViewById(R.id.cardViewc);
        c4=view.findViewById(R.id.cardViewd);
        c5=view.findViewById(R.id.cardViewf);
        h5=view.findViewById(R.id.hidden_viewe);
        a5=view.findViewById(R.id.arrow_buttone);
        h4=view.findViewById(R.id.l3);
        a4=view.findViewById(R.id.arrowd);
        h3=view.findViewById(R.id.hidden_viewc);
        a3=view.findViewById(R.id.arrow_buttonc);
        h2=view.findViewById(R.id.l1);
        a2=view.findViewById(R.id.arrow_buttonb);

        h1=view.findViewById(R.id.hidden_viewa);
        a1=view.findViewById(R.id.arrow_buttona);



       cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (hiddenView.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.GONE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(cardView,
                            new AutoTransition());
                    hiddenView.setVisibility(View.VISIBLE);
                    arrow.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });

        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (h1.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(c1,
                            new AutoTransition());
                    h1.setVisibility(View.GONE);
                    a1.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(c1,
                            new AutoTransition());
                    h1.setVisibility(View.VISIBLE);
                    a1.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (h2.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(c2,
                            new AutoTransition());
                    h2.setVisibility(View.GONE);
                    a2.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(c2,
                            new AutoTransition());
                    h2.setVisibility(View.VISIBLE);
                    a2.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });

        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (h3.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(c3,
                            new AutoTransition());
                    h3.setVisibility(View.GONE);
                    a3.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(c3,
                            new AutoTransition());
                    h3.setVisibility(View.VISIBLE);
                    a3.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });


        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (h4.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(c3,
                            new AutoTransition());
                    h4.setVisibility(View.GONE);
                    a4.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(c4,
                            new AutoTransition());
                    h4.setVisibility(View.VISIBLE);
                    a4.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });

        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // If the CardView is already expanded, set its visibility
                //  to gone and change the expand less icon to expand more.
                if (h5.getVisibility() == View.VISIBLE) {

                    // The transition of the hiddenView is carried out
                    //  by the TransitionManager class.
                    // Here we use an object of the AutoTransition
                    // Class to create a default transition.
                    TransitionManager.beginDelayedTransition(c5,
                            new AutoTransition());
                    h5.setVisibility(View.GONE);
                    a5.setImageResource(R.drawable.ic_baseline_expand_more_24);
                }

                // If the CardView is not expanded, set its visibility
                // to visible and change the expand more icon to expand less.
                else {

                    TransitionManager.beginDelayedTransition(c5,
                            new AutoTransition());
                    h5.setVisibility(View.VISIBLE);
                    a5.setImageResource(R.drawable.ic_baseline_expand_less_24);
                }
            }
        });


        return view;
    }



}