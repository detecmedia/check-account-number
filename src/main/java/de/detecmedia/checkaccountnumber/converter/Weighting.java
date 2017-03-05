package de.detecmedia.checkaccountnumber.converter;

import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by potthast on 04.03.17.
 *
 * @author Markus Potthast
 * @version 0.1.0
 */
public class Weighting {
    /**
     * Weiting aClass.
     */
    private String weighting;

    private int[] weightingArray;

    private List<de.detecmedia.checkaccountnumber.model.Weighting> list;

    private static final Logger LOG = Logger.getLogger(Weighting.class);

    /**
     * getWeighting Instance.
     *
     * @return Weighting
     */
    public static Weighting Weighting(String weighting) {
        Weighting aClass = new Weighting();
        aClass.weighting = weighting;
        return aClass;
    }

    public static Weighting Weighting(int[] weighting) {
        Weighting aClass = new Weighting();
        aClass.weightingArray = weighting;
        return aClass;
    }

    private Weighting() {

    }

    public int[] getWeighting() {

        if (weightingArray != null) {
            return weightingArray;
        }

        String[] split = weighting.split(",");
        int[] w = new int[split.length];
        int index = 0;
        for (String value : split) {
            w[index++] = Integer.valueOf(value.trim());
        }
        return w;
    }

    /**
     * weighting {2, 3, 4, 5, 6}
     */
    public static final int[] W_2_3_4_5_6 = new int[]{2, 3, 4, 5, 6};

    /**
     * weighting {2, 3, 4, 5, 6,7}
     */
    public static final int[] W_2_3_4_5_6_7 = new int[]{2, 3, 4, 5, 6, 7};
    /**
     * weighting {3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1}.
     */
    public static final int[] W_3_7_1_3_7_1_3_7_1_3_7_1 = new int[]{3, 7, 1, 3, 7, 1, 3, 7, 1, 3, 7, 1};

    /**
     * weighting {2, 3, 4, 5, 6, 7, 8}.
     */
    public static final int[] W_2_3_4_5_6_7_8 = new int[]{2, 3, 4, 5, 6, 7, 8};
    /**
     * weighting {2, 3, 4, 5, 6, 7, 8, 9, 2}.
     */
    public static final int[] W_2_3_4_5_6_7_8_9_2 = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 2};
    /**
     * weighting {2, 1, 2, 1, 2, 1, 2, 1, 2, 1}.
     */
    public static final int[] W_2_1_2_1_2_1_2_1_2_1 = new int[]{2, 1, 2, 1, 2, 1, 2, 1, 2, 1};

    /**
     * weighting {2, 1, 2, 1, 2, 1, 2, 1, 2, 1}.
     */
    public static final int[] W_2_3_4_5_6_7_2_3_4 = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4};

    /**
     * weighting {7, 3, 1, 7, 3, 1, 7, 3, 1}.
     */
    public static final int[] W_7_3_1_7_3_1_7_3_1 = new int[]{7, 3, 1, 7, 3, 1, 7, 3, 1};
    /**
     * weighting {2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7}.
     */
    public static final int[] W_2_3_4_5_6_7_2_3_4_5_6_7 = new int[]{2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7};
}
