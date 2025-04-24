
import java.io.*;
import java.util.*;
class Song{
    public Song next,prev;
    public String name,singer,lang;
    public Song(){
        next=prev=null;
    }
    public void Display(){
        System.out.println("Name of the song is "+name+"\nSinger is "+singer+"\nLanguage is "+lang+"\n");
    }
    public void get(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the song name:");
        name=sc.next();
        System.out.println("Enter the singer name:");
        singer=sc.next();
        System.out.println("Enter the song language:");
        lang=sc.next();
    }
}
class PlayList{
    public Song first,last;
    public PlayList(){
        first=last=null;
    }
    public void InsertLast(){
        Song nl=new Song();
        nl.get();
        if(first==null){
            first=last=nl;
        }
        else{
            last.next=nl;
            nl.prev=last;
            last=nl;
        }
    }
    public void DeleteFirst(){
        if(first==null){
            System.out.println("No songs added");
        }
        else if(first==last){
        	first=last=null;
        	System.out.println("Next song not added");}
        else{
            first=first.next;
            first.prev=null;
        }
    }
    public void InsertFirst(){
        Song nl=new Song();
        nl.get();
        if(first==null){
            first=last=nl;
        }
        else{
            first.prev=nl;
            nl.next=first;
            first=nl;
        }
    }
    public void InsertSec(){
    	Song nl=new Song();
    	nl.get();
    	if(first==null){
    		first=last=nl;}
    	else{
    		first.next.prev=nl;
    		first.next=nl;
    		nl.prev=first;}
    	}
    public int length(){
        Song curr=first;
        int count=0;
        while(curr!=null){
            count++;
            curr=curr.next;
        }
        return count;
    }
    public void detail(){
        if(first==null){
            System.out.println("Empty Playlist");
        }
        else
        first.Display();
    }
    public void all(){
    	if(first==null)
    	System.out.println("Empty Playlist");
    	else{
    	Song curr=first;
    	while(curr!=null){
    		System.out.println(curr.name);
    		curr=curr.next;}
    	}
    	}	
} 
class Project{
    public static void main(String st[]){
        System.out.println("**********Welcome to Song Player**********");
        int o=0;
        PlayList q=new PlayList();
        Scanner sc=new Scanner(System.in);
        while(o!=1){
            System.out.println("What would you like to do?");
            System.out.println("1.Add a song to play next.\n2.Add a song to queue.\n3.See the details of current song\n4.Which is the next song to be played?\n5.No of songs in the Playlist.\n6.Names of all songs in the queue\n7.Move on to next song?");
            int m;
            m=sc.nextInt();
            switch(m){
            	case 1:q.InsertSec();
            		System.out.println("Song has been inserterd");
            		break;
            	case 2:q.InsertLast();
            		System.out.println("Song has been inserterd");
            		break;
            	case 3:q.detail();
            		break;
            	case 4:if(q.first==null){
            		System.out.println("No next Song");
            		break;}
            		else{
            		q.first.next.Display();
            		break;}
            	case 5:int k=q.length();
            		System.out.println("No of songs = "+k);
            		break;
            	case 6:q.all();
            		System.out.println("All songs have been displayed");
            		break;
            	case 7:q.DeleteFirst();
            		System.out.println("Moved onto next song");
            		break;
            	default:System.out.println("Invalid Choice");
            		break;
            	}
            System.out.println("0.Yes\n1.No\nWould you like to continue?\n");
            o=sc.nextInt();
            }		
        }
    }