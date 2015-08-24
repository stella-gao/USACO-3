/*
ID: Benson.2
LANG: C++
TASK: humble
*/
#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <string>
#include <set>

using namespace std;

int main ()
{
	//freopen ("in.txt","r",stdin);
	freopen ("humble.in","r",stdin);
	freopen ("humble.out","w",stdout);
	
	int k,n;
	cin>>k>>n;
	int p[k];
	set<int> si;
	set<int>::iterator it;
	for (int x=0;x<k;x++)
	{
		cin>>p[x];
		si.insert(p[x]);
	}
	for (int x=0;x<k;x++)
	{
		it=si.begin();
		while (true)
		{
		    int t = (*it)*p[x];
            if(t<0) break;
            if(si.size()>n)
            {
                si.erase(--si.end());
                if(t>(*(--si.end()))) break;
            }
            si.insert(t);
            it++;
		}
	}
	cout<<*(--si.end())<<endl;
}

