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

bool is_palindrome(int arr[], int start, int end) {
	if (start >= end) {
		return true;
	}
	if (arr[start] != arr[end])
		return false;
	return is_palindrome(arr, ++start, --end);
}

int main() {
	int length = 5, start = 0, end = length - 1;
	int arr[length] = { 1, 3, 4, 2, 1 };
	//  0   1  2  3   4
	cout << is_palindrome(arr, start, end);
	return 0;
}

