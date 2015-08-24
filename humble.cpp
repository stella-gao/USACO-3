/*
ID: Benson.2
LANG: C++
TASK: humble
*/
#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string>
#include <cmath>
#include <climits>

using namespace std;

long search (long p,long min[],long count,long max,long key)
{
	long low=0;
	long high=count-1;
	long index=(high+low)/2;
	long next;
	bool bro=false;
	while (true)
	{
		if (high<low||min[index]>key)
		{
			bro=true;
			break;
		}
		next=min[index]*p;
		if ((index==0&&next>max)||(next>max&&min[index-1]*p<=max))
		{
			break;
		}
		if (next>max)
		{
			high=index-1;
		}
		else
		{
			low=index+1;
		}
		index=(high+low)/2;
	}
	if (bro)
	{
		return LONG_MAX;
	}
	else
	return next;
}

int main ()
{
	freopen ("in.txt","r",stdin);
	//freopen ("humble.in","r",stdin);
	//freopen ("humble.out","w",stdout);
	
	long k,n;
	cin>>k>>n;
	long p[k];
	int j[k];
	for (int x=0;x<k;x++)
	{
		int temp;
		cin>>temp;
		p[x]=temp;
		j[x]=LONG_MAX/p[x];
	}
	long currentM;
	long min[n+1];
	long max;
	min[0]=1;
	for (long z=0;z<n;z++)
	{
		currentM=LONG_MAX;
		max=min[z];

		for (long y=0;y<k;y++)
		{	
			currentM=std::min(currentM,search (p[y],min,z+1,max,j[y]));	
			if (currentM==min[z]+1)	
				break;
		}
		if (z%9999==0)cout<<"yo\n";
		min[z+1]=currentM;
	}
	cout<<min[n]<<"\n";
}
