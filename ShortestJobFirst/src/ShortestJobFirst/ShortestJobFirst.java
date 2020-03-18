/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ShortestJobFirst;

/**
 *
 * @author Venice Patalinghug
 */
import java.util.Scanner;
public class ShortestJobFirst 
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
              System.out.println ("SHORTEST JOB FIRST");
		System.out.println ("Enter number of process:");
		int process = input.nextInt();
		int processID[] = new int[process];
		int arrivalTime[] = new int[process]; 
		int burstTime[] = new int[process];
		int completeTime[] = new int[process];
		int turnAroundTime[] = new int[process];
		int waitingTime[] = new int[process];  
		int flag[] = new int[process];  
              int systemTime=0, totalProcess=0;
		double aveWaitTime=0, aveTurnAround=0;
 
		for(int count = 0 ; count<process ; count++)
		{
                    System.out.println ("Enter process number " + (count+1) + " arrival time:");
                    arrivalTime[count] = input.nextInt();
                    System.out.println ("Enter process number  " + (count+1) + " burst time:");
                    burstTime[count] = input.nextInt();
                    processID[count] = count+1;
                    flag[count] = 0;
		}

		while(true)
		{
                    int c = process, min=999;
                    if (totalProcess == process)
                            break;

                    for (int count=0; count<process; count++)
                    {
                        if ((arrivalTime[count] <= systemTime) && (flag[count] == 0) && (burstTime[count]<min))
                        {
                                min=burstTime[count];
                                c=count;
                        }
                    }

                    if (c == process) 
                    {
                        systemTime++;
                    }
                    else
                    {
                        completeTime[c]=systemTime+burstTime[c];
                        systemTime+=burstTime[c];
                        turnAroundTime[c]=completeTime[c]-arrivalTime[c];
                        waitingTime[c]=turnAroundTime[c]-burstTime[c];
                        flag[c]=1;
                        totalProcess++;
                    }
		}
		System.out.println("\nProcessID | ARRIVAL | BURST | COMPLETE | TURN | WAITING");
		for(int count=0; count<process ; count++)
		{
			aveWaitTime+= waitingTime[count];
			aveTurnAround+= turnAroundTime[count];
			System.out.println("\t"+processID[count]+"\t"+arrivalTime[count]+"\t"+burstTime[count]+"\t"+completeTime[count]+"\t"+turnAroundTime[count]+"\t"+waitingTime[count]);
		}
		System.out.println ("\nThe average turn around time is: "+ (double)(aveTurnAround/process));
		System.out.println ("The average waiting time is: "+ (double)(aveWaitTime/process));
	}
}
