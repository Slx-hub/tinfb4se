package de.codecrunch;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import de.codecrunch.model.tower.AllTowerTestSuite;
import de.codecrunch.model.unit.AllUnitsTestSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AllUnitsTestSuite.class,
        AllTowerTestSuite.class
})
public class AllTestsTestSuite {
}
