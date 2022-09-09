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

int power(int base, int os = 2) {
	if (os == 0)
		return 1;
	return base * power(base, os - 1);
}

int main() {

	cout << power(2, 3);

	return 0;
}

