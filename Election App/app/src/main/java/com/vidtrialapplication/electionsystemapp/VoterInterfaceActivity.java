package com.vidtrialapplication.electionsystemapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.vidtrialapplication.electionsystemapp.loginconnect.GenericDBCalls;
import com.vidtrialapplication.electionsystemapp.loginconnect.Voter;


public class VoterInterfaceActivity extends ActionBarActivity {

    private VotingCalls mVotingCalls;

    private TextView mUsernameTextView;
    private TextView mRoleTextView;
    private Boolean isVoting = false;
    private Voter voter;
    private long voterId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter_interface);
        voterId = getIntent().getLongExtra("voter_id", 0l);

        mUsernameTextView = (TextView) findViewById(R.id.textUsername);
        mRoleTextView = (TextView) findViewById(R.id.textRole);

        //Initial Execution
        mVotingCalls = new VotingCalls();
        mVotingCalls.execute();

        while(voter == null) {

        }

        mUsernameTextView.append(voter.getUsername());
        mRoleTextView.append(voter.getRoleName());

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_voter_interface, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class VotingCalls extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                voter = GenericDBCalls.getVoterById(voterId);
            } catch(Exception e) {
                e.printStackTrace();
            }

            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {

        }

        @Override
        protected void onCancelled() {

        }
    }
}