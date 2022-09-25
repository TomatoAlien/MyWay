package cl.tomato.myway;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;
import cl.tomato.myway.slidingrootnav.SlidingRootNav;
import cl.tomato.myway.slidingrootnav.SlidingRootNavBuilder;


public class paginaPrincipal extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener{

    private static final int POS_CLOSE = 0;
    private static final int POS_DASHBOARD = 1;
    private static final int POS_ACCOUNT = 2;
    private static final int POS_RUTES = 3;
    private static final int POS_NOTES = 4;
    private static final int POS_LOGOUT = 5;

    private String[] screenTitles;
    private Drawable[] screenIcons;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_principal);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withDragDistance(180)
                .withRootViewScale(0.75f)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.drawer_menu)
                .inject();
        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
        createItemFor(POS_CLOSE),
        createItemFor(POS_DASHBOARD).setChecked(true),
        createItemFor(POS_ACCOUNT),
        createItemFor(POS_RUTES),
        createItemFor(POS_NOTES),
        new SpaceItems(260),
        createItemFor(POS_LOGOUT)
        ));
        adapter.setListener(this);

        RecyclerView list = findViewById((R.id.drawer_list));
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);

        adapter.setSelected(POS_DASHBOARD);
    }

    private DrawerItem createItemFor(int position){
        return new SimpleItem(screenIcons[position],screenTitles[position])
                .withIconTint(color(R.color.purple_200))
                .withTextTint(color(R.color.black))
                .withSelectedIconTint(color(R.color.purple_200))
                .withSelectedTextTint(color(R.color.purple_200));
    }
    @ColorInt
    private int color(@ColorRes int res){
        return ContextCompat.getColor(this, res);
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.id_activityScreenTitles);
    }
    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.id_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for(int i = 0; i < ta.length(); i++){
            int id = ta.getResourceId(i, 0);
            if (id != 0){
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onItemSelected(int position) {

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        if(position == POS_DASHBOARD){
            DashBoardFragment dashBoardFragment = new DashBoardFragment();
            transaction.replace(R.id.container, dashBoardFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if(position == POS_ACCOUNT){
            AccountFragment accountFragment = new AccountFragment();
            transaction.replace(R.id.container, accountFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if(position == POS_RUTES   ){
            RutesFragment rutesFragment = new RutesFragment();
            transaction.replace(R.id.container,rutesFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if(position == POS_NOTES   ){
            NotesFragment notesFragment = new NotesFragment();
            transaction.replace(R.id.container,notesFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        else if(position == POS_LOGOUT ){
            finish();
        }

        slidingRootNav.closeMenu();
        transaction.addToBackStack(null);
        transaction.commit();
    }
}