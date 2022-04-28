package com.example.relaxapp.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.relaxapp.R;
import com.example.relaxapp.db.User;
import com.example.relaxapp.ui.MainActivity;

public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View profileFragmentView = inflater.inflate(R.layout.fragment_profile, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();
        User loggedUser = mainActivity.getLoggedUser();
        TextView usernameTextView = profileFragmentView.findViewById(R.id.user_username);
        usernameTextView.setText(loggedUser.getUsername());
        TextView emailTextView = profileFragmentView.findViewById(R.id.user_email);
        emailTextView.setText(loggedUser.getEmail());
        return profileFragmentView;
    }

}