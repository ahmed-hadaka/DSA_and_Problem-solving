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

void accumulate(int arr[], int len) {
	if (len == 0)
		return;

	accumulate(arr, len - 1);
	arr[len - 1] += arr[len - 2];
}

int main() {
	int length = 5;
	int arr[length] = { 1, 8, 2, 10, 3 };
	//  1, 9, 11, 21, 24
	accumulate(arr, length);
	for (int i = 0; i < length; ++i) {
		cout << arr[i] << " ";
	}
	return 0;
}
