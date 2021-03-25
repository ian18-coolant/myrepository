/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;

/**
 *
 * @author Ian Mulyana
 */
class InvalidRatingException extends Exception {
    
    private int numberSent;

    //Creates a blank InvalidRatingException with no arguments.
    private InvalidRatingException()
    {

    }

    //Creates an InvalidRatingException with the invalid number.
    public InvalidRatingException(int inNumberSent)
    {
        this.numberSent = inNumberSent;
    }

    //Returns the numberSent of an InvalidRatingException.
    public int getNumberSent()
    {
        return this.numberSent;
    }

    //Returns InvalidRatingException as a String.
    @Override
    public String toString()
    {
        String returnString;

        returnString = this.numberSent + " is an invalid rating! Please choose a rating between 1 and 5.\n";

        return returnString;
    }
}
    

