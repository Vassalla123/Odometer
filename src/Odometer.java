import java.util.ArrayList;

public class Odometer {
	int digits;
	public ArrayList<Integer> validReadings;
	public final int lowestReadings[]={1,12,123,1234,12345,123456,1234567,12345678};
	public final int highestReadings[]={9,89,789,6789,56789,456789,3456789,23456789};
	public Odometer(int digits)
	{
		this.digits=digits;
		validReadings=new ArrayList<Integer>();
		for(int i=lowestReadings[digits-1];i<=highestReadings[digits-1];i++)
		{
			if(isValid(i))
			{
				validReadings.add(i);
			}
		}
		
	}
	
	
	
	public int nextReading(int reading)
	{   
		int index=validReadings.indexOf(reading);
		if(index!=validReadings.size()-1)
		
			return validReadings.get(index+1); 
		
		
			return validReadings.get(0);
	}
	public int prevReading(int reading)
	{
		int index=validReadings.indexOf(reading);
		if(index!=0)
			return validReadings.get(index-1); 
		
			return validReadings.get(validReadings.size()-1);
	}
	public int nextReading(int reading,int n)
	{
		for(int i=0;i<n;i++)
		{
			reading=nextReading(reading);
		}
		return reading;
	}
	public int prevReading(int reading,int n)
	{
		for(int i=0;i<n;i++)
		{
			reading=prevReading(reading);
		}
		return reading;
	}
	public int difference(int a,int b)
	{
		return validReadings.indexOf(Math.max(a, b))-validReadings.indexOf(Math.min(a, b));
		
	}
	
	public boolean isValid(int reading)
	{
		String str=Integer.toString(reading);
		char arr[]=str.toCharArray();
		for(int i=0;i<arr.length-1;i++ )
		{
			if(arr[i]>=arr[i+1])
				return false;
			
		}
		return true;
		
	}
	public static void main(String args[])
	{
		Odometer odometer=new Odometer(4);
//		for(int a:odometer.validReadings)
//		{
//			System.out.println(a);
//		}
		//System.out.println(odometer.difference(1234,5678));
		System.out.println(odometer.prevReading(1234));
		System.out.println(odometer.nextReading(6789));

	}

}
