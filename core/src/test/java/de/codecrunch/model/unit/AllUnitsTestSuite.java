package de.codecrunch.model.unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({M_BigUnitTest.class,
        M_FastUnitTest.class,
        M_GiantUnitTest.class,
        M_HealUnitTest.class,
        M_MediumUnitTest.class,
        M_SmallUnitTest.class})
public class AllUnitsTestSuite {
}
