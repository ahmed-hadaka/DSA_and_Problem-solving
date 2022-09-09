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


void right_max(int arr[], int len, int pos = 0) {
	if (pos == len - 1)
		return;

	right_max(arr, len, pos + 1);
	arr[pos] = max(arr[pos], arr[pos + 1]);
}

int main() {
	int length = 5;
	int arr[length] = { 1, 8, 2, 10, 3 };
	//  10  10 10  10  3
	right_max(arr, length, 0);
	for (int i = 0; i < length; ++i) {
		cout << arr[i] << " ";
	}
	return 0;
}

