class PlaylistData {
    private String[] songs;
    private int songCount;

    PlaylistData(int size) {
        songs = new String[size];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    int getSongCount() {
        return songCount;
    }
}

public class Playlist {
    public static void main(String[] args) {
        PlaylistData p = new PlaylistData(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        copy[0] = "Hacked";

        String[] songs = p.getSongs();

        for (String song : songs) {
            System.out.println(song);
        }

        System.out.println("Song Count: " + p.getSongCount());
    }
}