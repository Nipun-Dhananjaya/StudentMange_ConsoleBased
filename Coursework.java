import java.util.*;
class Coursework{
	public static String[] id=new String[0];
	public static String[] name=new String[0];
	public static int[] prf=new int[0];
	public static int[] dbm=new int[0];
	public static double[] avg=new double[0];
	public static void HomePage(){
		System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
		System.out.printf("%s%75s%40s%s\n","|","WELCOME TO STUDENT DETAILS MANAGEMENT SYSTEM"," ","|");
		System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
		System.out.println();
		System.out.printf("%s\n","**  Main Menu  **");
		System.out.println("=================");
		System.out.println();
		System.out.printf("%-75s%s","[1]  Add New Students ","[2]  Add New Students With Marks \n");
		System.out.printf("%-75s%s","[3]  Add Marks ","[4]  Update Student Details \n");
		System.out.printf("%-75s%s","[5]  Update Marks ","[6]  Delete Student \n");
		System.out.printf("%-75s%s","[7]  Print Student Details ","[8]  Print Student Ranks \n");
		System.out.printf("%-75s%s","[9]  Best In Programming Fundamentals ","[10] Best In DataBase Management \n");
		System.out.println();
		System.out.println();
	}
	public final static void ClearConsol(){
		try{
			final String os=System.getProperty("os.name");
			if(os.contains("Windows")){
				new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
			}else{
				System.out.print("\033[H\033[2J");
				System.out.flush();
			}
		}catch(final Exception e){
			e.printStackTrace();
			//Handle any exceptions.
		}
	}
	public static int searchId(String[] id,String x){
		int j=-1;
		for (int i = 0; i < id.length; i++)
		{
			if (id[i].equals(x))
			{
				j=i;
				return j;
			}
		}
		return j;
	}
	public static boolean searchmark(int[]mark,int j){
		if (mark[j]>=0)
			{
				return true;
			}
		return false;
	}
	public static void extendArrayId(String a){
		String[] ar=new String[id.length+1];
		for (int i = 0; i < id.length; i++)
		{
			ar[i]=id[i];
		}
		ar[ar.length-1]=a;
		id=ar;
	}
	public static void extendArrayName(String a){
		String[] br=new String[name.length+1];
		for (int i = 0; i < name.length; i++)
		{
			br[i]=name[i];
		}
		br[br.length-1]=a;
		name=br;
	}
	public static void extendArrayPrf(int a){
		int[] ar=new int[prf.length+1];
		
		for (int i = 0; i < prf.length; i++)
		{
			ar[i]=prf[i];
		}
		ar[ar.length-1]=a;
		prf=ar;
	}
	public static void extendArrayDbm(int a){
		int[] ar=new int[dbm.length+1];
		for (int i = 0; i < dbm.length; i++)
		{
			ar[i]=dbm[i];
		}
		ar[ar.length-1]=a;
		dbm=ar;
	}
	public static void extendArrayAvg(double a){
		double[] ar=new double[avg.length+1];
		for (int i = 0; i < avg.length; i++)
		{
			ar[i]=avg[i];
		}
		ar[ar.length-1]=a;
		avg=ar;
	}
	public static void AddStudent(String a){
		Scanner input=new Scanner(System.in);
		extendArrayId(a);
		System.out.print("Enter student Name: ");
		String b=input.next();
		extendArrayName(b);
		extendArrayPrf(-1);
		extendArrayDbm(-1);
		extendArrayAvg(-1.0);
	}
	public static void AddStudentMarksPrf(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student's PRF marks: ");
		int a=input.nextInt();
		if(a<=100&& a>=0){
			
			extendArrayPrf(a);
		}
		else{
			System.out.println("Wrong PRF marks.Please Enter Correct Marks");
			AddStudentMarksPrf();
		}
	}
	public static void AddStudentMarksDbm(){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student's DBMS marks: ");
		int b=input.nextInt();
		if(b<=100&& b>=0){
			extendArrayDbm(b);
		}
		else{
			System.out.println("Wrong DBMS marks.Please Enter Correct Marks");
			AddStudentMarksDbm();
		}
	}
	public static void AddStudentWithMarks(String a){
		Scanner input=new Scanner(System.in);
		extendArrayId(a);
		System.out.print("Enter student Name: ");
		String b=input.next();
		extendArrayName(b);
		AddStudentMarksPrf();
		AddStudentMarksDbm();
		extendArrayAvg(-1.0);
	}
	public static void AddMarks(int j){
		Scanner input=new Scanner(System.in);
		if((searchmark(prf,j))){
			System.out.println("Student marks already exist.If you want to update, Select [5] in the main menu..");
		}
		else{
			AddStudentMarksPrf(j);
			AddStudentMarksDbm(j);
			System.out.print("Marks Added Succesfully! ");
		}
	}
	public static void AddStudentMarksPrf(int j){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student's PRF marks: ");
		int a=input.nextInt();
		if(a<=100&& a>=0){
			prf[j]=a;
		}
		else{
			System.out.println("Invalid PRF Marks.Please Enter Correct Marks");
			AddStudentMarksPrf(j);
		}
	}
	public static void AddStudentMarksDbm(int j){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student's DBMS marks: ");
		int b=input.nextInt();
		if(b<=100&& b>=0){
			dbm[j]=b;
		}
		else{
			System.out.println("Invalid DBMS Marks.Please Enter Correct Marks");
			AddStudentMarksDbm(j);
		}
	}
	public static void UpdateDetails(int j){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter Student's New Name: ");
		name[j]=input.next();
		System.out.print("Name Updated Succesfully! ");
	}
	public static void UpdateMarks(int j){
		Scanner input=new Scanner(System.in);
		if(prf[j]!=-1 && dbm[j]!=-1){
			System.out.println("Student's PRF marks: "+prf[j]);
			System.out.println("Student's DBM marks: "+dbm[j]);
			System.out.println();
			System.out.print("Input New PRF Marks: ");
			prf[j]=input.nextInt();
			System.out.print("Input New DBMS Marks: ");
			dbm[j]=input.nextInt();
			System.out.print("Marks Updated Succesfully! ");
		}
		else{
			System.out.println("Student's marks yet to be added.If you want add marks select [3] in the main menu.");
		}
	}
	public static void DeleteStudent(int j){
		Scanner input=new Scanner(System.in);
		String[] tempId=new String[id.length-1];
		String[] tempName=new String[name.length-1];
		int[] tempPrf=new int[prf.length-1];
		int[] tempDbm=new int[dbm.length-1];
		double[] tempAvg=new double[avg.length-1];
		L1:for (int a = 0,i = 0; a < id.length; a++)
		{
			if(a==j){
				continue L1;
			}
			tempId[i]=id[a];
			tempName[i]=name[a];
			tempPrf[i]=prf[a];
			tempDbm[i]=dbm[a];
			tempAvg[i]=avg[a];
			i++;
		}
		id=tempId;
		name=tempName;
		prf=tempPrf;
		dbm=tempDbm;
		avg=tempAvg;
		System.out.print("Student Deleted Succesfully! ");
	}
	public static void rank(){
		L1:for (int i = 0; i < avg.length; i++)
		{
			avg[i]=(double)(prf[i]+dbm[i])/2.00;
		}
		L2:for (int k = 0; k < avg.length; k++)
		{
			double max=avg[0];
			int index=0;
			String a=id[0];
			String b=name[0];
			int c=prf[0];
			int d=dbm[0];
			for (int i = 1; i < avg.length-k; i++)
			{
				if(avg[i]>max){
					max=avg[i];
					index=i;
					a=id[i];
					b=name[i];
					c=prf[i];
					d=dbm[i];
				}
			}
			avg[index]=avg[avg.length-1-k];
			avg[avg.length-1-k]=max;
			id[index]=id[id.length-1-k];
			id[id.length-1-k]=a;
			name[index]=name[name.length-1-k];
			name[name.length-1-k]=b;
			prf[index]=prf[prf.length-1-k];
			prf[prf.length-1-k]=c;
			dbm[index]=dbm[dbm.length-1-k];
			dbm[dbm.length-1-k]=d;
		}
		for (int i = 0; i < id.length/2; i++)
		{
			String s=id[i];
			id[i]=id[id.length-1-i];
			id[id.length-1-i]=s;
			String t=name[i];
			name[i]=name[name.length-1-i];
			name[name.length-1-i]=t;
		}
		for (int i = 0; i < prf.length/2; i++)
		{
			int u=prf[i];
			prf[i]=prf[prf.length-1-i];
			prf[prf.length-1-i]=u;
			int v=dbm[i];
			dbm[i]=dbm[dbm.length-1-i];
			dbm[dbm.length-1-i]=v;
			double w=avg[i];
			avg[i]=avg[avg.length-1-i];
			avg[avg.length-1-i]=w;
		}
	}
	public static void PrintDetails(int j){
		System.out.printf("+-------------------------------------------+-----------------------+\n");
		System.out.printf("%s%-41s%s%-15s%9s\n","| ","Programming Fundamental Marks"," | ",prf[j]," | ");
		System.out.printf("%s%-41s%s%-15s%9s\n","| ","Database Management Systems Marks"," | ",dbm[j]," | ");
		System.out.printf("%s%-41s%s%-15s%9s\n","| ","Total"," | ",(prf[j]+dbm[j])," | ");
		System.out.printf("%s%-41s%s%-15s%9s\n","| ","Average"," | ",(avg[j])," | ");
		System.out.printf("%s%-41s%s%-15s%9s\n","| ","Rank"," | ",(j+1)," | ");
		System.out.printf("+-------------------------------------------+-----------------------+\n");
		System.out.print("Student Details Displayed above!" );
	}
	public static void PrintRanks(){
		System.out.printf("+---------+-----------+------------------------------------------+----------------------------+---------------------+\n");
		System.out.printf("%-10s%-12s%-43s%-29s%-22s%s","| Rank","| ID","| Name","| Total Marks","| Average Marks","|\n");
		System.out.printf("+---------+-----------+------------------------------------------+----------------------------+---------------------+\n");
		L1:for (int i = 0, a = 0 ; a < avg.length; a++)
		{
			if(prf[i]<0 && dbm[i]<0){
				continue L1;
			}
			System.out.printf("%s%-9s%s%-11s%s%-42s%s%-28s%s%-21s%s","|",(a+1),"|",id[a],"|",name[a],"|",(prf[a]+dbm[a]),"|",(avg[a]),"|\n");
			i++;
		}
		System.out.printf("+---------+-----------+------------------------------------------+----------------------------+---------------------+\n");
	}
	public static void rankPrf(){
		L1:for (int k = 0; k < prf.length; k++)
		{
			int max=prf[0];
			int index=0;
			String a=id[0];
			String b=name[0];
			int c=dbm[0];
			for (int i = 1; i < prf.length-k; i++)
			{
				if(prf[i]>max){
					max=prf[i];
					index=i;
					a=id[i];
					b=name[i];
					c=dbm[i];
				}
			}
			prf[index]=prf[prf.length-1-k];
			prf[prf.length-1-k]=max;
			id[index]=id[id.length-1-k];
			id[id.length-1-k]=a;
			name[index]=name[name.length-1-k];
			name[name.length-1-k]=b;
			dbm[index]=dbm[dbm.length-1-k];
			dbm[dbm.length-1-k]=c;
		}
		for (int i = 0; i < id.length/2; i++)
		{
			String s=id[i];
			id[i]=id[id.length-1-i];
			id[id.length-1-i]=s;
			String t=name[i];
			name[i]=name[name.length-1-i];
			name[name.length-1-i]=t;
		}
		for (int i = 0; i < prf.length/2; i++)
		{
			int u=prf[i];
			prf[i]=prf[prf.length-1-i];
			prf[prf.length-1-i]=u;
			int v=dbm[i];
			dbm[i]=dbm[dbm.length-1-i];
			dbm[dbm.length-1-i]=v;
		}
	}
	public static void BestInPrf(){
		System.out.printf("+---------+-----------------------------------------------------+---------------------------+-----------------------+\n");
		System.out.printf("%-10s%-54s%-28s%-24s%s","| ID","| Name","| PF Marks","| DBMS Marks","|\n");
		System.out.printf("+---------+-----------------------------------------------------+---------------------------+-----------------------+\n");
		L1:for (int i = 0, a = 0 ; a < avg.length; a++)
		{
			if(prf[i]<0 && dbm[i]<0){
				continue L1;
			}
			System.out.printf("%s%-9s%s%-53s%s%-27s%s%-23s%s","|",id[a],"|",name[a],"|",prf[a],"|",dbm[a],"|\n");
			i++;
		}
		System.out.printf("+---------+-----------------------------------------------------+---------------------------+-----------------------+\n");
	}
	public static void rankDbm(){
		L1:for (int k = 0; k < dbm.length; k++)
		{
			int max=dbm[0];
			int index=0;
			String a=id[0];
			String b=name[0];
			int c=prf[0];
			for (int i = 1; i < dbm.length-k; i++)
			{
				if(dbm[i]>max){
					max=dbm[i];
					index=i;
					a=id[i];
					b=name[i];
					c=prf[i];
				}
			}
			dbm[index]=dbm[dbm.length-1-k];
			dbm[dbm.length-1-k]=max;
			id[index]=id[id.length-1-k];
			id[id.length-1-k]=a;
			name[index]=name[name.length-1-k];
			name[name.length-1-k]=b;
			prf[index]=prf[dbm.length-1-k];
			prf[prf.length-1-k]=c;
		}
		for (int i = 0; i < id.length/2; i++)
		{
			String s=id[i];
			id[i]=id[id.length-1-i];
			id[id.length-1-i]=s;
			String t=name[i];
			name[i]=name[name.length-1-i];
			name[name.length-1-i]=t;
		}
		for (int i = 0; i < prf.length/2; i++)
		{
			int u=prf[i];
			prf[i]=prf[prf.length-1-i];
			prf[prf.length-1-i]=u;
			int v=dbm[i];
			dbm[i]=dbm[dbm.length-1-i];
			dbm[dbm.length-1-i]=v;
		}
	}
	public static void BestInDbm(){
		System.out.printf("+---------+-----------------------------------------------------+---------------------------+-----------------------+\n");
		System.out.printf("%-10s%-54s%-28s%-24s%s","| ID","| Name","| DBMS Marks","| PF Marks","|\n");
		System.out.printf("+---------+-----------------------------------------------------+---------------------------+-----------------------+\n");
		L1:for (int i = 0, a = 0 ; a < avg.length; a++)
		{
			if(prf[i]<0 && dbm[i]<0){
				continue L1;
			}
			System.out.printf("%s%-9s%s%-53s%s%-27s%s%-23s%s","|",id[a],"|",name[a],"|",dbm[a],"|",prf[a],"|\n");
			i++;
		}
		System.out.printf("+---------+-----------------------------------------------------+---------------------------+-----------------------+\n");
	}
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		while(true){
			HomePage();
			System.out.print("Enter Option to continue: ");
			int op=input.nextInt();
			ClearConsol();
			if(op==1){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%65s%50s%s\n","|","ADD NEW STUDENT"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.print("Enter new student ID: ");
					String a=input.next();
					if(searchId(id,a)>=0){
						System.out.println("This student ID already exist! ");
						System.out.print("Do you want to add another student(Y/N): ");
					}
					else{
						AddStudent(a);
						System.out.print("Student added succesfully! ");
						System.out.print("Do you want to add another student(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==2){	
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%70s%45s%s\n","|","ADD STUDENT WITH MARKS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.print("Enter new student ID: ");
					String a=input.next();
					if(searchId(id,a)>=0){
						System.out.println("This student ID already exist! ");
						System.out.print("Do you want to add another student(Y/N): ");
					}
					else{
						AddStudentWithMarks(a);
						System.out.print("Marks Added Succesfully! ");
						System.out.print("Do you want to add another student(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==3){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%55s%60s%s\n","|","ADD MARKS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.print("Enter Student ID: ");
					String x=input.next();
					int j=searchId(id,x);
					if(j>=0){
						System.out.println("Student Name: "+name[j]);
						AddMarks(j);
						System.out.print("Do you want to add another student mark(Y/N): ");
					}
					else{
						System.out.print("This Student ID Doesn't exist! Do you want to search again(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==4){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%70s%45s%s\n","|","UPDATE STUDENT DETAILS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.print("Enter Student ID: ");
					String x=input.next();
					int j=searchId(id,x);
					if(j>=0){
						System.out.println("Student Name: "+name[j]);
						UpdateDetails(j);
						System.out.print("Do you want to update another student marks(Y/N): ");
					}
					else{
						System.out.print("This Student ID Doesn't exist! Do you want to search again(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==5){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%65s%50s%s\n","|","UPDATE MARKS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.print("Enter Student ID: ");
					String x=input.next();
					int j=searchId(id,x);
					if(j>=0){
						System.out.println("Student Name: "+name[j]);
						UpdateMarks(j);
						System.out.print("Do you want to update another student details(Y/N): ");
					}
					else{
						System.out.print("This Student ID Doesn't exist! Do you want to search again(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==6){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%55s%60s%s\n","|","DELETE STUDENT"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.print("Enter Student ID: ");
					String x=input.next();
					int j=searchId(id,x);
					if(j>=0){
						System.out.println("Student Name: "+name[j]);
						DeleteStudent(j);
						System.out.print("Do you want to delete another student details(Y/N): ");
					}
					else{
						System.out.print("This Student ID Doesn't exist! Do you want to search again(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==7){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%70s%45s%s\n","|","PRINT STUDENT DETAILS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					rank();
					System.out.print("Enter Student ID: ");
					String x=input.next();
					int j=searchId(id,x);
					if(j>=0){
						System.out.println("Student's ID         : "+id[j]);
						System.out.println("Student's Name       : "+name[j]);
						if(prf[j]<0 || dbm[j]<0){
							System.out.println("Marks yet to be added...");
						}
						else{
							PrintDetails(j);
						}
						System.out.print("Do you want to print another student details(Y/N): ");
					}
					else{
						System.out.print("This Student ID Doesn't exist! Do you want to search again(Y/N): ");
					}
					c=input.next().charAt(0);
					if(c=='y'){
						ClearConsol();
						continue L1;
					}
					else{
						break;
					}
				}while(c=='y');
			}
			ClearConsol();
			if(op==8){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%70s%45s%s\n","|","PRINT STUDENT RANKS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					System.out.println();
					rank();
					PrintRanks();
					System.out.print("Do you want to go back to main menu(Y/N): ");
					c=input.next().charAt(0);
					if(c!='y'){
						ClearConsol();
						continue L1;
					}
				}while(c!='y');
			}
			ClearConsol();
			if(op==9){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%70s%45s%s\n","|","BEST IN PROGRAMMING FUNDAMENTALS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					rankPrf();
					BestInPrf();
					System.out.print("Do you want to go back to main menu(Y/N): ");
					c=input.next().charAt(0);
					if(c!='y'){
						ClearConsol();
						continue L1;
					}
				}while(c!='y');
			}
			ClearConsol();
			if(op==10){
				char c;
				L1:do{
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.printf("%s%70s%45s%s\n","|","BEST IN DATABASE MANAGEMENT SYSTEMS"," ","|");
					System.out.printf("---------------------------------------------------------------------------------------------------------------------\n");
					System.out.println();
					rankDbm();
					BestInDbm();
					System.out.print("Do you want to go back to main menu(Y/N): ");
					c=input.next().charAt(0);
					if(c!='y'){
						ClearConsol();
						continue L1;
					}
				}while(c!='y');
			}
			ClearConsol();
		}
	}
}
