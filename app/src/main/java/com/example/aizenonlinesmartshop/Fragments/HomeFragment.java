package com.example.aizenonlinesmartshop.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.aizenonlinesmartshop.Adapters.IconAdapter;
import com.example.aizenonlinesmartshop.Adapters.ImageAdapter;
import com.example.aizenonlinesmartshop.Adapters.ItemHomeAdapter;
import com.example.aizenonlinesmartshop.Adapters.OfferAdapter;
import com.example.aizenonlinesmartshop.Adapters.SliderAdapter;
import com.example.aizenonlinesmartshop.Adapters.SpotLight;
import com.example.aizenonlinesmartshop.CartActivity;
import com.example.aizenonlinesmartshop.Login.LoginSignupActivity;
import com.example.aizenonlinesmartshop.Main_Item_Activity;
import com.example.aizenonlinesmartshop.Models.ImageOffer;
import com.example.aizenonlinesmartshop.Models.Item;
import com.example.aizenonlinesmartshop.Models.Offer;
import com.example.aizenonlinesmartshop.Models.SliderData;
import com.example.aizenonlinesmartshop.R;
import com.example.aizenonlinesmartshop.SearchActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    DrawerLayout drawerLayout;
    // Urls of our images.

    ImageView searchImage,cart;

    SliderView sliderView;

    private RecyclerView recyclerView,rec,rect,r2,r3;
    ArrayList<Item> list;
    IconAdapter iconAdapter;
    TextView logOut;
    Toolbar toolbar;
    ImageView menuItem;
    ArrayList<Offer> offers;
    OfferAdapter offerAdapter;

    ArrayList<Offer> mList;
    SpotLight spotLight;

    ArrayList<ImageOffer> kList;
    ImageAdapter imageAdapter;

    ArrayList<ImageOffer> sList;
    ItemHomeAdapter itemHomeAdapter;

    LinearLayout login;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        cart=view.findViewById(R.id.cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), CartActivity.class));
            }
        });

        sliderView=view.findViewById(R.id.slider);
        searchImage=view.findViewById(R.id.searchItem);

        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),SearchActivity.class));
            }
        });

//

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();



        // adding the urls inside array list
        sliderDataArrayList.add(new SliderData(R.drawable.vbvhesrt));
        sliderDataArrayList.add(new SliderData(R.drawable.ghfhtdhtd));
        sliderDataArrayList.add(new SliderData(R.drawable.beautysad));

        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(getContext(), sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(3);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();
        login=view.findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), LoginSignupActivity.class));
            }
        });

        logOut=view.findViewById(R.id.logOut);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent=new Intent(getContext(), Main_Item_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        menuItem=view.findViewById(R.id.menu_Item);
        menuItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDrawer(drawerLayout);
            }
        });
        drawerLayout=view.findViewById(R.id.drawer_layout);
        recyclerView = view.findViewById(R.id.recyclerview);
        rec = view.findViewById(R.id.recy);
        rect=view.findViewById(R.id.r1);
        r2=view.findViewById(R.id.r2);
        r3=view.findViewById(R.id.r3);
        list = new ArrayList<>();

        list.add(new Item(R.drawable.mens, "MEN"));
        list.add(new Item(R.drawable.womns, "WOMEN"));
        list.add(new Item(R.drawable.kdf, "KIDS"));
        list.add(new Item(R.drawable.beautysad, "BEAUTY"));
        list.add(new Item(R.drawable.homesdw, "HOME"));
        list.add(new Item(R.drawable.fhgu, "FOOTWEAR"));
        list.add(new Item(R.drawable.gdtf, "ELECTRONICS"));
        list.add(new Item(R.drawable.jhgh, "JEWELLERY"));
        iconAdapter = new IconAdapter(list, getContext());

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(iconAdapter);
        // HorizontalLayout
        //            = new LinearLayoutManager(
        //                MainActivity.this,
        //                LinearLayoutManager.HORIZONTAL,
        //                false);
        //        recyclerView.setLayoutManager(HorizontalLayout);
        //
        //        // Set adapter on recycler view
        //        recyclerView.setAdapter(adapter);

        offers=new ArrayList<>();
        offers.add(new Offer(R.drawable.beautysad,"Sparx","30% Off"));
        offers.add(new Offer(R.drawable.beautysad,"Sparx","30% Off"));
        offers.add(new Offer(R.drawable.beautysad,"Sparx","30% Off"));
        offers.add(new Offer(R.drawable.beautysad,"Sparx","30% Off"));
        offers.add(new Offer(R.drawable.beautysad,"Sparx","30% Off"));
        offers.add(new Offer(R.drawable.beautysad,"Sparx","30% Off"));
        offerAdapter=new OfferAdapter(offers,getContext());

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(offerAdapter);

        mList=new ArrayList<>();
        mList.add(new Offer(R.drawable.beautysad,"Lotto","80% Off"));
        mList.add(new Offer(R.drawable.beautysad,"Lotto","330% Off"));
        mList.add(new Offer(R.drawable.beautysad,"SCampus","40% Off"));
        mList.add(new Offer(R.drawable.beautysad,"Campus","90% Off"));
        mList.add(new Offer(R.drawable.beautysad,"Sparky","89% Off"));
        mList.add(new Offer(R.drawable.beautysad,"Sparky","39% Off"));
        spotLight=new SpotLight(mList,getContext());

        LinearLayoutManager linearLayouts=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        rect.setLayoutManager(linearLayouts);
        rect.setAdapter(spotLight);



        //

        kList=new ArrayList<>();
        kList.add(new ImageOffer(R.drawable.beautysad));
        kList.add(new ImageOffer(R.drawable.beautysad));
        kList.add(new ImageOffer(R.drawable.beautysad));
        kList.add(new ImageOffer(R.drawable.beautysad));
        kList.add(new ImageOffer(R.drawable.beautysad));
        imageAdapter=new ImageAdapter(kList,getContext());

        LinearLayoutManager linearLayouty=new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        r2.setLayoutManager(linearLayouty);
        r2.setAdapter(imageAdapter);

        //

        sList=new ArrayList<>();
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));
        sList.add(new ImageOffer(R.drawable.fhj));

        itemHomeAdapter=new ItemHomeAdapter(sList,getContext());

        LinearLayoutManager linearLayoutz=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        r3.setLayoutManager(linearLayoutz);
        r3.setAdapter(itemHomeAdapter);
        return view;

    }



  //  public void clickItem(View view){
   //     openDrawer(drawerLayout);
   // }

    private static void openDrawer(DrawerLayout drawerLayout) {
        drawerLayout.openDrawer(GravityCompat.START);


    }
    public void clickLogo(View view){
        closeDrawer(drawerLayout);
    }

    private static void closeDrawer(DrawerLayout drawerLayout) {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }

    }


    public void notes(View view){

    }


}