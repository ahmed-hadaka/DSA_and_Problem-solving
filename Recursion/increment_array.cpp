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

void increment_arr(int arr[], int len) {
	if (len == 0)
		return;
	increment_arr(arr, len - 1);
	arr[len - 1] += len - 1;

//	cout << increment_arr(arr, len - 1) + arr[len - 1] << "  ";
//	return len;
}

int main() {
	int length = 5;
	int arr[length] = { 1, 8, 2, 10, 3 };
	increment_arr(arr, length);
	for (int i = 0; i < length; ++i) {
		cout << arr[i] << " ";
	}
	return 0;
}
