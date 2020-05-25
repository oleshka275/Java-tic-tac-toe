package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	static ArrayList<Integer> allPlayerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> allComputerPositions = new ArrayList<Integer>();
	
	public static void gameAlgrithm(char[][] board, int playerPosition, String player) {
		
		char symbol = ' ';
		
		if(player.equals("player")) {
			symbol = 'X';
			allPlayerPositions.add(playerPosition);
		}else if(player.equals("computer")) {
			symbol = 'O';
			allComputerPositions.add(playerPosition);
		}

		switch(playerPosition) {
			case 1:
				board[0][0] = symbol;
				break;
			case 2:
				board[0][2] = symbol;
				break;
			case 3:
				board[0][4] = symbol;
				break;
			case 4:
				board[1][0] = symbol;
				break;
			case 5:
				board[1][2] = symbol;
				break;
			case 6:
				board[1][4] = symbol;
				break;
			case 7:
				board[2][0] = symbol;
				break;
			case 8:
				board[2][2] = symbol;
				break;
			case 9:
				board[2][4] = symbol;
				break;
			default: break;
		}
		
	}
	
	public static void printBoard(char [][] board) {
		
		for(char[] rows : board) {
			for(char i : rows) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		
		char [][] board = {{' ', '|',' ', '|', ' '},
							{' ', '|',' ', '|', ' '},
							{' ', '|',' ', '|', ' '}};
		printBoard(board);
		
		while(true) {
			
			Random rand = new Random();
			int computerPosition = rand.nextInt(9)+1;
			
			Scanner scaner = new Scanner(System.in);
			
			System.out.print("Choose your position: ");
			int playerPosition = scaner.nextInt();
			while(allPlayerPositions.contains(playerPosition) || allComputerPositions.contains(playerPosition) ) {
				System.out.println("Position taken!Try again: ");
				playerPosition = scaner.nextInt();
			}
			System.out.println("Your position >> " + playerPosition);
			
			gameAlgrithm(board, playerPosition, "player");
			
			while(allPlayerPositions.contains(computerPosition) || allComputerPositions.contains(computerPosition) ) {
				computerPosition = rand.nextInt(9)+1;
			}
			
			gameAlgrithm(board, computerPosition, "computer");
			
			printBoard(board);
			String result = checkWin();
			System.out.println(result);
		}
		
	}
	
	public static String checkWin() {
		
		List posWin1 = Arrays.asList(1,2,3);
		List posWin2 = Arrays.asList(4,5,6);
		List posWin3 = Arrays.asList(7,8,9);
		List posWin4 = Arrays.asList(1,5,9);
		List posWin5 = Arrays.asList(1,4,7);
		List posWin6 = Arrays.asList(2,5,8);
		List posWin7 = Arrays.asList(3,6,9);
		List posWin8 = Arrays.asList(7,5,3);
		
		List<List> winning = new ArrayList<List>();
		winning.add(posWin1);
		winning.add(posWin2);
		winning.add(posWin3);
		winning.add(posWin4);
		winning.add(posWin5);
		winning.add(posWin6);
		winning.add(posWin7);
		winning.add(posWin8);
		
		for(List l: winning) {
			if(allPlayerPositions.containsAll(l)) {
				return "Good job! You won!";
			}else if(allComputerPositions.containsAll(l)) {
				return "Computer win! You'll be lucky next time!";
			}else if(allPlayerPositions.size() + allComputerPositions.size() == 9) {
				return "Draw game!";
			}
		}
		
		return "";
	}
}
