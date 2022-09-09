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

int get_max(int arr[], int length) { // array max
	if (length == 0)
		return -1;
	return max(get_max(arr, length - 1), arr[length - 1]);
}

int get_sum(int arr[], int length) { // array sum
	if (length == 0)
		return 0;
	return get_sum(arr, length - 1) + arr[length - 1];
}
int i = 1;
double get_avg(int arr[], int length) { // array average
	if (length == 1)
		return arr[0];
	return ((get_avg(arr, length - 1) * (length - 1)) + arr[length - 1])
			/ length;
}

int main() {
	int length = 5;
	int arr[length] = { 1, 2, 10, 8, 3 };
	cout << get_avg(arr, length);
	return 0;
}
