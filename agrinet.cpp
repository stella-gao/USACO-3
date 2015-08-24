/*
ID: Benson.2
LANG: C++
TASK: agrinet
*/

#include <stdio.h>
#include <string>
#include <iostream>
#include <algorithm>

using namespace std;
int cost;

int find(bool a[],int d[][100],int n)
{
	int min=1000000;
	int index=0;
	for (int x=0;x<n;x++)
	{
		if (a[x])
		{
			for (int k=0;k<n;k++)
			{
				if (a[k])continue;
				if (d[x][k]<min)
				{
					min=d[x][k];
					index=k;
				}
			}
		}
	}
	cost+=min;
	return index;
}

int main ()
{
	//freopen ("in.txt","r",stdin);
	freopen ("agrinet.in","r",stdin);
	freopen ("agrinet.out","w",stdout);
	int n;
	cin>>n;
	int dist [n][100];
	for (int x=0;x<n;x++)
		for (int y=0;y<n;y++)
			cin>>dist[y][x];
			
	bool included [n];
	
	for (int x=0;x<n;x++)
		included[x]=false;
	
	int count=1;
	cost=0;
	included[0]=true;
	while (count<n)
	{
		included[find(included,dist,n)]=true;
		count++;
	}
	
	cout<<cost<<"\n";
}
