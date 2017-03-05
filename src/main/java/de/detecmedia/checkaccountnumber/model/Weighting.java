package de.detecmedia.checkaccountnumber.model;

/**
 * Weighting.
 * Created on 04.03.17.
 *
 * @author markus potthast markus.potthast@detecmedia.de
 * @version 1.0.0
 */
public class Weighting {
    /**
     * .
     * weighting name
     */
    private String name;
    /**
     * weighting.
     */
    private int[] weighting;

    /**
     * constructor.
     *
     * @param lName      name of weighting
     * @param lWeighting weighting
     */
    public Weighting(final String lName, final int[] lWeighting) {
        this.name = lName;
        this.weighting = lWeighting;
    }

    /**
     * get weighting name.
     *
     * @return String
     */
    public final String getName() {
        return name;
    }

    /**
     * get Weighting.
     *
     * @return int array
     */

    public final int[] getWeighting() {
        return weighting;
    }
}
