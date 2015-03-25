package com.vidtrialapplication.electionsystemapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.vidtrialapplication.electionsystemapp.loginconnect.Candidate;
import com.vidtrialapplication.electionsystemapp.loginconnect.GenericDBCalls;
import com.vidtrialapplication.electionsystemapp.loginconnect.Voter;

import java.util.ArrayList;
import java.util.List;


public class CandidateActivity extends ActionBarActivity {

    private CandidatePageCalls mCandidateVotingCalls;

    private long candidateId = -1l;
    private long voterId = -1l;

    private boolean voteFlag = false;
    private boolean dataPopulated = false;

    private Candidate currentCandidate;
    private Voter voter;

    private ListView listView;
    private Button voteButton;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidate);

        Intent currentIntent = getIntent();
        candidateId = currentIntent.getLongExtra("candidateId", 0l);
        voterId = currentIntent.getLongExtra("voterId", 0l);
        long currentlyVotingForCandidate = currentIntent.getLongExtra("currentlyVoting", 0l);
        voteButton = (Button) findViewById(R.id.voteButton);


        //Initial Cast Vote
        mCandidateVotingCalls = new CandidatePageCalls();
        mCandidateVotingCalls.execute();


        while(dataPopulated == false) {

        }

        listView = (ListView) findViewById(R.id.candidateListView);
        List<String> listViewArray = new ArrayList<String>();
        if (currentlyVotingForCandidate == currentCandidate.getId()) {
            listViewArray.add("You are currently voting for this candidate");
        }
        listViewArray.add("Candidate Id: " + currentCandidate.getId());
        listViewArray.add("Candidate Name: " + currentCandidate.getName());
        listViewArray.add("Candidate Description: " + currentCandidate.getDescription());
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listViewArray);
        listView.setAdapter(adapter);

        voteButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        voteFlag = true;
                        mCandidateVotingCalls = new CandidatePageCalls();
                        mCandidateVotingCalls.execute();

                        Intent voterInterfaceIntent = new Intent(CandidateActivity.this, VoterInterfaceActivity.class);
                        voterInterfaceIntent.putExtra("voter_id", voter.getId());
                        startActivity(voterInterfaceIntent);
                    }
                }
        );

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_candidate, menu);
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

    public class CandidatePageCalls extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... params) {

            try {
                while(candidateId == -1l || voterId == -1l) {

                }

                currentCandidate = GenericDBCalls.getCandidateById(candidateId);
                voter = GenericDBCalls.getVoterById(voterId);

                dataPopulated = true;

                if(voteFlag) {
                    GenericDBCalls.castVote(candidateId, voterId);
                }
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
