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

int suffix_sum(int arr[], int len, int pos) {
//	pos--;
	if (pos == len - 1)
		return arr[pos];
	int sub_sum = suffix_sum(arr, len, pos + 1);
	return arr[pos] + sub_sum;
}

int main() {
	int length = 5, start = 4;
	int arr[length] = { 1, 3, 4, 6, 7 };
	//  0   1  2  3   4
	cout << suffix_sum(arr, length, --start);
	return 0;
}

