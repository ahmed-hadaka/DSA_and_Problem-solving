//============================================================================
// Name        : test_pro.cpp
// Author      : Ahmed_hadaka
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <cmath>
using namespace std;

int prefix_sum(int arr[], int pos) {
	if (pos == 0)
		return arr[0];
	int sub_sum = prefix_sum(arr, pos - 1);
	return sub_sum + arr[pos];
}

int main() {
	int length = 5, start = 5;
	int arr[length] = { 1, 3, 4, 6, 7 };
	//  0   1  2  3   4
	cout << prefix_sum(arr, --start);
	return 0;
}

