import java.util.ArrayList;
import java.util.List;

public class Album {

    private String name;
//    private ArrayList<Song> songs;
    private SongList songs;

    public Album(String name) {
        this.name = name;
        this.songs = new SongList();
    }

    public boolean addSong(String title, double duration)
    {
        return this.songs.add(new Song(title, duration));
//
//        if(findSong(title) == null)
//        {
//            this.songs.add(new Song(title, duration));
//            System.out.println("Song added to " + this.name + " album : " + title);
//            return true;
//        }
//        System.out.println("Song (" + title + ") already exists !");
//        return false;
    }

//    private Song findSong(String title)
//    {
//        for(Song song : this.songs)
//        {
//            if(song.getTitle().equals(title))
//            {
//                return song;
//            }
//        }
//        return null;
//    }

    public boolean addToPlayList(int trackNumber, List<Song> playList)
    // We can use LinkedList instead of List in the above line.
    // But using List is better as it is an Interface, it can accept ArrayList, LinkedList etc.
    {
        Song s = this.songs.findSong(trackNumber);
        if(s != null)
        {
            playList.add(s);
            return true;
        }

//        if(trackNumber > 0)
//        {
//            int index = trackNumber - 1;
//            if(index <= this.songs.size()-1)
//            {
//                Song song = this.songs.get(index);
//                playList.add(song);
//                System.out.println("Song added to playlist: " + song.getTitle());
//                return true;
//            }
//        }

        System.out.println("Song not found !");
        return false;
    }

    public boolean addToPlayList(String title, List<Song> playList)
    {
        Song s = this.songs.findSong(title);

        if(s != null)
        {
            playList.add(s);
            return true;
        }

//        Song song = findSong(title);
//        if(song != null)
//        {
//            playList.add(song);
//            System.out.println("Song added to playlist: " + song.getTitle());
//            return true;
//        }
        System.out.println("Song not found !");
        return false;
    }

    private class SongList
    {
        private ArrayList<Song> songs;

        public SongList()
        {
            this.songs = new ArrayList<>();
        }

        public boolean add(Song song)
        {
            if(songs.contains(song))
            {
                return false;
            }
            this.songs.add(song);
            return true;
        }

        private Song findSong(String title)
        {
            for(Song song : this.songs)
            {
                if(song.getTitle().equals(title))
                {
                    return song;
                }
            }
            return null;
        }

        public Song findSong(int trackNumber)
        {
            int index = trackNumber - 1;
            if((index > 0) && index < this.songs.size())
            {
                return songs.get(index);
            }
            return null;
        }

    }
}