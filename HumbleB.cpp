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
#include <functional>
#include <queue>
#include <vector>

using namespace std;
 
template<typename T> void print_queue(T& q) 
{
    while(!q.empty()) 
	{
        std::cout << q.top() << " ";
        q.pop();
    }
    std::cout << '\n';
}

int main() 
{
	freopen ("in.txt","r",stdin);
	//freopen ("humble.in","r",stdin);
	//freopen ("humble.out","w",stdout);
	
	int k,n;
	cin>>k>>n;
	int p[k];
	int j[k];
	int ans[n+10000];
//	for (int x=0;x<n+10000;x++)
//		ans[x]=INT_MAX;
	for (int x=0;x<k;x++)
	{
		int temp;
		cin>>temp;
		p[x]=temp;
		j[x]=LONG_MAX/p[x];
	}
	
    std::priority_queue<int, std::vector<int>, std::greater<int> > q;
 
	for(int x=0;x<k ;x++)
	{
        q.push(p[x]*1);
    }
	int count=0;  
	int largest=p[k-1]; 
 	int next;
 	int prod;
    while (!q.empty())
    {
    	cout<<q.size()<<"\n";
    //	cout<<largest<<"\n";
    	next=q.top();
    	q.pop();
    	ans[count]=next;
    	if (count+q.size()<n)
    	{
    		for (int x=0;x<k;x++)
    		{
    			if (next<=j[x])
    			{
    				prod=p[x]*next;
    				q.push(prod);
    				largest=std::max(largest,prod);
				}
			}		
		}
		else
		{
			for (int x=0;x<k;x++)
    		{
    			prod=p[x]*next;
    			if (prod>largest||next>j[x])
    			{
    				break;
				}
    			q.push(prod);
			}
		}
		count++;
	}

	int dist=0;
//	for (int x=0;x<count+1;x++)
//	cout<<ans[x]<<"\n";
	for (int x=0;x<count+1;x++)
	{
		if (ans[x]==0)continue;
		if (ans[x]!=ans[x-1])dist++;
		if (dist==n)
		{
			cout<<ans[x]<<"\n";
			break;
		}
	}
}
