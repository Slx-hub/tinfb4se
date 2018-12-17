package de.codecrunch;

import android.support.test.espresso.IdlingResource;

/**
 * How to use it?
 *
 * we try to test the visual interaction, after data has been loaded asynchronously from a data source.
 * here our data source is our program that needs to be loaded from the AndroidLauncher
 * trying to test without it gets us only failing tests because the test is performed before the app even started or before the right screen is opened
 * therefore we need to tell our tests when the app is busy loading.
 * in order to achieve this, we need to place a counter at the points where the loading takes place
 * this should then look somewhat like this:
 *
 * public void loadData() {
 *     // The network request might be handled in a different thread so make sure Espresso knows
 *     // that the app is busy until the response is handled.
 *     EspressoIdlingResource.increment(); // App is busy until further notice
 *
 *     // let's get the data
 *     mRepository.getData(new LoadDataCallback() {
 *         @Override
 *         public void onDataLoaded(Data data) {
 *             // now that the data has been loaded, we can mark the app as idle
 *             // first, make sure the app is still marked as busy then decrement, there might be cases
 *             // when other components finished their asynchronous tasks and marked the app as idle
 *             if (!EspressoIdlingResource.getIdlingResource().isIdleNow()) {
 *                 EspressoIdlingResource.decrement(); // Set app as idle.
 *             }
 *             processData(data);
 *         }
 *     });
 * }
 *
 *-------------------------------------------------------------------------------------------------
 *
 * Now, it is easy to expand this example to other scenarios.
 * As shown in both implementations, we simply add this line before an action (involved in a test)
 * where Espresso should wait:
 *
 * EspressoIdlingResource.increment(); // App is busy until further notice
 *
 *
 * At the completion of the action, notify Espresso that it can resume its tests:
 *
 * EspressoIdlingResource.decrement(); // Set app as idle.
 *
 * ------------------------------------------------------------------------------------------------
 *
 * In addition we need to set up the implementation of EspressoIdlingResource
 * in every test that targets components where Espresso has been notified.
 *
 * This can be done by simply adding these lines when preparing test fixtures:
 *
 * // Register your Idling Resource before any tests regarding this component
 * @Before
 *  public void registerIdlingResource() {
 *     IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());
 * }
 *
 * // Unregister your Idling Resource so it can be garbage collected and does not leak any memory
 * @After
 * public void unregisterIdlingResource() {
 *     IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource());
 * }
 *
 * ------------------------------------------------------------------------------------------------
 *
 * Now EspressoIdlingResource should handle all the synchronization and the tests should work
 *
 * Source:
 * https://android.jlelse.eu/integrate-espresso-idling-resources-in-your-app-to-build-flexible-ui-tests-c779e24f5057
**/// <- How to use it?

public class EspressoIdlingResource {

    private static final String RESOURCE = "GLOBAL";

    private static SimpleCountingIdlingResource mCountingIdlingResource = new SimpleCountingIdlingResource(RESOURCE);

    public static void increment(){
        mCountingIdlingResource.increment();
    }

    public static void decrement(){
        mCountingIdlingResource.decrement();
    }

    public static IdlingResource getIdlingResource(){
        return mCountingIdlingResource;
    }
}
