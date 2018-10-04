package br.com.tuliofmoura.androidbasics.resolved.hello;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import br.com.tuliofmoura.androidbasics.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ResolvedHelloFragment extends Fragment {

    private FragmentInteractionListener listener;
    private CheckBox checkBox;

    public ResolvedHelloFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.resolved_fragment_hello, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInteractionListener) {
            listener = (FragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement " + FragmentInteractionListener.class.getCanonicalName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    private void initViews(View rootView) {
        final String name = listener.getUserName();
        final TextView title = rootView.findViewById(R.id.hello_title);
        final String titleFormatted = getString(R.string.hello_activity_title, name);
        title.setText(titleFormatted);

        final Button button = rootView.findViewById(R.id.hello_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonClicked();
            }
        });
        checkBox = rootView.findViewById(R.id.hello_check);
    }

    private void onButtonClicked() {
        listener.onButtonClicked(checkBox.isChecked());
    }

    public interface FragmentInteractionListener {

        String getUserName();

        void onButtonClicked(boolean checked);
    }

}
