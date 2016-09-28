package com.example.nestorespana.login;

import android.content.Context;
import android.content.Intent;
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

import static android.database.sqlite.SQLiteDatabase.openOrCreateDatabase;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RegistroFrg.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RegistroFrg#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegistroFrg extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    Button button1;
    EditText user1,pass1,confpass;
    SQLiteDatabase db;



    public RegistroFrg() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegistroFrg.
     */
    // TODO: Rename and change types and number of parameters
    public static RegistroFrg newInstance(String param1, String param2) {
        RegistroFrg fragment = new RegistroFrg();
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
        View view = inflater.inflate(R.layout.fragment_registro_frg,container,false);

        button1=(Button)view.findViewById(R.id.button3);
        user1=(EditText)view.findViewById(R.id.editText3);
        pass1=(EditText) view.findViewById(R.id.editText4);
        confpass=(EditText) view.findViewById(R.id.editText5);

        db=getActivity().openOrCreateDatabase("LoginDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR,password VARCHAR);");

        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                final String name=user1.getText().toString();
                final String code=pass1.getText().toString();
                final String Confcode=confpass.getText().toString();


                if(name.equals("") || code.equals("")||Confcode.equals("")) {
                    Toast.makeText(getActivity(), "ingrese un usuario y una contraseña", Toast.LENGTH_SHORT).show();
                }
                else if(code.equals(Confcode) == false){
                    Toast.makeText(getActivity(), "contraseñas incorrectas", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.execSQL(
                            "INSERT INTO users VALUES('"+
                                    user1.getText()+"','"+
                                    pass1.getText()+"');"
                    );
                    Toast.makeText(getActivity(), "Exito Registro agregado", Toast.LENGTH_SHORT).show();



                    Intent i = new Intent(getActivity(), Activity2.class);
                    i.putExtra("usuario",name);
                    startActivity(i);
                    getActivity().finish();

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
