/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Ian Mulyana
 */
public class Playlist implements Serializable
{
    private ArrayList<Song> playlist;

    //Creates a Playlist object that contains an ArrayList for Songs.
    public Playlist()
    {
        playlist = new ArrayList<Song>();
    }

    //Adds a Song to a Playlist.
    public void addSong(Song song)
    {
        playlist.add(song);
    }

    //Returns the size of a Playlist.
    public int getPlaylistSize()
    {
        return playlist.size();
    }

    //Returns the artist of the Song at position (index) of a Playlist.
    public String getArtist(int index)
    {
        return playlist.get(index).getArtist();
    }

    //Returns the title of the Song at position (index) of a Playlist.
    public String getTitle(int index)
    {
        return playlist.get(index).getTitle();
    }

    //Returns the length of the Song at position (index) of a Playlist.
    public String getLength(int index)
    {
        return playlist.get(index).getLength();
    }

    //Returns the genre of the Song at position (index) of a Playlist.
    public String getGenre(int index)
    {
        return playlist.get(index).getGenre();
    }

    //Returns the rating of the Song at position (index) of a Playlist.
    public int getRating(int index)
    {
        return playlist.get(index).getRating();
    }

    //Sets the artist of the Song at position (index) to artist.
    public void updateArtist(int index, String artist)
    {
        playlist.get(--index).setArtist(artist);
    }

    //Sets the title of the Song at position (index) to the title.
    public void updateTitle(int index, String title)
    {
        playlist.get(--index).setTitle(title);
    }

    //Sets the length of the Song at position (index) to length; throws InvalidLengthException.
    public void updateLength(int index, String length) throws InvalidLengthException
    {
        if(length.matches("(\\d.*):(\\d.*)"))
        {
            playlist.get(--index).setLength(length);
        }
        else
        {
            throw new InvalidLengthException(length);
        }
    }

    //Sets the genre of the Song at position (index) to genre.
    public void updateGenre(int index, String genre)
    {
        playlist.get(--index).setGenre(genre);
    }

    //Sets the rating of the Song at position (index) to rating.
    public void updateRating(int index, int rating) throws InvalidRatingException
    {
        if(rating > 0 && rating < 6)
        {
            playlist.get(--index).setRating(rating);
        }
        else
        {
            throw new InvalidRatingException(rating);
        }
    }

    //Removes the song located at the specified index from the Playlist.
    public void removeSong(int index)
    {
        playlist.remove(index);
    }

    //Clears the Playlist of all Songs by invoking clear() on a Playlist.
    public void deletePlaylist()
    {
        if(playlist.size() == 0)
        {
            System.out.print("Playlist is empty!\n");
        }
        else
        {
            playlist.clear();
            System.out.print("Playlist has been deleted.\n");
        }
    }

} //End class