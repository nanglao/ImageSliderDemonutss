package com.exampledemo.parsaniahardik.imagesliderdemonuts;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.AppBarLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.DefaultSliderView;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.model.CategoryModel;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.model.SliderImageModel;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.remote.ApiUtils;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.remote.SOService;
import com.exampledemo.parsaniahardik.imagesliderdemonuts.util.RecyclerViewUtils;
import com.viewpagerindicator.CirclePageIndicator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    // We need a reference to save/restore its state
    private RecyclerViewUtils.ShowHideToolbarOnScrollingListener showHideToolbarListener;
    private RecyclerView recyclerView,rvBestDealHome;
    private AlbumsAdapter adapter;
    private AlbumsAdapter madapter;
    private List<Album> albumList;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private ArrayList<SliderImageModel> sliderImageArrayList;


    private SOService mService;
    Context mContext;
    ProgressDialog loading;
    public static List<CategoryModel> categorieslist;
    Spinner spinnerCategory;
    Toolbar toolbar;
    EditText editText;
    Button btnSeeMore;

    private SliderLayout ImageSlider;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


        //button for see more best deal
        btnSeeMore = (Button)findViewById(R.id.btnSeeMore);
        btnSeeMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBDSeeMore=new Intent(getApplicationContext(),BestDeal_SeeMore.class);
                startActivity(intentBDSeeMore);
                setContentView(R.layout.bestdeal_seemore);
                Log.e("Button Click: ", "Another Intent:" );
            }
        });


        editText = (EditText)findViewById(R.id.editText);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        AppBarLayout.LayoutParams params = (AppBarLayout.LayoutParams) toolbar.getLayoutParams();
        params.setScrollFlags(0);
        setSupportActionBar(toolbar);
        // Remove default title text
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ImageSlider = (SliderLayout) findViewById(R.id.slider);

        //spinner with retrofit api data
        spinnerCategory = (Spinner) findViewById(R.id.spinner);
        mService = ApiUtils.getSOService();

        sliderImageArrayList = new ArrayList<>();
        sliderImageArrayList = sliderImageinit();
        init();

        initSpinnerCategory();
        spinnerCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
                //   Toast.makeText(mContext, "Spinner Category " + selectedName, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//        if (savedInstanceState != null) {
//            showHideToolbarListener.onRestoreInstanceState((RecyclerViewUtils.ShowHideToolbarOnScrollingListener.State) savedInstanceState
//                    .getParcelable(RecyclerViewUtils.ShowHideToolbarOnScrollingListener.SHOW_HIDE_TOOLBAR_LISTENER_STATE));
//        }
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        outState.putParcelable(RecyclerViewUtils.ShowHideToolbarOnScrollingListener.SHOW_HIDE_TOOLBAR_LISTENER_STATE,
//                showHideToolbarListener.onSaveInstanceState());
//        super.onSaveInstanceState(outState);
   // }

    @Override
    protected void onStop() {
        // To prevent a memory leak on rotation, make sure to call stopAutoCycle() on the slider before activity or fragment is destroyed
        ImageSlider.stopAutoCycle();
        super.onStop();
    }


    private void initSpinnerCategory() {
        mService.getCategory().enqueue(new Callback<List<CategoryModel>>() {
            @Override
            public void onResponse(Call<List<CategoryModel>> call, Response<List<CategoryModel>> response) {

                if (response.isSuccessful()) {
                    Log.e("category", "success:" + response.body().get(0).getName());

                    List<CategoryModel> categorieslist = response.body();
                    List<String> listSpinner = new ArrayList<>();

                    for (int i = 0; i < categorieslist.size(); i++) {
                        listSpinner.add(categorieslist.get(i).getName());
                    }

                    ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerCategory.setAdapter(adapter);
                } else {
                    //Toast.makeText(MainActivity.this, "List not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CategoryModel>> call, Throwable t) {
                Log.e("category", "error : " + t.getMessage());
            }
        });


        //recycler view with  card view
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        albumList = new ArrayList<>();
        adapter = new AlbumsAdapter(this, albumList);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(2), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        prepareAlbums();

        try {
            // Glide.with(this).load(R.drawable.cover).into((ImageView) findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //bestdeal
        rvBestDealHome = (RecyclerView) findViewById(R.id.rvBestDealHome);

        albumList = new ArrayList<>();
        madapter = new AlbumsAdapter(this, albumList);
       RecyclerView.LayoutManager rvLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.HORIZONTAL, false);
       // RecyclerView.LayoutManager rvLayoutManager = new GridLayoutManager(this, 3);
        rvBestDealHome.setLayoutManager(rvLayoutManager );
       // rvBestDealHome.addItemDecoration(new GridSpacingItemDecoration(3, dpToPx(2), true));
        rvBestDealHome.setItemAnimator(new DefaultItemAnimator());
        rvBestDealHome.setAdapter(madapter);
        prepareAlbums();
    }

    private ArrayList<SliderImageModel> sliderImageinit() {
        final ArrayList<SliderImageModel> listImage = new ArrayList<>();
        mService.getSliderImage().enqueue(new Callback<List<SliderImageModel>>() {
            @Override
            public void onResponse(Call<List<SliderImageModel>> call, Response<List<SliderImageModel>> response) {
                if (response.isSuccessful()) {
                    Log.e("SlideImage", "success:" + response.body().get(0).getImagePath());
                    Log.e("Response Body : ", "success:" + response.body().size());
                    HashMap<String, String> url_maps = new HashMap<String, String>();
                    for (int i = 0; i < response.body().size(); i++) {
                        SliderImageModel sliderImage = new SliderImageModel();
                        sliderImage.setImagePath(response.body().get(i).getImagePath());
                        Log.e("Response Body : ", "success:" + response.body().get(i).getImagePath());

                        listImage.add(sliderImage);
                        Log.e("ArraySize: ", "ImageSIze:" + listImage.size());
                        url_maps.put(String.valueOf(response.body().get(i).getId()),"http://192.168.100.14:8080" + response.body().get(i).getImagePath());
                    }

                    for (String name : url_maps.keySet()) {
                        DefaultSliderView textSliderView = new DefaultSliderView(MainActivity.this);
                        // initialize a SliderLayout
                        textSliderView
                                .description(name)
                                .image(url_maps.get(name))
                                .setScaleType(BaseSliderView.ScaleType.Fit);

                        ImageSlider.addSlider(textSliderView);
                    }
                    ImageSlider.setPresetTransformer(SliderLayout.Transformer.Default);
                    ImageSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
                    ImageSlider.setDuration(4000);
                }
            }

            @Override
            public void onFailure(Call<List<SliderImageModel>> call, Throwable t) {
            }
        });
        return listImage;
    }

//
    //For slider
    private void init() {
        mPager = (ViewPager) findViewById(R.id.pager);
        SlidingImage_Adapter slide_adapter = new SlidingImage_Adapter(this, sliderImageArrayList);
        //mPager.setAdapter(new SlidingImage_Adapter(MainActivity.this,imageModelArrayList));
        slide_adapter.notifyDataSetChanged();
        mPager.setAdapter(slide_adapter);

        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);
        indicator.notifyDataSetChanged();
        final float density = getResources().getDisplayMetrics().density;
        //Set circle indicator radius
        indicator.setRadius(5 * density);
        // NUM_PAGES =imageModelArrayList.size();
        NUM_PAGES = sliderImageArrayList.size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;
            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }

    /**
     * Adding few albums for card view image
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.pho1,
                R.drawable.pho2,
                R.drawable.pho3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10};

        Album a = new Album("Ks-240,000", 20, covers[0]);
        albumList.add(a);

        a = new Album("Ks-18,000", 40, covers[1]);
        albumList.add(a);

        a = new Album("Ks-23,000", 35, covers[2]);
        albumList.add(a);

//        a = new Album("Born to Die", 12, covers[3]);
//        albumList.add(a);
//
//        a = new Album("Honeymoon", 14, covers[4]);
//        albumList.add(a);
//
//        a = new Album("I Need a Doctor", 1, covers[5]);
//        albumList.add(a);

        adapter.notifyDataSetChanged();
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    public class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {
        private int spanCount;
        private int spacing;
        private boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spacing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spacing = spacing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            int position = parent.getChildAdapterPosition(view); // item position
            int column = position % spanCount; // item column

            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                if (position < spanCount) { // top edge
                    outRect.top = spacing;
                }
                outRect.bottom = spacing; // item bottom
            } else {
                outRect.left = column * spacing / spanCount; // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount; // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing; // item top
                }
            }
        }
    }

    /**
     * Converting dp to pixel
     */
    private int dpToPx(int dp) {
        Resources r = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics()));
    }





}
