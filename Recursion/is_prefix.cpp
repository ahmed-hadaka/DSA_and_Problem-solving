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

bool is_prefix(string main, string prefix, int start) {
	if (start < 0)
		return true;
	if (main[start] != prefix[start])
		return false;
	return is_prefix(main, prefix, --start);
}

int main() {
	string main = "abcdefgh", prefix = "abd";
	int start = prefix.length() - 1;
	cout << is_prefix(main, prefix, start);
	return 0;
}

