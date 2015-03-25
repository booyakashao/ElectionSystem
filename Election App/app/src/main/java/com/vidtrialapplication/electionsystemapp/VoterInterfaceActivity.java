package com.vidtrialapplication.electionsystemapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.vidtrialapplication.electionsystemapp.loginconnect.Candidate;
import com.vidtrialapplication.electionsystemapp.loginconnect.GenericDBCalls;
import com.vidtrialapplication.electionsystemapp.loginconnect.Voter;

import java.util.List;


public class VoterInterfaceActivity extends ActionBarActivity {

    private VotingCalls mVotingCalls;

    private TextView mUsernameTextView;
    private TextView mRoleTextView;
    private TextView mCurrentCandidate;

    private Boolean isVoting = false;
    private Voter voter;
    private Candidate currentVotedCandidate;
    private List<Candidate> allCandidates;
    private long voterId;

    private ScrollView mScrollView;
    private LinearLayout mScrollLinearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter_interface);
        voterId = getIntent().getLongExtra("voter_id", 0l);

        mUsernameTextView = (TextView) findViewById(R.id.textUsername);
        mRoleTextView = (TextView) findViewById(R.id.textRole);
        mCurrentCandidate = (TextView) findViewById(R.id.currentCandidate);

        //Views for Scrollview
        mScrollView = (ScrollView) findViewById(R.id.scrollView);
        mScrollLinearLayout = (LinearLayout) findViewById(R.id.scrollLinearLayout);

        //Initial Execution
        mVotingCalls = new VotingCalls();
        mVotingCalls.execute();

        while(voter == null ||
                currentVotedCandidate == null ||
                allCandidates == null ||
                allCandidates.isEmpty()) {

        }

        mUsernameTextView.append(voter.getUsername());
        switch(voter.getRoleName()) {
            case "ROLE_ADMIN":mRoleTextView.append("Administrator");break;
            case "ROLE_VOTER":mRoleTextView.append("Regular Voter");break;
            default:mRoleTextView.append("Unknown Role");break;
        }

         try {
            mCurrentCandidate.append(currentVotedCandidate.getName());
         } catch (NullPointerException e) {
            mCurrentCandidate.append("No one");
         }

        for(final Candidate currentCandidate : allCandidates) {
            Button candidateButton = new Button(this);
            candidateButton.setText(currentCandidate.getName());
            candidateButton.setId(View.generateViewId());
            candidateButton.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent candidateIntent = new Intent(VoterInterfaceActivity.this, CandidateActivity.class);
                            candidateIntent.putExtra("candidateId", currentCandidate.getId());
                            candidateIntent.putExtra("voterId", voter.getId());
                            try {
                                candidateIntent.putExtra("currentlyVoting", currentVotedCandidate.getId());
                            } catch (NullPointerException e) {
                                //Do nothing
                            }
                            startActivity(candidateIntent);
                        }
                    }
            );
            mScrollLinearLayout.addView(candidateButton);
        }


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
                allCandidates = GenericDBCalls.getAllCandidates();
                currentVotedCandidate = GenericDBCalls.getVoterCandidate(voterId);
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
