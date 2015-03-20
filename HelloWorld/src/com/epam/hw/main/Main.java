package com.epam.hw.main;

public class Main {
	private static final String AUTHOR = "author";

	public static void main(String[] args) {

		String author = "";
		author = System.getProperty(AUTHOR);

		if (!author.isEmpty()) {
			System.out.println("Hello word, it's " + author + "!");
		} else {
			System.out.println("Incorrect parameter value");
		}
	}
}
