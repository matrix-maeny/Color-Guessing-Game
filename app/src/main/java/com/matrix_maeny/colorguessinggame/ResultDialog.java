package com.matrix_maeny.colorguessinggame;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.matrix_maeny.colorguessinggame.databinding.ResultDialogBinding;

public class ResultDialog extends AppCompatDialogFragment {

    private ResultDialogBinding binding;
    private ResultDialogListener listener;
    public static int score = 0;
    private MediaPlayer player = null;

    @SuppressLint("SetTextI18n")
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        ContextThemeWrapper wrapper = new ContextThemeWrapper(requireContext(), androidx.appcompat.R.style.Theme_AppCompat_Dialog_Alert);
        AlertDialog.Builder builder = new AlertDialog.Builder(wrapper);

        View root = requireActivity().getLayoutInflater().inflate(R.layout.result_dialog, null);
        builder.setView(root);
        binding = ResultDialogBinding.bind(root);

        try {
            listener = (ResultDialogListener) requireContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String scoreTxt = score + "/" + 100;

        binding.scoreTv.setText(scoreTxt);

        if (score < 100) {
            binding.resultTv.setText("!...Keep trying...!");
            playWin1();
        } else {
            binding.resultTv.setText("!...Congratulations...!");
            playWin2();
        }

        binding.playAgainBtn.setOnClickListener(v -> {
            listener.restart();
            dismiss();
        });


        return builder.create();
    }

    private void playWin1(){
        player = MediaPlayer.create(requireContext(),R.raw.win1);

        try {
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void playWin2(){
        player = MediaPlayer.create(requireContext(),R.raw.win2);

        try {
            player.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public interface ResultDialogListener {
        void restart();
    }
}
