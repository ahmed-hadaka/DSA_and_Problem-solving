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
int i = 1;
void _3th_n(int n) {
	if (n == 1) {
		cout << 1;
		return;
	}
	cout << n << " ";
	if (n % 2 == 0) { // even
		_3th_n(n / 2);
	} else
		_3th_n(3 * n + 1);
	i++;
	//to compute the length
}

int main() {
	_3th_n(6);
	cout << "\n" << i;
	return 0;
}
