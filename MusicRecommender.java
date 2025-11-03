import java.io.*;
import java.util.*;

public class MusicRecommender {
    private List<Song> songs = new ArrayList<>();
    private final String FILE_PATH = "songs.txt";

    public MusicRecommender() {
        loadSongs();
    }

    public void addSong(String title, String artist, String mood) {
        songs.add(new Song(title, artist, mood));
        saveSongs();
        System.out.println("✅ Song added successfully!");
    }

    public void recommendByMood(String mood) {
        System.out.println("\n🎧 Recommended Songs for Mood: " + mood);
        boolean found = false;
        for (Song s : songs) {
            if (s.getMood().equalsIgnoreCase(mood)) {
                System.out.println(s);
                found = true;
            }
        }
        if (!found) System.out.println("No songs found for this mood.");
    }

    public void viewAllSongs() {
        System.out.println("\n🎶 All Songs:");
        for (Song s : songs) System.out.println(s);
    }

    private void saveSongs() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Song s : songs) {
                bw.write(s.getTitle() + "," + s.getArtist() + "," + s.getMood());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving songs: " + e.getMessage());
        }
    }

    private void loadSongs() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    songs.add(new Song(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading songs: " + e.getMessage());
        }
    }
}
