package Garage;
import java.util.Arrays;
import java.util.Comparator;

public class ParkIn{
	public static boolean isFirstConf= false;
	public static Slot slots[];  

	public static void setSize(int size) {
		slots=new Slot[size];  	
		for(int i =0 ;i<size;i++) {
			slots[i] = new Slot(i+1);
		}
	}
	
	private static void fisrtIn(double cw,double cp,String modelYear,int id,String modelName ) throws Exception{
		boolean flag =false ; 
		for(int i =0 ;i<slots.length;i++) {
			if(cp<=slots[i].depth&&cw<=slots[i].width&&!slots[i].isActive) {
				flag = true;
				slots[i].isActive = true; 
				slots[i].vehicle = new Vehicle(cw,cp,modelYear,id, modelName);
				break;
			}
		}
		if(!flag)
			throw new Exception("there is no enough space!"); 
	}
	
	
	private static void mostFit(double cw,double cp,String modelYear,int id,String modelName )throws Exception{
		Arrays.sort(slots,new Comparator<Slot>() {
			@Override
			public int compare(Slot o1, Slot o2) {
				double x =o1.width - o2.width;
				int num =0 ;
				if(x==0)num= 0;
				else if (x>0)num=1; 
				else if (x<0)num= -1;
				return num;
			}
		});
		Arrays.sort(slots,new Comparator<Slot>() {
			@Override
			public int compare(Slot o1, Slot o2) {
	        	double x = o1.depth - o2.depth;
	        	int num =0 ;
	        	if(x==0)num= 0;
	        	else if (x>0)num=1; 
	        	else if (x<0)num= -1;
				return num;
			}
		});
		boolean flag1 =false ; 
		int i =0 ;
		for( i= 0;i<slots.length;i++) {
			if(cp<=slots[i].depth&&cw<=slots[i].width&&!slots[i].isActive) {
				flag1 = true;
				break;
			}
		}
		double firstPair [] = {i,slots[i].width*slots[i].depth};
		Arrays.sort(slots,new Comparator<Slot>() {
			@Override
			public int compare(Slot o1, Slot o2) {
				double x =o1.width - o2.width;
				int num =0 ;
				if(x==0)num= 0;
				else if (x>0)num=1; 
				else if (x<0)num= -1;
				return num;
			}
		});
		boolean flag2 =false ; 
		i =0 ;
		for( i= 0;i<slots.length;i++) {
			if(cp<=slots[i].depth&&cw<=slots[i].width&&!slots[i].isActive) {
				flag2 = true;
				break;
			}
		}
		double secondPair [] = {i,slots[i].width*slots[i].depth};
		if(flag1||flag2) {
			if(firstPair[1]<secondPair[1])
				slots[(int) firstPair[0]].isActive = true;
			else 
				slots[(int) secondPair[0]].isActive = true;	
			slots[i].isActive = true; 
			slots[i].vehicle = new Vehicle(cw,cp,modelYear,id,modelName);
		}else {
			throw new Exception("there is no enough space!");
		}
	}
	
	
	public static void park(double cw,double cd,String modelYear,int id, String modelName) throws Exception {
		if(isFirstConf)
			fisrtIn(cw,cd,modelYear,id,modelName);
		else 
			mostFit(cw,cd,modelYear,id,modelName);
	}
	public static void setDimantion(double w,double d,int index) throws Exception {
		if(w<=0||d<=0)throw new Exception("Wrong dimantions!");
		slots[index].width = w;
		slots[index].depth = d;
	}
	
	public static void DisplayAvliSlots() {
		Arrays.sort(slots,new Comparator<Slot>() {
			@Override
			public int compare(Slot o1, Slot o2) {
				return o1.getID() - o2.getID();
			}
		});
		for(int i =0 ;i<slots.length;i++) {
			if(!slots[i].isActive) {
				System.out.print(slots[i].getID());
				System.out.print (" ");				
			}
		}
		System.out.print('\n');
	}
	public static void PrintTest() {
		for(int i =0 ;i<slots.length;i++) {
			System.out.println(slots[i].width+ " , "+slots[i].depth);
		}
	}
	
}
