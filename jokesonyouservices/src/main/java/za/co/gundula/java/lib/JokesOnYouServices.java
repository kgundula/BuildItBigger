package za.co.gundula.java.lib;

import java.security.SecureRandom;

public class JokesOnYouServices {

     /*
     Some Good Old Jokes about life found on rd's site
     http://www.rd.com/jokes/daily-life/
     */

    int jokes_count = 0;

    final static String[] JOKES_ON_YOU = new String[]{
            "If you understand English, press 1. If you do not understand English, press 2.",
            "I bought one of those tapes to teach you Spanish in your sleep. During the night, the tape skipped. Now I can only stutter in Spanish.",
            "Probably the worst thing you can hear when you’re wearing a bikini is “Good for you!”",
            "If growing up in the ’80s taught me one thing, it’s that my friends and I should have found a treasure map by now.",
            "Watch The Walking Dead with someone who’s super into it so every time a zombie appears, you can pull the old, “Wait, who’s this, now?”",
            "Every Scooby-Doo episode would literally be two minutes long if the gang went to the mask store first and asked a few questions.",
            "One of my friends is pregnant. And I’m really excited. Not for the baby but because she’s one of my skinniest friends.",
            "It’s amazing how a person can compliment and insult you at the same time. Recently, when I greeted my coworker, she said, “You look so gorgeous, I didn’t recognize you.”",
            "Please stop calling us your “squad,” Linda; this is book club." ,
            "I once gave my husband the \u2028silent treatment for an entire week, at the end of which he declared, “Hey, we’re getting along pretty great lately!”",
            "I’m trying to get into classical \u2028music, but I can’t find any original recordings. All the music is performed by cover bands." ,
            "Instagram is just Twitter for people who go outside.",
            "There is nothing more awkward than the moment you realize you’re getting a double-cheek kiss.",
            "I’m writing my book in fifth person, so \u2028every sentence starts out with: “I heard from this guy who told somebody …”",
            "My greatest acting performance is when I check the caller ID, then adopt an air of polite curiosity as \u2028I answer the phone “Hello?”",
            "The closest I’ve been to a diet this year is erasing food searches from my browser history.",
            "My friends tell me that cooking is easy, but it’s not easier than not cooking.",
            "I put so much more effort into naming my first Wi-Fi than my \u2028first child.",
            "I lied and told my dad school \u2028was canceled. He said, ‘Let’s go see \u2028a movie.’ We got in the car, and he dropped me off at school.",
    };


    public String getJoke(){

        SecureRandom secureRandom = new SecureRandom();
        int index = secureRandom.nextInt(JOKES_ON_YOU.length);
        return JOKES_ON_YOU[index];
    }

    public static String[] getJokesOnYou(){
        return JOKES_ON_YOU;
    }
}
