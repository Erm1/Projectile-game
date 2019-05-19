/*
Ermiyas Liyeh
30711570
Lab Section - MW 2:00PM to 3:15PM 
I did not collaborate with anyone on this project.
*/

import java.util.Scanner;    //I imported a Scanner
import java.util.Random;     //I imported a Random number generator

//This is my class named ProjectileGame
public class ProjectileGame {
	
	//Here I made a void method to printout different statements based on the value of the calculated height minus the randomly generated height
	public static void noticeStatements(int height, double calcHeight) {
		double hdiff = (calcHeight - height);    //I assigned a double variable called hdiff to calculate (calcHeight - height)
		
		//In my noticeStatements method, I used an if-elseif-else statements for various values of hdiff to printout different statements
		//In my println statements of each if-elseif-else statements I used Math.abs(hdiff) to specify how far the projectile has passed the wall
		//or at what point it hits the wall
		if (hdiff <= 5 && hdiff >= 0) {
			System.out.println("Your projectile is "+Math.abs(hdiff)+" high from the top of the wall. Brilliant, you are master of Projection!");
		}
		else if (hdiff > 5 && hdiff <= 15) {
			System.out.println("Your projectile is "+Math.abs(hdiff)+" high from the top of the wall. Such a great way to jump off the wall ;) Good Job");
		}
		else if (hdiff > 15) {
			System.out.println("Your projectile is "+Math.abs(hdiff)+" high from the top of the wall. You are far away from the wall!");
		}
		else if (hdiff < 0 && hdiff >= -5) {
			System.out.println("Your projectile hits the wall at "+Math.abs(hdiff)+" from the top of the wall. Unlucky, You were almost close to passing the wall, try again!");
		}
		else if (hdiff < -5 && hdiff >= -15) {
			System.out.println("Your projectile hits the wall at "+Math.abs(hdiff)+" from the top of the wall. hahahahahaha... I guess, it's getting so hard for you!!");
		}
		else {
			System.out.println("Your projectile hits the wall at "+Math.abs(hdiff)+" from the top of the wall. You should Quit! This game isn't for you! ... just kidding");
		}
	}

	
	//this is our main method
	public static void main(String [] args) {
		
		Scanner scnr = new Scanner(System.in);  //here, i created my scnr object using the class Scanner imported from the eclipse library
		Random rndm = new Random();    //here, i created my rndm object using the class Random imported from the eclipse library
		
			int userScore = 10;    //When the game starts, the player is given an initial score of 10      
			
			//This println statement tells welcomes the player and tells the player all the informations he/she needs to know
			//including how to quit the game and rules about losing the game
			System.out.println("Welcome to projectile Game, you have an initial score of 10.\nYou will lose the game if your score is less or equal to 0."
								+ "\nTo quit the game at any point, "
								+ "enter '0' " + "for both Projection Angle and Projection Speed");

do {	//do-while loop starts here
				
		int projAngle;    //user inputs of projAngle of type integers 
		int projSpeed;    //user inputs of projSpeed of type integers
		
			int height;     //randomly generated value for height of the wall of type integers
			height = rndm.nextInt(20)+30;  // generates a random height of the wall between the values of 20-50 unit-length
		
			int distance;     //randomly generated value for the distance from the height of the wall of type integers
			distance = rndm.nextInt(20)+30;     // generates a random distance from point of projection to the wall between the values of 20-50 unit-length
	
			//The println statement below displays the randomly generated height of wall and distance from the wall to the player
			//So that the player knows what values to put to get the maximum possible score
			System.out.println("\nheight of wall = "+height+"        "+"distance from wall = "+distance);
	
			//Asks the player to input a projection Angle
			System.out.print("Enter Projection Angle: ");	
			projAngle = scnr.nextInt();       //Accepts a value for the projection Angle 
	
			//Asks the player to input a projection Speed
			System.out.print("Enter Projection Speed: ");	
			projSpeed = scnr.nextInt();     //Accepts a value for the projection Speed
		
			if (projAngle == 0 && projSpeed == 0) {  //this conditional will quit the game if a player inputs 0 for both projection angle and speed
			break;
			}
		
			final double g = 9.8;
			/*The parametric equations for a projectile's position excluding air resistance is
			x = v*t*cos(theta)
			y = v*t*sin(theta)-(g/2)*Math.pow(t,2)
			*/
			
			//calculates the height based on inputed information from the user and the randomly generated distance 
			double calcHeight = (distance*Math.tan(projAngle))-((g*distance*distance)/(2*(Math.pow(projSpeed*Math.cos(projAngle), 2))));

			
			//In the following if-elseif-else nested conditionals different calculations are done based on different values
			//of Calculated Height. 
			if (calcHeight<0){
	
				calcHeight = 0; // a negative height is an imagnary height so the code evaluates it to 0 at the given random distance
				System.out.println("calcHeight = "+ 0 +"     Your projectile hits the wall "+Math.abs(calcHeight-height)+" from the top.");
				userScore = userScore - 3;
				System.out.println("User Score = "+userScore);
							noticeStatements(height, calcHeight);      //Called the noticeStatements method
			}

			else {

				System.out.println("calcHeight = "+calcHeight);

				if (calcHeight > height) {
					
					if ((calcHeight - height) <= 10 && (calcHeight - height) >= 0) {
						userScore = userScore + 4;
					}
					else if ((calcHeight - height) > 10) {
						userScore = userScore + 2;
						
					}
					
					System.out.println("User Score = "+userScore);
							noticeStatements(height, calcHeight);      //Called the noticeStatements method
				}

				else {

					if ((calcHeight - height) < 0 && (calcHeight - height) >= -10) {
						userScore = userScore - 1;
					}
					else if ((calcHeight - height) < -10) {
						userScore = userScore - 3;
						
					}
					
					System.out.println("User Score = "+userScore);
							noticeStatements(height, calcHeight);      //Called the noticeStatements method
				}
			}
			
}while(userScore!=0);   //The while loop continues looping until the user score becomes 0.
	
	}
}
