package com.csci491.cardsagainsthumanity;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import android.app.Activity;
import android.content.res.AssetManager;

/* ========================================================================
 * This is the file input and output class
 * It reads the card file in, as well as the user config file
 * ======================================================================== */

public class FileIO extends Activity {
	
	public ArrayList<Card> hardCodedWhiteCards() {
		ArrayList<Card> whiteCards = new ArrayList<Card>();
		String[] cards = { "Being on fire.", "Old-people smell.", "Women in yogurt commercials.", "Classist undertones.", "An oversized lollipop.", "An Oedipus complex.", "A tiny horse.", "Boogers.", "Barack Obama.", "My humps.", "The Tempur-Pedic Swedish Sleep System.", "Dry heaving.", "Skeletor.", "Darth Vader.", "Figgy pudding.", "Advice from a wise, old black man.", "Five-Dollar Footlongs.", "Elderly Japanese men.", "Free samples.", "Famine.", "Men.", "A bag of magic beans.", "Repression.", "Prancing.", "My relationship status.", "The World of Warcraft.", "Dick Cheney.", "Pabst Blue Ribbon.", "Emma Watson.", "My ex-wife.", "Another freaking vampire movie.", "Scrubbing under the folds.", "The Boy Scouts of America.", "Finger painting.", "The Care Bare Stare.", "Being marginalized.", "Dying of dysentery.", "Mr. Clean, right behind you.", "Hot Pockets.", "Natalie Portman.", "Agriculture.", "Judge Judy.", "Robert Downy, Jr.", "The Trail of Tears.", "An M. Night Shyamalan plot twist.", "Funky fresh rhymes.", "The light of a billion suns.", "Italians.", "Explosions.", "A good sniff.", "Destroying the evidence.", "Children on leashes.", "Catapults.", "One trillion dollars.", "Silence.", "YOU MUST CONSTRUCT ADDITIONAL PYLONS.", "Justin Bieber.", "The invisible hand.", "My inner demons.", "Crippling debt.", "Teaching a robot to love.", "Horse meat.", "All-you-can-eat shrimp for $4.99.", "Heteronormativity.", "Michael Jackson.", "A really cool hat.", "Shapeshifters.", "A disappointing birthday party.", "Dental dams.", "My soul.", "The chronic.", "Eugenics.", "Synergistic management solutions.", "RoboCop.", "Serfdom.", "Tangled Slinkys.", "Public ridicule.", "That thing that electrocutes your abs.", "Object permanence.", "GoGurt.", "Lockjaw.", "Attitude.", "The Dance of the Sugar Plum Fairy.", "Multiple stab wounds.", "Stranger danger.", "A monkey smoking a cigar.", "Smegma.", "A live studio audience.", "Making a pouty face.", "The violation of our most basic human rights.", "Unfathomable stupidity.", "Sunshine and rainbows.", "The token minority.", "The terrorists.", "The Three-Fifths compromise.", "The Great Depression.", "Emotions.", "An M16 assault rifle.", "David Bowie flying in on a tiger made of lightning.", "Flightless birds.", "Doing the right thing.", "Frolicking.", "Being a jerk to children.", "Poopy diapers.", "Tickling Sean Hannity, even after he tells you to stop.", "Raptor attacks.", "Swooping.", "A robust mongoloid.", "Mutually-assured destruction.", "Stalin.", "The true meaning of Christmas.", "Self-loathing.", "New Age music.", "A thermonuclear detonation.", "Geese.", "Kanye West.", "Becoming a blueberry.", "The American Dream.", "Sweet, sweet vengeance.", "Winking at old people.", "Oompa-Loompas.", "Authentic Mexican cuisine.", "The Little Engine That Could.", "Guys who don't call.", "Parting the Red Sea.", "Rush Limbaugh's soft, ugly body.", "A saxophone solo.", "Land mines.", "Capturing Newt Gingrich and forcing him to dance in a monkey suit.", "Me time.", "Nickelback.", "Vigilante justice.", "The South.", "Opposable thumbs.", "Ghosts.", "Exactly what you'd expect.", "A time travel paradox.", "AXE Body Spray.", "Actually taking candy from a baby.", "Leaving an awkward voicemail.", "A mopey zoo lion.", "A murder most foul.", "A falcon with a cap on its head.", "Friction.", "Fear itself.", "Yeast.", "Lunchables.", "Licking things to claim them as your own.", "Vikings.", "The Kool-Aid Man.", "Hot cheese.", "Nicolas Cage.", "The inevitable heat death of the universe.", "Republicans.", "William Shatner.", "Sperm whales.", "Lady Gaga.", "A mime having a stroke.", "White people.", "A lifetime of sadness.", "A sea of troubles.", "A cooler full of organs.", "Giving 110%.", "John Wilkes Booth.", "Obesity.", "Puppies!", "Brown people.", "Dropping a chandelier on your enemies and riding the rope up.", "Soup that is too hot.", "Hormone injections.", "The Big Bang.", "Switching to Geico.", "Wearing underwear inside-out to avoid doing laundry.", "Rehab.", "Christopher Walken.", "Count Chocula.", "The Hamburglar.", "Aaron Burr.", "Hot people.", "The miracle of childbirth.", "Adderall.", "The glass ceiling.", "The Hustle.", "Swag.", "Breaking out into song and dance.", "A Super Soaker full of cat pee.", "The Underground Railroad.", "Home video of Oprah sobbing into a Lean Cuisine.", "The Rev. Dr. Martin Luther King, Jr.", "Extremely tight pants.", "Hope.", "Smallpox blankets.", "Natural selection.", "A gassy antelope.", "Arnold Schwarzenegger.", "Pretending to care.", "Ronald Reagan.", "An ugly face.", "A death ray.", "BATMAN!!!", "Homeless people.", "Centaurs.", "Stormtroopers.", "Passing a kidney stone.", "An uppercut.", "Shaquille O'Neal's acting career.", "Horrifying laser hair removal accidents.", "Riding off into the sunset.", "Goblins.", "Eating the last known bison.", "Shiny objects.", "Being rich.", "A Bop It.", "Leprosy.", "World peace.", "The Make-A-Wish Foundation.", "Britney Spears at 55.", "Laying an egg.", "The folly of man.", "Grandma.", "Flesh-eating bacteria.", "Poor people.", "Active listening.", "Strong female characters.", "Poor life choices.", "Sniffing glue.", "Black people.", "A bucket of fish heads.", "Hospice care.", "Passive-aggressive Post-it notes.", "Fancy Feast.", "The heart of a child.", "Being fat and stupid.", "Getting married, having a few kids, buying some stuff, retiring to Florida, and dying.", "Sean Penn.", "Sean Connery.", "Genghis Khan.", "Historically black colleges.", "A subscription to Men's Fitness.", "The milk man.", "Friendly fire.", "Women's suffrage.", "Former President George W. Bush.", "The Force.", "Bees?", "A micropig wearing a tiny raincoat and booties.", "A hot mess.", "Tom Cruise.", "A balanced breakfast.", "Cuddling.", "Domino's Oreo Dessert Pizza.", "A zesty breakfast burrito.", "Morgan Freeman's voice.", "A middle-aged man on roller skates.", "Gandhi.", "The penny whistle solo from \"My Heart Will Go On.\"", "Spectacular abs.", "Keanu Reeves.", "Child beauty pageants.", "Bill Nye the Science Guy.", "Science.", "A tribe of warrior women.", "Her Majesty, Queen Elizabeth II.", "The entire Mormon Tabernacle Choir.", "Hulk Hogan.", "Take-backsies." };
		for (int i = 0; i < cards.length; i++) {
			whiteCards.add(new WhiteCard(cards[i]));
		}
		return whiteCards;
	}
	
	public ArrayList<Card> hardCodedBlackCards() {
		ArrayList<Card> blackCards = new ArrayList<Card>();
		String[] cards = { "Why can't I sleep at night?", "What's that smell?", "I got 99 problems but <blank> ain't one.", "Maybe she's born with it.  Maybe it's <blank>.", "What's the next Happy Meal toy?", "Here is the church\nHereis the steeple\nOpen the doors\nAnd there is\n<blank>.", "It's a pity that kids these days are all getting involved with <blank>.", "During his childhood, Salvador Dali produced hundreds of paintings of <blank>.", "Alternative medicine is now embracing the curative powers of <blank>.", "And the Academy Award for <blank> goes to <blank>.", "What's that sound?", "What ended my last relationship?", "MTV's new reality show features eight washed-up celebrities living with <blank>.", "I'm sorry Professor, but I couldn't complete my homework because of <blank>.", "What is Batman's guilty pleasure?", "This is the way the world ends\nThis is the way the world ends\nNot with a bang but <blank>.", "What's a girl's best friend?", "TSA guildelines now prohibit <blank> on airplanes.", "<blank>. That's how I want to die.", "For my text trick, I will pull <blank> out of <blank>.", "In the new Disney Channel Original Movie, Hannah Montana struggles with <blank> for the first time.", "<blank> is a slippery slope that leads to <blank>.", "What does Dick Cheney prefer?", "Dear Abby,\nI'm having some trouble with <blank> and would like your advice.", "Instead of coal, Santa now gives the bad children <blank>.", "What's the most emo?", "In 1,000 years, when paper money is a distant memory, how will we pay for goods and services?", "What's the next superhero / sidekick duo?", "In M. Night Shyamalan's new movie, Bruce Willis discovers that <blank> had really been <blank> all along.", "A romantic, candlelit dinner would be incomplete without <blank>.", "<blank>. Betcha can't have just one!", "Whte people like <blank>", "<blank>. High five, bro.", "Next from J.K. Rowling: Harry Potter and the Chamber of <blank>.", "BILLY MAYS HERE FOR <blank>.", "In a world ravaged by <blank>, our only solace is <blank>", "War!\nWhat is it good for?", "What are my parents hiding from me?", "In L.A. County Jail, word is you can trade 200 cigarettes for <blank>.", "What did I bring back from Mexico?", "What don't you want to find in your Kung Pao chicken?", "What will I bring back in time to convince people that I am a powerful wizard?", "How am i maintaining my relationship status?", "<blank>. It's a trap!", "Coming to Broadway this season, <blank>: The Musical.", "While the United States raced the Soviet Union to the moon, the Mexican government funneled millions of pesos into research on <blank>.", "After the earthquake, Sean Penn brought <blank> to the people of Haiti.", "Next on ESPN2, the World Series of <blank>.", "Step 1: <blank>.\nStep 2: <blank>.\nStep 3: Profit.", "Rumor has it that Vladimir Putin's favorite delicacy is <blank> stuffed with <blank>.", "But before I kill you, Mr. Bond, I must show you <blank>.", "What gives me uncontrollable gas?", "What do old people smell like?", "The class field trip was completely ruined by <blank>.", "When Pharaoh remained unmoved, Moses called down a Plague of <blank>.", "What's my secret power?", "What's there a ton of in heaven?", "What would grandma find disturbing, yet oddly charming?", "I never truly understood <blank> until I encountered <blank>.", "What did the U.S. airdrop to the children of Afghanistan?", "What helps Obama unwind?", "What did Vin Diesel eat for dinner?", "<blank>: good to the last drop.", "Why am I sticky?", "What gets better with age?", "<blank>: kid-tested, mother-approved.", "Daddy, why is mommy crying?", "What's Teach for America using to inspire inner city students to succeed?", "Studies show that lab rats navigate mazes 50% faster after being exposed to <blank>.", "Life for American Indians was forever changed when the White Man introduced them to <blank>.", "I do not know with what weapons World War III will be fought, but World War IV will be fought with <blank>.", "Why do I hurt all over?", "What am I giving up for Lent?", "In Michael Jackson's final moments, he thought about <blank>.", "The Smithsonian Museum of Natural History has just opened an interactive exhibit on <blank>.", "When I am President of the United States, I will create the Department of <blank>.", "Lifetime presents <blank>, the story of <blank>", "When I am a billionaire, I shall erect a 50-foot statue to commemorate <blank>.", "When I was tripping on acid, <blank> turned into <blank>.", "That's right, I killed <blank>. How, you ask? <blank>.", "What's my anti-drug?", "What never fails to liven up the party?", "What's the new fad diet?", "Major League Baseball has banned <blank> for giving players an unfair advantage.", };
		for (int i = 0; i < cards.length; i++) {
			blackCards.add(new BlackCard(cards[i]));
		}
		return blackCards;
	}
	
	public ArrayList<Card> createWhiteCards() throws Exception {
		ArrayList<Card> whiteCards = new ArrayList<Card>();
		InputStream is = getAssets().open("WHITE_CARDS.txt");
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		//BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("WHITE_CARDS.dat")));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			whiteCards.add(new WhiteCard(line));
		}
		
		br.close();
		
		/*
		try {
			
			InputStream is = getAssets().open("WHITE_CARDS.dat");
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			
			
			//Provided the file is NOT in the assets folder... (original theory)
			//BufferedReader BR = new BufferedReader(new FileReader(new File("WHITE_CARDS.dat")));
			
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("WHITE_CARDS.dat")));
		
			String line;
			
			while ((line = br.readLine()) != null) {
				whiteCards.add(new WhiteCard(line));
			}
			
			br.close();
			
		}
		catch (Exception e) {
			
		}
		*/
		return whiteCards;
	}
	
	public ArrayList<Card> createBlackCards() throws Exception {
		ArrayList<Card> blackCards = new ArrayList<Card>();
	
		try {
			//BufferedReader br = new BufferedReader(new FileReader(new File("BLACK_CARDS.dat")));
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(getAssets().open("BLACK_CARDS.txt")));
			String line;
			
			while ((line = br.readLine()) != null) {
				blackCards.add(new BlackCard(line));
			}
			
			br.close();
			
		}
		catch (Exception e) {
			
		}
		
		return blackCards;
	}
	
}
