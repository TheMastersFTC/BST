package cs2420;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This class represents a "dictionary" is a binary search tree
 * and then checks files against this dictionary to find
 * misspelled words.
 * 
 * It provides various constructors for creating the dictionary,
 * and the user is able to specify the file they wish to
 * spell check.
 *
 * @author Chloe Josien, Kylee Fluckiger, germain
 * @date 2/27/2017
 * 
 */
public class SpellChecker {
	

	/**
	 * This class stores the "dictionary" of approved words
	 * as a BinarySearchTree of Strings.
	 * 
	 */
    private BinarySearchTree<String> dictionary;

    
    /**
     * This default constructor simply creates a new
     * dictionary BST.
     * 
     */
    public SpellChecker() {
    	
        dictionary = new BinarySearchTree<String>();
        
    }

    /**
     * This overloaded constructor creates a dictionary out of
     * the parameter List of Strings.
     *
     * @param words
     *            - the List of Strings used to build the dictionary
     *            
     */
    public SpellChecker(List<String> words) {
    	
        this();
        buildDictionary(words);
        
    }

    /**
     * This overloaded constructor creates a new dictionary from
     * a File.
     *
     * @param dictionaryFile
     *            - the File that contains Strings used to build the dictionary
     *            
     */
    public SpellChecker(File dictionaryFile) {
    	
        this();
        buildDictionary(readFromFile(dictionaryFile));
        
    }

    /**
     * This function adds a single word to the dictionary.
     *
     * @param word
     *            - the String to be added to the dictionary
     *            
     */
    public void addToDictionary(String word) {
        
    	dictionary.add(word);
    	
    }

    /**
     * This function removes a word from the dictionary.
     *
     * @param word
     *            - the String to be removed from the dictionary
     *            
     */
    public void removeFromDictionary(String word) {
    
    	dictionary.remove(word);
    
    }

    /**
     * This function spell checks a document against the dictionary.
     *
     * @param documentFile
     *            - the File that contains Strings to be looked up in the
     *            dictionary
     * @return a List of misspelled words
     * 
     */
    public List<String> spellCheck(File documentFile) {

        List<String> wordsToCheck = readFromFile(documentFile);
        
        List<String> misspelledWords = new ArrayList<>();

        //Iterate through the words we need to check.
        for(String currentWord : wordsToCheck) {
        	        	
        	//If the word isn't in the dictionary, it is misspelled.
        	if(!dictionary.contains(currentWord)) {
        		
        		misspelledWords.add(currentWord);
        		
        	}
        	
        }

        return misspelledWords;
        
    }

    /**
     * This function fills in the dictionary with the input list of words.
     *
     * @param words
     *            - the List of Strings to be added to the dictionary
     *            
     */
    private void buildDictionary(List<String> words) {
        
    	dictionary.addAll(words);
    	
    }

    /**
     * This function returns a list of the words contained in the specified file. 
     * (Note that symbols, digits, and spaces are ignored.)
     *
     * @param file
     *            - the File to be read
     * @return a List of the Strings in the input file
     * 
     */
    private List<String> readFromFile(File file) {
    	
        ArrayList<String> words = new ArrayList<String>();

        try (Scanner fileInput = new Scanner(file)) {
			/*
			 * Java's Scanner class is a simple lexer for Strings and primitive
			 * types (see the Java API, if you are unfamiliar).
			 */

			/*
			 * The scanner can be directed how to delimit (or divide) the input.
			 * By default, it uses whitespace as the delimiter. The following
			 * statement specifies anything other than alphabetic characters as
			 * a delimiter (so that punctuation and such will be ignored). The
			 * string argument is a regular expression that specifies "anything
			 * but an alphabetic character". You need not understand any of this
			 * for the assignment.
			 */
            fileInput.useDelimiter("\\s*[^a-zA-Z]\\s*");

            while (fileInput.hasNext()) {
                String s = fileInput.next();
                if (!s.equals("")) {
                    words.add(s.toLowerCase());
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("File " + file + " cannot be found.");
        }

        System.out.println("Document is " + words);

        return words;
        
    }
    
}
