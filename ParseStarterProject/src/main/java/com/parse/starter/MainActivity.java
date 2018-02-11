/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseAnalytics;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.ParseQuery;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseAnalytics.trackAppOpenedInBackground(getIntent());
        ParseInstallation.getCurrentInstallation.saveInBackground();
        ParsePush.subscribeInBackground("TechNews");

        ParsePush parsePush = new ParsePush();
        parsePush.setChannel("TechNews");
        parsePush.setMessage("There are some awesome news here.");
        parsePush.setInBackground();

        ParseInstallation parseInstallation = ParseInstallation.getCurrentInstallation();
        parseInstallation.set("username", "Rob");
        parseInstallation.saveInBackground();

        ParseQuery parseQuery = ParseInstallation.getQuery();
        parseQuery.whereEqualTo("username", "Rob");

        PrasePush newPush = new ParsePush();
        newPush.setQuery(parseQuery);
        newPush.setMessage("Hey Rob");
        newPush.sendInBackground();


//
//      ParseInstallation.getCurrentInstallation().saveInBackground();
//      ParsePush.subscribeInBackground("TechNews");
//
//      ParsePush push = new ParsePush();
//      push.setChannel("TechNews");
//      push.setMessage("There's some great new tech news!!");
//      push.sendInBackground();
//
//      ParseInstallation installation = ParseInstallation.getCurrentInstallation();
//        installation.put("username", "rob");
//      installation.saveInBackground();
//
//      ParseQuery pushQuery = ParseInstallation.getQuery();
//      pushQuery.whereEqualTo("username", "rob");
//
//      ParsePush newPush = new ParsePush();
//      newPush.setQuery(pushQuery);
//        newPush.setMessage("Hi Rob!");
//      newPush.sendInBackground();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
