/*
ID: Benson.2
LANG: C++
TASK: cowtour
*/
#include <stdio.h>
#include <algorithm>
#include <string>
#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main ()
{
	//freopen ("in.txt","r",stdin);
	freopen ("cowtour.in","r",stdin);
	freopen ("cowtour.out","w",stdout);
	int n;
	cin>>n;
	int cX[n];
	int cY[n];
	double dist [n][n];
	for (int x=0;x<n;x++)
	{
		cin>>cX[x];
		cin>>cY[x];
	}
	for (int y=0;y<n;y++)
	{
		for (int x=0;x<n;x++)
		{
			dist[y][x]=dist[x][y]=sqrt (pow(cX[y]-cX[x],2)+pow(cY[y]-cY[x],2));
		}
	}
	getchar();
	for (int y=0;y<n;y++,getchar())
	{
		for (int x=0;x<n;x++)
		{
			dist[y][x]*=getchar()=='0'?-1:1;
		}
	}
	for (int k=0;k<n;k++)
	{
		for (int i=0;i<n;i++)
		{
			for (int j=0;j<n;j++)
			{
				if (dist[i][k]>0&&dist[k][j]>0)
				{
					dist [i][j]=dist[i][j]<0?dist[i][k]+dist[k][j]:min (dist [i][j],dist[i][k]+dist[k][j]);
				}
			}
		}
	}
	double best1=0;
	double best2=1000000;
	for (int i=0;i<n;i++)
		for (int j=0;j<n;j++)
			best1=max(best1,dist[i][j]);
	
	for (int i=0;i<n;i++)
	{
		for (int j=i+1;j<n;j++)
		{
			if (dist[i][j]<0)
			{
				double d1=0,d2=0;
				for (int k=0;k<n;k++)
				{
					d1=max(d1,dist[i][k]);
					d2=max(d2,dist[j][k]);
				}
				best2=min(best2,d1+d2-dist[i][j]);
			}
		}
	}		
	cout<<setprecision(6) << fixed <<max(best2,best1)<<"\n";
}

