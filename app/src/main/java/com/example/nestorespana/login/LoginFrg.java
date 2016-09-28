package com.example.nestorespana.login;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginFrg.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginFrg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFrg extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    Button button;
    EditText user,pass;
    SQLiteDatabase db;

    public LoginFrg() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFrg.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFrg newInstance(String param1, String param2) {
        LoginFrg fragment = new LoginFrg();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_frg,container,false);
        button=(Button)view.findViewById(R.id.button);
        user=(EditText)view.findViewById(R.id.editText);
        pass=(EditText) view.findViewById(R.id.editText2);
        db=getActivity().openOrCreateDatabase("LoginDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,password VARCHAR);");

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String name=user.getText().toString();
                final String code=pass.getText().toString();
                Cursor c=db.rawQuery("SELECT * FROM users WHERE password='"+pass.getText()+"'", null);

                if(name.equals("") || code.equals("")) {
                    Toast.makeText(getActivity(), "ingrese un usuario y una contraseña", Toast.LENGTH_SHORT).show();
                }
                else if(c.moveToFirst())
                {
                    Intent i = new Intent(getActivity(), Activity2.class);
                    i.putExtra("usuario",name);

                    startActivity(i);
                    getActivity().finish();
                }
                else
                {
                    Toast.makeText(getActivity(), "Error, Código invalido", Toast.LENGTH_SHORT).show();

                }


            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
