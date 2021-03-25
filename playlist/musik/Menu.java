/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack.playlist.musik;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Ian Mulyana
 */
public class Menu {
    private Scanner scan = new Scanner(System.in);
    private Playlist playlist = new Playlist();

    //Display a menu, prompts for user input (int selection), and returns the input.
    public int showMenu()
    {
        int selection;

        System.out.print("\nApa yang Akan Kamu Lakukan?"
                + "\n1- Tampilkan Data Playlist"+ "\n2- Tambah Data Playlist"
                + "\n3- Hapus Data Playlist" + "\n4- Tambah Data Playlist dalam urutan tertentu" + "\n5- Hapus Data Playlist dalam urutan tertentu"
                + " \n6- Hapus Semua Playlist" + " \n7- Exit" + "\nSelection: ");
        selection = scan.nextInt();
        System.out.print("\n");

        return selection;
    }

    //Displays menu from showMenu(): Contains a switch,
    //executes case based on returned int from showMenu().
    public void runMenu() throws IOException
    {

        int selection = showMenu();

        switch (selection) {
            case 1:
                viewPlaylist();
                runMenu();
                break;
            case 2:
                addSong();
                savePlaylist();
                runMenu();
                break;
            case 3:
                removeSong();
                savePlaylist();
                runMenu();
                break;
            case 4:
                updateSong();
                savePlaylist();
                runMenu();
                break;
            case 5:
                removeSong();
                savePlaylist();
                runMenu();
                break;
            case 6:
                playlist.deletePlaylist();
                runMenu();
                break;
            case 7:
                savePlaylist();
                System.exit(0);
                break;
            default:
                System.out.println("\nThat is not a valid selection!\n");
                runMenu();
        }

    }

    //Creates a new Song with user to input for artist, title,
    //length, genre, rating; adds Song to a Playlist.
    /* I had a lot of trouble getting the scanner get the input and assign it correctly.
     * Someone suggested I utilize scanner.reset(), but I'd get a scanner exception. This way worked.*/
    public void addSong()
    {
        Song newSong = new Song(null, null, null, null, 0);

        newSong.setArtist(scan.nextLine());
        System.out.print("Enter artist: ");
        newSong.setArtist(scan.nextLine());
        System.out.print("Enter title: ");
        newSong.setTitle(scan.nextLine());
        do
        {
            try
            {
                System.out.print("Enter length: ");
                newSong.setLength(scan.next());
            }
            catch (InvalidLengthException invalidLength)
            {
                System.out.print(invalidLength.toString());
                System.out.print("Enter length as \"minutes:seconds\".\n");
            }
        }while (newSong.getLength() == null);

        newSong.setGenre(scan.nextLine());
        System.out.print("Enter genre: ");
        newSong.setGenre(scan.nextLine());
        boolean flag = false;
        do
        {
            try
            {
                System.out.print("Enter rating: ");
                newSong.setRating(scan.nextInt());
                flag = true;
            }
            catch (InvalidRatingException invalidRating)
            {
                System.out.print(invalidRating.toString());
            }
        } while(flag == false);

        playlist.addSong(newSong);
    }

    //Formats and displays all Songs in Playlist.
    public void viewPlaylist()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylist empty!");
        }
        else
        {
            for(int i = 0; i < playlist.getPlaylistSize(); i++)
            {
                System.out.print("\n#" + (i+1) + " ");
                System.out.print(""+ playlist.getArtist(i) + " - ");
                System.out.print("\"" +playlist.getTitle(i)+ "\"" + ", ");
                System.out.print(playlist.getLength(i) + ", ");
                System.out.print(playlist.getGenre(i) + ", ");
                System.out.print(playlist.getRating(i)+ " out of 5");
            }
            System.out.print("\n");
        }
    }

    //Displays Playlist; prompts user to select song,
    //asks which variable of song they would like to update,
    //asks for input for that variable to update.
    public void updateSong() throws IOException
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylist empty!");
        }
        else
        {
            viewPlaylist();
            System.out.print("\nPlease select a song to update: ");
            int songSelection = scan.nextInt();

            System.out.print("\nWhat would you like to update?\n"+"1- Artist\n"+"2- Title\n"
                    +"3- Length\n"+"4- Genre\n"+"5- Rating\n"+"Selection: ");

            int updateSelection = scan.nextInt();

            switch (updateSelection) {
                case 1:
                    System.out.print("Enter artist: ");
                    String artist = scan.next();
                    playlist.updateArtist(songSelection, artist);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = scan.next();
                    playlist.updateTitle(songSelection, title);
                    break;
                case 3:
                    boolean lengthFlag = false;
                    do
                    {
                        try
                        {
                            System.out.print("Enter Length: ");
                            String length = scan.next();
                            playlist.updateLength(songSelection, length);
                            lengthFlag = true;
                        }
                        catch (InvalidLengthException invalidLength)
                        {
                            System.out.print(invalidLength.toString());
                            System.out.print("Enter length as \"minutes:seconds\".\n");
                        }
                    }while (lengthFlag == false);
                    break;
                case 4:
                    System.out.print("Enter genre: ");
                    String genre = scan.next();
                    playlist.updateGenre(songSelection, genre);
                    break;
                case 5:
                    boolean ratingFlag = false;
                    do
                    {
                        try
                        {
                            System.out.print("Enter rating: ");
                            int rating = scan.nextInt();
                            playlist.updateRating(songSelection, rating);
                            ratingFlag = true;
                        }
                        catch (InvalidRatingException invalidLength)
                        {
                            System.out.print(invalidLength.toString());
                        }
                    }while (ratingFlag == false);
                    break;
                default:
                    System.out.println("\nThat is not a valid selection!\n");
                    runMenu();
            }
        }
    }

    //Displays Playlist; prompts user to select Song to delete and removes it from Playlist.
    public void removeSong()
    {
        if(playlist.getPlaylistSize() == 0)
        {
            System.out.println("\nPlaylist is empty!");
        }
        else
        {
            viewPlaylist();
            boolean flag = false;
            do
            {
                System.out.print("\nSelect a song to remove: ");
                int removeSelection = scan.nextInt();

                if(removeSelection < playlist.getPlaylistSize() || removeSelection > playlist.getPlaylistSize())
                {
                    System.out.print("That is not a valid selection!\n");
                }
                else
                {
                    playlist.removeSong(--removeSelection);
                    flag = true;
                }
            } while(flag == false);
        }
    }

    //Write the contents of Playlist to a file called playlist.
    public void savePlaylist() throws IOException
    {
        try
        {
            FileOutputStream fileOutputStream = new FileOutputStream("playlist");

            ObjectOutputStream outObjectStream = new ObjectOutputStream(fileOutputStream);

            outObjectStream.writeObject(playlist);

            outObjectStream.flush();
            outObjectStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("No file");
        }
        catch(IOException ioException)
        {
            System.out.println("bad IO");
        }

    }

    //Reads the file contents containing to a Playlist.
    public void loadPlaylist()
    {
        try
        {
            FileInputStream fileInputStream = new FileInputStream("playlist");

            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            playlist = (Playlist)objectInputStream.readObject();

            objectInputStream.close();
        }
        catch(FileNotFoundException fnfException)
        {
            System.out.println("No File");
        }
        catch(IOException ioException)
        {
            System.out.println("IO no good");
        }

        catch(ClassNotFoundException cnfException)
        {
            System.out.println("This is not a Playlist.");
        }

    }


}//End class
    

