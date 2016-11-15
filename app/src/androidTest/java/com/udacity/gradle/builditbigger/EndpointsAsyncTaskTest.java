package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

/**
 * Created by kgundula on 2016/11/14.
 */

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    private final String LOG_TAG = EndpointsAsyncTaskTest.class.getSimpleName();
    String joke;

    final CountDownLatch latch = new CountDownLatch(1);

    @Before
    public void setUpTest() {
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask() {

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                latch.countDown();
            }
        };

        endpointsAsyncTask.execute();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        joke = endpointsAsyncTask.getJoke();
    }

    @Test
    public void testShouldPassTheseAsserts() {
        setUpTest();
        assert (joke != null);
        assertNotNull(joke);
    }

    /*
    @Test
    public void testShouldFailTheseAsserts(){
        setUpTest();
        assert(joke == null);
        assertEquals(joke, "The test failed");
    }
    */

    @Test
    public void testTest() {
        assertEquals("Test Passed", "Test Passed");
    }

}
