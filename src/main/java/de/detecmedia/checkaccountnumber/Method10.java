/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.detecmedia.checkaccountnumber;

/**
 * Kennzeichen 10.
 * <p>
 * Modulus 11, Gewichtung 2, 3, 4, 5, 6, 7, 8, 9, 10 (modifiziert) </p>
 * <p>
 * Die Berechnung erfolgt wie bei Verfahren 06. </p>
 * <p>
 * Testkontonummern: 12345008, 87654008</p>
 *
 * @author Markus Potthast mpt@detecmedia.de
 * @see Method06
 */
public class Method10 extends Method06 {

    private int[] weighting;
    @Override
    public boolean test() {
        this.weighting = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10};
        return check(weighting);
    }

}
