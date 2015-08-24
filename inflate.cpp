/*
ID: Benson.2
LANG: C++
TASK: inflate
*/
#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string>

using namespace std;

int main ()
{
	//freopen ("in.txt","r",stdin);
	freopen ("inflate.in","r",stdin);
	freopen ("inflate.out","w",stdout);
	int h,n;
	cin>>h>>n;
	int p[n];
	int m[n];
	int best[h+1];
	for (int x=0;x<=h+1;x++)
	{
		best[x]=0;
	}
	for (int x=0;x<n;x++)
	{
		cin>>p[x]>>m[x];
	}
	for (int x=0;x<=h;x++)
	{
		for (int y=0;y<n;y++)
		{
			if (x-m[y]>=0)
			{
				best[x]=max(best[x-m[y]]+p[y],best[x]);
			}
		}
	}
	cout<<best[h]<<"\n";
}
