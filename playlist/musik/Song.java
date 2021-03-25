/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;
import java.io.Serializable;

/**
 *
 * @author Ian Mulyana
 */
class Song implements Serializable
{
    private String artist;
    private String title;
    private String length;
    private String genre;
    private int rating;

    //Creates a playlist object with an artist, title, length, genre, and rating.
    public Song(String artist, String title, String length, String genre, int rating)
    {
        this.artist = artist;
        this.title = title;
        this.length = length;
        this.genre = genre;
        this.rating = rating;
    }

    //Sets Song's artist to argument artist.
    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    //Return the value of artist in a Song.
    public String getArtist()
    {
        return artist;
    }

    //Sets Song's title to argument title.
    public void setTitle(String title)
    {
        this.title = title;
    }

    //Returns the value of title in a Song.
    public String getTitle()
    {
        return this.title;
    }

    //Sets song's length to length argument; creates InvalidLengthException.
    /* This is not exactly how I wanted to do this, instead
     * this checks for validity by seeing if the argument String
     * contains both a colon and only numbers.*/
    public void setLength(String length) throws InvalidLengthException
    {
        if(length.matches("(\\d.*):(\\d.*)"))
        {
            this.length = length;
        }
        else
        {
            throw new InvalidLengthException(length);
        }
    }

    //Returns the value of length in a Song.
    public String getLength()
    {
        return this.length;

    }

    //Sets Song's genre to argument genre.
    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    //Returns value of genre in a Song.
    public String getGenre()
    {
        return this.genre;
    }

    //Sets Song's rating to argument rating; creates InvalidRatingException.
    public void setRating(int rating) throws InvalidRatingException
    {
        if(rating > 0 || rating < 6)
        {
            this.rating = rating;		}
        else
        {
            throw new InvalidRatingException(rating);
        }

    }

    //Returns rating value in a Song.
    public int getRating()
    {
        return this.rating;
    }


} //End class