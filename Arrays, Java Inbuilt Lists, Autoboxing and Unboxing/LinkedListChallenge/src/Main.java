import java.util.*;

public class Main {

    private static List<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

        Album album = new Album("Tamil songs");
        album.addSong("aca",5.00);
        album.addSong("dsf",4.50);
        album.addSong("dfg",4.50);
        album.addSong("hty",1.5);
        album.addSong("iuo",2.50);
        albums.add(album);

        album = new Album("English Songs");
        album.addSong("song1",5.12);
        album.addSong("song2",6.42);
        album.addSong("song3",3.42);
        album.addSong("song4",7);
        album.addSong("song5",5.5);
        albums.add(album);

        List<Song> playList = new LinkedList<>();
//        List<Song> playList = new ArrayList<>();
        albums.get(0).addToPlayList("aca",playList);
        albums.get(0).addToPlayList("aba",playList);
        albums.get(0).addToPlayList(2,playList);
        albums.get(0).addToPlayList(0,playList);

        albums.get(1).addToPlayList(2,playList);
        albums.get(1).addToPlayList(1,playList);
        albums.get(1).addToPlayList(5,playList);
        albums.get(1).addToPlayList(3,playList);

        play(playList);
    }

    public static void play(List<Song> playList)
    {
        Scanner s = new Scanner(System.in);
        ListIterator<Song> listIterator = playList.listIterator();
        boolean quit = false;
        boolean goingForward = true;
        if(playList.size() == 0)
        {
            System.out.println("No songs in playlist.");
        }
        else
        {
            System.out.println("Now playing : " + listIterator.next());
            printMenu();
        }

        while(!quit)
        {
            int action = s.nextInt();
            s.nextLine();

            switch (action)
            {
                case 0:
                    System.out.println("Playlist completed");
                    quit = true;
                    break;

                case 1:
                    if(!goingForward)
                    {
                        if (listIterator.hasNext())
                        {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if(listIterator.hasNext())
                    {
                        System.out.println("Now playing : " + listIterator.next());
                    }
                    else
                    {
                        System.out.println("Reached the end of playlist !");
//                        goingForward = false;
                    }
                    break;

                case 2:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if(listIterator.hasPrevious())
                    {
                        System.out.println("Now playing : " + listIterator.previous());
                    }
                    else
                    {
                        System.out.println("Reached the beginning of playlist !");
//                        goingForward = true;
                    }
                    break;

                case 3:
                    if(goingForward)
                    {
                        if(listIterator.hasPrevious())
                        {
                            System.out.println("Replaying : " + listIterator.previous());
                            goingForward = false; // Instead of this line, we can also use listIterator.next();
                        }
                        else
                        {
                            System.out.println("Reached the beginning of playlist !");
                        }
                    }
                    else
                    {
                        if(listIterator.hasNext())
                        {
                            System.out.println("Replaying : " + listIterator.next());
                            goingForward = true; // Instead of this line, we can also use listIterator.previous();
                        }
                        else
                        {
                            System.out.println("Reached the end of playlist !");
                        }
                    }
                    break;

                case 4:
                    printList(playList);
                    break;

                case 5:
                    printMenu();
                    break;

                case 6:
                    if(playList.size() > 0)
                    {
                        listIterator.remove();
                        if(listIterator.hasNext())
                        {
                            System.out.println("Now playing : " + listIterator.next());
                        }
                        else if(listIterator.hasPrevious())
                        {
                            System.out.println("Now playing : " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu()
    {
        System.out.println("Available options :");
        System.out.println
                (
                        "0 - Quit\n"+
                        "1 - Next\n"+
                        "2 - Previous\n"+
                        "3 - Replay\n"+
                        "4 - List of songs\n"+
                        "5 - Menu\n"+
                        "6 - Delete current song\n"
                );
    }

    private static void printList(List<Song> playList)
    {
        Iterator<Song> iterator = playList.iterator();
        int count = 0;
        System.out.println("*********************************");
        while(iterator.hasNext())
        {
            count++;
            System.out.println(count + ". " + iterator.next());
        }
        System.out.println("*********************************");
    }
}
