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
public class InvalidLengthException extends Exception
{

    private String lengthSent;

    //Creates a blank InvalidLengthException with no arguements.
    private InvalidLengthException()
    {

    }

    //Creates an InvalidLengthException that takes in the invalid String.
    public InvalidLengthException(String inString)
    {
        this.lengthSent = inString;
    }

    //Returns the inString of an InvalidLengthException.
    public String getLengthSet()
    {
        return this.lengthSent;
    }

    //Returns InvalidLengthException as a String.
    @Override
    public String toString() {
        String returnString;

        returnString = this.lengthSent + " is an invalid length!\n";

        return returnString;
    }
}
