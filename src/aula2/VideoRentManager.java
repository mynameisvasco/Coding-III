package aula2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import aula1.Date;
import aula1.Person;

public class VideoRentManager 
{
	static Scanner userInput;
	
	public static void main(String args[])
	{
		userInput = new Scanner(System.in);
		new Database(5); //Creates database with video quota = 5
		int selection;
		
		do 
		{
			System.out.println("\n VIDEO MANAGER APPLICATION\n"
					+ "[1] Add video\n"
					+ "[2] Remove video\n"
					+ "[3] List videos\n"
					+ "[4] List videos by rating\n"
					+ "[5] Add user\n"
					+ "[6] Remove user\n"
					+ "[7] List users\n"
					+ "[8] Rent a Video \n"
					+ "[9] Back a Video\n"
					+ "[10] User Video History\n"
					+ "[11] Exit");
			
			selection = Integer.parseInt(userInput.nextLine());
			
			switch(selection)
			{
				case 1:
					addVideo();
					break;
				
				case 2:
					removeVideo();
					break;
				
				case 3:
					listVideos();
					break;
					
				case 4:
					listVideosByRating();
					break;
				
				case 5:
					addUser();
					break;
				
				case 6:
					removeUser();
					break;
					
				case 7: 
					listUsers();
					break;
				
				case 8:
					rentVideo();
					break;
				
				case 9:
					backVideo();
					break;
				
				case 10:
					userHistory();
					break;
			}
		}
		while(selection != 11);
	}
	
	public static void addVideo()
	{
		System.out.print("Video title: ");
		String title = userInput.nextLine();
		
		System.out.print("Video category: ");
		String category= userInput.nextLine();
		
		System.out.print("Video minimium age (ALL, M6, M12, M16, M18): ");
		String minimiumAge = userInput.nextLine();
		
		Worker.createVideo(new Video(title, category, minimiumAge));
	}
	
	public static void removeVideo()
	{
		System.out.println("Video ID: ");
		int id = Integer.parseInt(userInput.nextLine());
		Worker.deleteVideo(id);
	}
	
	public static void listVideos()
	{
		for(int i = 0; i < Database.videos.size(); i++)
		{
			System.out.println(Database.videos.get(i).toString());
		}
	}
	
	public static void listVideosByRating()
	{
		LinkedList<Video> videos = Database.videos;
		videos.sort(Comparator.comparing(Video::getRating));
		
		for(int i = videos.size() - 1; i >= 0; i--)
		{
			System.out.println(videos.get(i).toString());
		}
	}
	
	public static void addUser()
	{
		int selection;
		do
		{
			System.out.println("[1] Student");
			System.out.println("[2] Worker");
			selection = Integer.parseInt(userInput.nextLine());
		}
		while(selection != 1 && selection != 2);
		
		System.out.print("Name: ");
		String name = userInput.nextLine();
		
		System.out.print("CC: ");
		int cc= Integer.parseInt(userInput.nextLine());
		
		System.out.print("Dia de nascimento: ");
		int day = Integer.parseInt(userInput.nextLine());
		System.out.print("Mes de nascimento: ");
		int month = Integer.parseInt(userInput.nextLine());
		System.out.print("Ano de nascimento: ");
		int year = Integer.parseInt(userInput.nextLine());
				
		if(selection == 1)
		{
			System.out.print("Nmec: ");
			int nmec = Integer.parseInt(userInput.nextLine());
			
			System.out.print("Course: ");
			String course = userInput.nextLine();
			
			Worker.createStudent(new Student(name, cc, new Date(day, month, year), nmec, course));
		}
		else if(selection == 2)
		{
			System.out.print("Worker number: ");
			int workerNum = Integer.parseInt(userInput.nextLine());
			
			System.out.print("Fiscal number: ");
			int fiscalNum = Integer.parseInt(userInput.nextLine());
			
			Worker.createWorker(new Worker(name, cc, new Date(day, month, year), workerNum, fiscalNum));
		}
	}
	
	public static void removeUser()
	{
		int selection;
		do
		{
			System.out.println("[1] Student");
			System.out.println("[2] Worker");
			selection = Integer.parseInt(userInput.nextLine());
		}
		while(selection != 1 && selection != 2);
		
		if(selection == 1)
		{
			System.out.print("Nmec: ");
			int nmec = Integer.parseInt(userInput.nextLine());
			Worker.deleteStudent(nmec);
		}
		else if(selection == 2)
		{
			System.out.print("Worker Num: ");
			int workerNum = Integer.parseInt(userInput.nextLine());
			Worker.deleteWorker(workerNum);
		}
	}
	
	public static void listUsers()
	{
		int selection;
		do
		{
			System.out.println("[1] Student");
			System.out.println("[2] Worker");
			selection = Integer.parseInt(userInput.nextLine());
		}
		while(selection != 1 && selection != 2);
		
		if(selection == 1)
		{
			for(int i = 0; i < Database.students.size(); i++)
			{
				System.out.println(Database.students.get(i).toString());
			}
		}
		else if(selection == 2)
		{
			for(int i = 0; i < Database.workers.size(); i++)
			{
				System.out.println(Database.workers.get(i).toString());
			}
		}
	}
	
	public static void rentVideo()
	{
		System.out.print("Student Nmec: ");
		int selection = Integer.parseInt(userInput.nextLine());
		
		Student student = Database.searchStudent(selection);
		
		if(student == null)
		{
			System.out.println("User not found");
			return;
		}
		
		for(int i = 0; i < Database.videos.size(); i++)
		{
			System.out.println(Database.videos.get(i).toString());
		}
	
		System.out.print("Video ID: ");
		selection = Integer.parseInt(userInput.nextLine());
		
		student.rentVideo(selection);
	}

	public static void backVideo()
	{
		System.out.print("Student Nmec: ");
		int selection = Integer.parseInt(userInput.nextLine());
		
		Student student = Database.searchStudent(selection);
		
		if(student == null)
		{
			System.out.println("User not found");
			return;
		}
		
		for(int i = 0; i < student.getCurrentRentedVideos().size(); i++)
		{
			System.out.println(student.getCurrentRentedVideos().get(i).toString());
		}
	
		System.out.print("Video ID: ");
		selection = Integer.parseInt(userInput.nextLine());
		
		System.out.print("Video Rating: ");
		int rating = Integer.parseInt(userInput.nextLine());
		
		student.backVideo(selection, rating);
		
	}
	
	public static void userHistory()
	{
		System.out.print("Student Nmec: ");
		int selection = Integer.parseInt(userInput.nextLine());
		
		Student student = Database.searchStudent(selection);
		
		if(student == null)
		{
			System.out.println("User not found");
			return;
		}
		
		for(int i = 0; i < student.getHistory().size(); i++)
		{
			System.out.println(student.getHistory().get(i).toString());
		}
	}
}
