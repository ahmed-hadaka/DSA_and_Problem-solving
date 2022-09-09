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

int i = 0;

void print_reverse(int n) {
	if (n == 0)
		return;
	print_reverse(n - 1);
	for (int i = 0; i < n; ++i) {
		cout << '*';
	}
	cout << "\n";
}

void print(int n) {
	if (n == 0)
		return;
	for (int i = 0; i < n; i++) {
		cout << "*";
	}
	cout << "\n";
	print(n - 1);
}
int main() {
	print_reverse(5);
	return 0;
}
