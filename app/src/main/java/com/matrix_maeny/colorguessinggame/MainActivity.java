package com.matrix_maeny.colorguessinggame;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix_maeny.colorguessinggame.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ResultDialog.ResultDialogListener {

    private ActivityMainBinding binding;

    private final String[] colorNames = {
            "YELLOW", "MELLOW", "CYBER", "ROYAL", "TROMBONE", "BANANA", "TUSCANY", "LEMON", "BUMBLEBEE", "FLAX", "CREAM",
            "PEACH", "LAGUNA", "MUSTARD", "ECRU", "CORN", "PINEAPPLE", "FLAXEN", "EGG_NOG", "SEPIA",

            "ORANGE", "GOLD", "GOLDENROD", "PUMPKIN", "FIRE", "OCHRE", "AMBER", "DIJON", "TIGER", "HONEY",
            "CARROT", "APRICOT", "BRONZE", "CIDER", "CLAY", "RUST", "AMBER_2", "SPICE", "BURNT_OR",

            "RED", "SALMON", "SCARLET", "BARN_RED", "IMPERIAL", "INDIAN_RED", "CHILI", "FIRE_BRICK", "MAROON", "REDWOOD",
            "RASPBERRY", "CANDY_APPLY", "CARMINE", "PERSIAN", "U_S_FLAG", "FERRARI", "BURGUNDY", "CRIMSON", "SANGRIA", "MAHOGANY",

            "PINK", "RUBY", "ULTRA", "MAGENTA", "ROSE_PINK", "LAVENDER", "CREAMY", "FUCHSIA", "FRENCH_ROSE", "CERISE",
            "CARNATION", "BRICK", "AMARANTH", "TAFFY", "BUBBLE_GUM", "HOT_PINK", "PUNCH", "LEMONADE", "FLAMINGO",

            "VIOLET", "HIBISCUS", "MAUVE", "MULBERRY", "ORCHID", "LILAC", "ELECTRIC", "AFRICAN", "GRAPE", "AMETHYST",
            "BYZANTINE", "FANDANGO", "HELIO", "FLORAL", "THISTLE", "LOLLIPOP", "PLUM", "EGGPLANT",

            "BLUE", "DENIM", "PIGEON", "SKY", "INDEPENDENCE", "AIR_FORCE", "BABY_BLUE", "NAVY", "STEEL", "CAROLINA",
            "TURKISH", "MAYA", "CORNFLOWER", "OLYMPIC", "SAPPHIRE", "AZURE", "EGYPTIAN", "YALE", "PRUSSIAN", "SPACE",

            "GREEN", "FOREST", "SAGE", "OLIVE", "LIME", "HUNTER", "JADE", "ARTICHOKE", "FERN", "JUNGLE",
            "LAUREL", "MOSS", "MINT", "PINE", "TEA", "ARMY", "EMERALD", "KELLY", "SACRAMENTO", "SEA",

            "BROWN", "CEDAR", "CINNAMON", "BRUNETTE", "TAWNY", "UMBER", "TORTILLA", "CHOCOLATE", "SYRUP", "GINGERBREAD",
            "CARAMEL", "WALNUT", "PECAN", "WOOD", "HICKORY", "ESPRESSO", "PEANUT", "MOCHA", "COFFEE", "RUSSET",

            "GRAY", "FOSSIL", "MINK", "PEARL_RIVER", "ABALONE", "HARBOR_GRAY", "SMOKE", "THUNDER", "PEWTER", "STONE",
            "IRON", "RHINO", "TROUT", "SEAL", "LAVA", "SHADOW", "ASH", "ANCHOR", "CHARCOAL", "BLACK", "WHITE"


    };
    private final int[] colorCodes = {
            R.color.YELLOW, R.color.MELLOW, R.color.CYBER, R.color.ROYAL, R.color.TROMBONE, //20
            R.color.BANANA, R.color.TUSCANY, R.color.LEMON, R.color.BUMBLEBEE, R.color.FLAX,
            R.color.CREAM, R.color.PEACH, R.color.LAGUNA, R.color.MUSTARD, R.color.ECRU, R.color.CORN,
            R.color.PINEAPPLE, R.color.FLAXEN, R.color.EGG_NOG, R.color.SEPIA,

            R.color.ORANGE, R.color.GOLD, R.color.GOLDENROD, R.color.PUMPKIN, R.color.FIRE, R.color.OCHRE, // 19
            R.color.AMBER, R.color.DIJON, R.color.TIGER, R.color.HONEY, R.color.CARROT,
            R.color.APRICOT, R.color.BRONZE, R.color.CIDER, R.color.CLAY, R.color.RUST, R.color.AMBER_2,
            R.color.SPICE, R.color.BURNT_OR,

            R.color.RED, R.color.SALMON, R.color.SCARLET, R.color.BARN_RED, R.color.IMPERIAL, // 20
            R.color.INDIAN_RED, R.color.CHILI, R.color.FIRE_BRICK, R.color.MAROON, R.color.REDWOOD,
            R.color.RASPBERRY, R.color.CANDY_APPLY, R.color.CARMINE, R.color.PERSIAN, R.color.U_S_FLAG,
            R.color.FERRARI, R.color.BURGUNDY, R.color.CRIMSON, R.color.SANGRIA, R.color.MAHOGANY,

            R.color.PINK, R.color.RUBY, R.color.ULTRA, R.color.MAGENTA, R.color.ROSE_PINK, //19
            R.color.LAVENDER, R.color.CREAMY, R.color.FUCHSIA, R.color.FRENCH_ROSE, R.color.CERISE,
            R.color.CARNATION, R.color.BRICK, R.color.AMARANTH, R.color.TAFFY, R.color.BUBBLE_GUM,
            R.color.HOT_PINK, R.color.PUNCH, R.color.LEMONADE, R.color.FLAMINGO,

            R.color.VIOLET, R.color.HIBISCUS, R.color.MAUVE, R.color.MULBERRY, R.color.ORCHID, //18
            R.color.LILAC, R.color.ELECTRIC, R.color.AFRICAN, R.color.GRAPE, R.color.AMETHYST,
            R.color.BYZANTINE, R.color.FANDANGO, R.color.HELIO, R.color.FLORAL, R.color.THISTLE,
            R.color.LOLLIPOP, R.color.PLUM, R.color.EGGPLANT,

            R.color.BLUE, R.color.DENIM, R.color.PIGEON, R.color.SKY, R.color.INDEPENDENCE, // 20
            R.color.AIR_FORCE, R.color.BABY_BLUE, R.color.NAVY, R.color.STEEL, R.color.CAROLINA,
            R.color.TURKISH, R.color.MAYA, R.color.CORNFLOWER, R.color.OLYMPIC, R.color.SAPPHIRE,
            R.color.AZURE, R.color.EGYPTIAN, R.color.YALE, R.color.PRUSSIAN, R.color.SPACE,

            R.color.GREEN, R.color.FOREST, R.color.SAGE, R.color.OLIVE, R.color.LIME, R.color.HUNTER, //20
            R.color.JADE, R.color.ARTICHOKE, R.color.FERN, R.color.JUNGLE, R.color.LAUREL, R.color.MOSS,
            R.color.MINT, R.color.PINE, R.color.TEA, R.color.ARMY, R.color.EMERALD, R.color.KELLY,
            R.color.SACRAMENTO, R.color.SEA,

            R.color.BROWN, R.color.CEDAR, R.color.CINNAMON, R.color.BRUNETTE, R.color.TAWNY, R.color.UMBER, // 20
            R.color.TORTILLA, R.color.CHOCOLATE, R.color.SYRUP, R.color.GINGERBREAD, R.color.CARAMEL,
            R.color.WALNUT, R.color.PECAN, R.color.WOOD, R.color.HICKORY, R.color.ESPRESSO,
            R.color.PEANUT, R.color.MOCHA, R.color.COFFEE, R.color.RUSSET,

            R.color.GRAY, R.color.FOSSIL, R.color.MINK, R.color.PEARL_RIVER, R.color.ABALONE, // 21
            R.color.HARBOR_GRAY, R.color.SMOKE, R.color.THUNDER, R.color.PEWTER, R.color.STONE,
            R.color.IRON, R.color.RHINO, R.color.TROUT, R.color.SEAL, R.color.LAVA,
            R.color.SHADOW, R.color.ASH, R.color.ANCHOR, R.color.CHARCOAL, R.color.black, R.color.white

    };

    private final boolean[] options = {false, false, false, false};
    private int randomOption = -1;
    private TextView[] randViews;
    private MediaPlayer player;
    private boolean sounds = true;
    private boolean start = false;

    private int score = 0, count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        randViews = new TextView[]{binding.optionTv1, binding.optionTv2, binding.optionTv3, binding.optionTv4};

        startPlay();

    }

    @SuppressLint("SetTextI18n")
    private void startPlay() {
        start = true;
        Random random = new Random();

        for (int i = 0; i < 4; i++) {
            options[i] = false;
            randViews[i].setBackgroundResource(R.drawable.option_bg);
        }

        int randomColor = random.nextInt(177);
        binding.cardView.setCardBackgroundColor(getResources().getColor(colorCodes[randomColor]));
        randomOption = random.nextInt(4);
        options[randomOption] = true;


        for (int i = 0; i < 4; i++) {
            randViews[i].setText((i + 1) + ". " + colorNames[random.nextInt(177)]);
            if (options[i]) {
                randViews[i].setText((i + 1) + ". " + colorNames[randomColor]);
            }
        }

        Log.i("colors", "random color: " + randomColor + "--- name: " + colorNames[randomColor]);

    }

    public void Option1(View view) {

        if (start) {
            if (options[0]) {
                playRightAnswer();
                score += 5;
            } else {
                view.setBackgroundResource(R.drawable.wrong_answer);
                playWrongAnswer();
            }
            randViews[randomOption].setBackgroundResource(R.drawable.correct_answer);
            start = false;
        }

        showResultDialog();

    }

    private void showResultDialog() {

        if (count >= 20) {
            ResultDialog.score = this.score;
            ResultDialog dialog = new ResultDialog();
            dialog.setCancelable(false);
            dialog.show(getSupportFragmentManager(), "Result dialog for score");
        }
    }

    public void Option2(View view) {
        if (start) {
            if (options[1]) {
                playRightAnswer();
                score += 5;
            } else {
                view.setBackgroundResource(R.drawable.wrong_answer);
                playWrongAnswer();
            }
            randViews[randomOption].setBackgroundResource(R.drawable.correct_answer);
            start = false;
        }
        showResultDialog();


    }

    public void Option3(View view) {
        if (start) {
            if (options[2]) {
                playRightAnswer();
                score += 5;
            } else {
                view.setBackgroundResource(R.drawable.wrong_answer);
                playWrongAnswer();
            }
            randViews[randomOption].setBackgroundResource(R.drawable.correct_answer);
            start = false;
        }
        showResultDialog();

    }

    public void Option4(View view) {
        if (start) {
            if (options[3]) {
                playRightAnswer();
                score += 5;
            } else {
                view.setBackgroundResource(R.drawable.wrong_answer);
                playWrongAnswer();
            }
            randViews[randomOption].setBackgroundResource(R.drawable.correct_answer);
            start = false;
        }
        showResultDialog();

    }


    public void NextBtn(View view) {

        if (count < 20) {
            playClick();
            startPlay();
            count++;
        }else{
            showResultDialog();
        }
    }

    private void stopSound() {
        if (player != null) {
            try {
                player.stop();
//                player.release();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
    }


    private void playRightAnswer() {
        stopSound();
        player = MediaPlayer.create(MainActivity.this, R.raw.right_answer);
        startM();
    }

    private void playClick() {
        stopSound();
        player = MediaPlayer.create(MainActivity.this, R.raw.click);
        startM();
    }

    private void playWrongAnswer() {
        stopSound();
        player = MediaPlayer.create(MainActivity.this, R.raw.wrong_answer);
        startM();
    }

    private void startM() {
        if (sounds) {
            try {
                player.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // go to about activity

        switch (item.getItemId()) {
            case R.id.about_:
                // go to about activity
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
                break;
            case R.id.sounds_:
                sounds = !sounds;
                if (sounds) {
                    item.setTitle("Sounds off");
                } else {
                    item.setTitle("Sounds on");
                }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void restart() {
        count = 0;
        playClick();
        startPlay();
    }
}