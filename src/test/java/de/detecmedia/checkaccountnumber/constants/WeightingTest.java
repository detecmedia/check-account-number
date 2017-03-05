package de.detecmedia.checkaccountnumber.constants;

import org.junit.Test;

import static de.detecmedia.checkaccountnumber.converter.Weighting.Weighting;

import static org.junit.Assert.*;

/**
 * checkaccountnumber
 * <p>
 * Created on 05.03.17.
 *
 * @author markus potthast markus.potthast@detecmedia.de
 * @version 1.0.0
 */
public class WeightingTest {
    @Test
    public void weightingA() throws Exception {
        int[] weighting = new int[]{1, 2, 1, 2, 1, 2, 12};
        int[] weightingResult = Weighting("1,2,1,2,1,2,12").getWeighting();
        assertArrayEquals(weighting, weightingResult);

        weighting = new int[]{1, 2, 1, 2, 1, 2, 11};
        weightingResult = Weighting("1,2,1,2,1,2,11").getWeighting();
        assertArrayEquals(weighting, weightingResult);
    }

    @Test
    public void weightingB() throws Exception {
        int[] weighting = new int[]{7, 2, 1, 2, 1, 2};
        int[] weightingResult = Weighting("7,2,1,2,1,2,").getWeighting();
        assertArrayEquals(weighting, weightingResult);
    }

}