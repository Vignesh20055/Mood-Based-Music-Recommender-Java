import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicRecommender recommender = new MusicRecommender();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MOOD-BASED MUSIC RECOMMENDER =====");
            System.out.println("1. Add Song");
            System.out.println("2. View All Songs");
            System.out.println("3. Get Recommendations by Mood");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> {
                    System.out.print("Enter song title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter artist: ");
                    String artist = sc.nextLine();
                    System.out.print("Enter mood (happy/sad/romantic/energetic): ");
                    String mood = sc.nextLine();
                    recommender.addSong(title, artist, mood);
                }
                case 2 -> recommender.viewAllSongs();
                case 3 -> {
                    System.out.print("Enter mood to recommend: ");
                    String mood = sc.nextLine();
                    recommender.recommendByMood(mood);
                }
                case 4 -> {
                    System.out.println("Thanks for using Mood Music Recommender 🎶");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice, try again!");
            }
        }
    }
}
